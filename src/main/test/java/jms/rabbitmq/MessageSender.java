package jms.rabbitmq;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import exception.ApplicationServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by longjinwen on 10/10/2017.
 */
public class MessageSender {
    private  Logger log = LoggerFactory.getLogger(MessageSender.class);
    private final  static String QUEUE_NAME  = "hello";
    public boolean sendMessage(String message) throws ApplicationServiceException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = null;
        Channel channel = null;
        try {
            connectionFactory.setHost("127.0.0.1");
            connection = connectionFactory.newConnection();
            channel = connection.createChannel(); //create session
            channel.queueDeclare(QUEUE_NAME,false,false,false,null);
            channel.basicPublish("", QUEUE_NAME,null,message.getBytes());
            log.info("Send '"+message+"'");
            //关闭连接
            channel.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            //throw new ApplicationServiceException("Send Message Error");
            return false;
        }
        return true;
    }
}
