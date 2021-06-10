package com.rocketmq;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

/**
 * @author zouzujiang
 */
public class ProduceCase {

    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("4sync");
        producer.setNamesrvAddr("localhost:9876");
        producer.start();
        for (int i = 0; i < 3; i++) {
            Message message = new Message();
            String body = "test sync" + i;
            message.setTopic("TopicTest");
            message.setTags("sync1");
            message.setBody(body.getBytes());
            SendResult send = producer.send(message);
            System.out.println("send status -- " + send.getSendStatus()
                    + "-MsgId = " + send.getMsgId() + "-queueId = " + send.getMessageQueue().getQueueId());
            System.out.println("send count -- " + i);
        }
        producer.shutdown();
    }

}
