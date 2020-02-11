package com.zzj.proxy.myProxy;

import java.io.*;

public class MyClassLoader extends ClassLoader {

    private File dir;

    MyClassLoader(String path) {
        dir = new File(path);
    }


    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        if(dir != null) {
            File clazzFile = new File(dir,name + ".class");

            if(clazzFile.exists()) {
                try {
                    FileInputStream inputStream = new FileInputStream(clazzFile);

                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                     byte[] buffer = new byte[1024];
                     int len;
                     while((len = inputStream.read(buffer)) != -1) {
                        byteArrayOutputStream.write(buffer,0,len);
                     }

                     //返回反射对象
                     return defineClass("com.zhuguang.jack.myProxy." + name,byteArrayOutputStream.toByteArray(),0,
                             byteArrayOutputStream.size());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return super.findClass(name);
    }
}
