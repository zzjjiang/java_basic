package com.zzj.io.stream.ext.pipedstream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @author Jone
 * @version 1.0.0
 * @Description 管道流主要是实现两个线程之间的io操作
 * @createTime 2020年02月14日 14:21
 */
public class PipedStreamDemo {

    public static void main(String[] args) throws Exception {
        SendThread sendThread = new SendThread();
        ReceiveThread receiveThread = new ReceiveThread();
        PipedOutputStream pos = sendThread.getPos();
        PipedInputStream pis = receiveThread.getPis();
        //连接管道流
        pos.connect(pis);
        new Thread(sendThread).start();
        new Thread(receiveThread).start();
    }



}
class SendThread implements Runnable {
    private PipedOutputStream pos;
    public SendThread(){
        this.pos = new PipedOutputStream();
    }

    public PipedOutputStream getPos() {
        return pos;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                pos.write(("第" + i + "次,发送iamjone").getBytes());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            pos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ReceiveThread implements Runnable {
    private PipedInputStream pis;

    public ReceiveThread(){
        this.pis = new PipedInputStream();
    }

    @Override
    public void run() {
        byte[] bytes =  new byte[1024];
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            int len = 0;
            while((len = pis.read(bytes)) != -1){
                bos.write(bytes,0,len);
            }
            System.out.println(new String(bos.toByteArray()));
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                pis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public PipedInputStream getPis() {
        return pis;
    }
}