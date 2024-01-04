package com.example.rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class Consumer {

	public static void main(String[] args) throws IOException, TimeoutException {
		// TODO Auto-generated method stub
		ConnectionFactory factory=new ConnectionFactory();
		Connection connection=factory.newConnection();
		Channel channel=connection.createChannel();
		DeliverCallback deliverCallback = (consumerTag,delivery)->{
			String message = new String(delivery.getBody());
			System.out.println("Message Recieved-"+ message);
		};
		channel.basicConsume("Queue-1", true, deliverCallback, consumerTag -> {});
		//do not close connection and Channel .becuase publisher can publish the message to consumer at any time
		//acknowledgement is always be truee;
		//we get the message through delivery paraamter in deliverCallback;
	}

}
