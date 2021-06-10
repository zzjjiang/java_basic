package com.rocketmq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.junit.Test;

/**
 * @author zouzujiang
 */
public class RocketMQCase {
    /**
     * 单向发送
     * 只管发
     */
    @Test
    public void oneWayProducer() throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("4oneway");
        producer.setNamesrvAddr("localhost:9876");
        producer.start();
        for (int i = 0; i < 2; i++) {
            Message message = new Message();
            String body = "test" + i;
            message.setTopic("topicTest1");
            message.setTags("one");
            message.setBody(body.getBytes());
            producer.sendOneway(message);
            System.out.println("send count -- " + i);
        }
        producer.shutdown();
    }

    /**
     * 同步发送消息
     * 同步发送是指消息发送方发出数据后，同步等待，直到收到接收方发回响应之后才发下一个请求。
     */
    @Test
    public void syncProducer() throws Exception {
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

    /**
     * 异步发送消息
     * 消息发送方在发送了一条消息后，不等接收方发回响应，接着进行第二条消息发送。
     * 发送方通过回调接口的方式接收服务器响应，并对响应结果进 行处理
     */
    @Test
    public void asyncProducer() throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("4sync");
        producer.setNamesrvAddr("localhost:9876");
        producer.start();
        for (int i = 0; i < 2; i++) {
            Message message = new Message();
            String body = "test async" + i;
            message.setTopic("topicAsync1");
            message.setTags("async1");
            message.setBody(body.getBytes());
            producer.send(message, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    System.out.println("send status -- " + sendResult.getSendStatus()
                            + "-MsgId = " + sendResult.getMsgId() + "-queueId = " + sendResult.getMessageQueue().getQueueId());
                }

                @Override
                public void onException(Throwable throwable) {
                    System.out.println("send onException -- ");
                }
            });

            System.out.println("send count -- " + i);
        }
        producer.shutdown();
    }
}
