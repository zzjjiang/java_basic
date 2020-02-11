package com.zzj.clazz.classloader.myloader;

import java.io.*;

public class MyClassLoader extends ClassLoader {

    /**
     * 这里是编译好的class文件
     */
    private static final String  WIFE_CLASSPATH = "/Users/zujiangzou/Desktop/Wife.class";

    public byte[] loadClassData() throws Exception {
        byte[] data =null;
        InputStream is = null;
        ByteArrayOutputStream bos = null;
        try {
            bos = new ByteArrayOutputStream();
            is = new FileInputStream(new File(WIFE_CLASSPATH));
            int ch;
            while (-1 != (ch = is.read())){
                bos.write(ch);
            }
            bos.flush();
            data = bos.toByteArray();
        }catch (Exception e){

        }finally {
            if(is != null){
                is.close();
            }
            if(bos != null){
                bos.close();
            }
        }
        return data;
    }

    @Override
    protected Class<?> findClass(String name) {
        byte[] data = null;
        try {
            data = loadClassData();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defineClass(name,data,0,data.length);
    }
}
