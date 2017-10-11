package jms.rabbitmq;

import com.rabbitmq.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by longjinwen on 10/10/2017.
 */
public class MessageConsumer {
    private Logger logger = LoggerFactory.getLogger(MessageConsumer.class);
    public void consume(String queueName){
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = null;
        Channel channel = null;


        //连接到rabbitmq
        factory.setHost("127.0.0.1");
        try {
            connection = factory.newConnection();
            channel = connection.createChannel();
            channel.queueDeclare(queueName,false,false,false,null);
            Consumer consumer = new DefaultConsumer(channel){
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                        throws IOException {
                   String message = new String(body,"UTF-8");
                    logger.info("Received '" + message + "'");
                }
            };
            //上面声明消费者
            channel.basicConsume(queueName,true,consumer);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

    }

}
