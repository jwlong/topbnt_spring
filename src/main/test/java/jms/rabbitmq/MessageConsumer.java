package jms.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by longjinwen on 10/10/2017.
 */
public class MessageConsumer {
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
            Consumer consumer = new DefaultConsumer(channel);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

    }

}
