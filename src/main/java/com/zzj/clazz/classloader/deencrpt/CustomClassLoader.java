package com.zzj.clazz.classloader.deencrpt;


import java.io.File;
/*
 * 类说明：自定义的类加载器,进行异或解密。URL
 */

public class CustomClassLoader extends ClassLoader{

    private final String name;
    private String basePath;
    private final static String FILE_EXT = ".classen";

    public CustomClassLoader(String name) {
        super();
        this.name = name;
    }
    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    private byte[] loadClassData(String name){
        byte[] data = null;
        XorEncrpt demoEncryptUtil = new XorEncrpt();
        try {
        	String tempName = name.replaceAll("\\.","/");
        	//解密
            data = demoEncryptUtil.decrypt(new File(basePath+tempName+FILE_EXT));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

//    @Override
//    public Class<?> loadClass(String name) throws ClassNotFoundException {
//        if(name.indexOf("java.")<5&&name.indexOf("java.")>-1){
//            return super.loadClass(name);
//        }
//        byte[] data = this.loadClassData(name);
//        if (data == null){
//            return super.loadClass(name);
//        }
//        return this.defineClass(name,data,0,data.length);
//    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        System.out.println("zzzjjjj" + name);
        byte[] data = this.loadClassData(name);
        return this.defineClass(name,data,0,data.length);
    }
}
