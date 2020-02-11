package com.zzj.proxy.myProxy;


import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyProxy {

    private static String rt = "\r\n";

    private static String path = "E:\\idea\\public\\lesson20190305-aop\\src\\main\\java\\com\\zhuguang\\jack\\myProxy";

    public static Object newProxyInstance(ClassLoader loader,
                                          Class<?>[] interfaces,
                                          MyInvocationHandler h) {

        //1、以字符串的形式拼凑出一个代理类
        String javaStr = getJavaStr(interfaces);
        //2、以流的方式写到java文件里面
        createFile(javaStr);
        //3、java文件动态编译成.class文件
        compiler();
        //4、自定义类加载器把磁盘里面的.class文件加载到内存
        //5、实例化这个内存里面的类然后把把实例返回
        MyClassLoader myClassLoader = new MyClassLoader(path);
        try {
            Class<?> $Proxy0 = myClassLoader.findClass("$Proxy0");

            Constructor<?> constructor = $Proxy0.getConstructor(MyInvocationHandler.class);
            Object o = constructor.newInstance(h);

            return o;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void createFile(String javaStr) {
        File file = new File(path + "\\$Proxy0.java");
        try {
            FileWriter fw = new FileWriter(file);
            fw.write(javaStr);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    * 运行时编译.java文件
    * */
    private static void compiler() {
        try {
            JavaCompiler systemJavaCompiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager standardFileManager = systemJavaCompiler.getStandardFileManager(null, null, null);
            Iterable<? extends JavaFileObject> javaFileObjects = standardFileManager.getJavaFileObjects(path + "\\$Proxy0.java");

            JavaCompiler.CompilationTask task = systemJavaCompiler.getTask(null, standardFileManager, null, null, null, javaFileObjects);
            task.call();
            standardFileManager.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getJavaStr(Class<?>[] interfaces) {

        Method[] methods = interfaces[0].getMethods();

        String proxyClassStr = "package com.zhuguang.jack.myProxy;" + rt
                + "import java.lang.reflect.Method;" + rt
                + "public class $Proxy0 implements " + interfaces[0].getName()
                + "{" + rt + "MyInvocationHandler h;" + rt
                + "public $Proxy0(MyInvocationHandler h) {" + rt
                + "this.h=h;" + rt + "}"
                + getMethodString(methods, interfaces[0]) + rt + "}";

        return proxyClassStr;
    }

    private static String getMethodString(Method[] methods, Class intf) {

        String proxyMe = "";

        for (Method method : methods) {
            proxyMe += "public void " + method.getName()
                    + "() throws Throwable {" + rt + "Method md = "
                    + intf.getName() + ".class.getMethod(\"" + method.getName()
                    + "\",new Class[]{});" + rt
                    + "this.h.invoke(this,md,null);" + rt + "}" + rt;

        }

        return proxyMe;
    }
}
