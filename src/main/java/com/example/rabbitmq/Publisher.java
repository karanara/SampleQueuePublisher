package com.example.rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Publisher {

	public static void main(String[] args) throws IOException, TimeoutException {
		// TODO Auto-generated method stub
		ConnectionFactory factory=new ConnectionFactory();
		Connection connection=factory.newConnection();
		Channel channel=connection.createChannel();
		String[] messages= {"First","Second","Third","Fourth"};
		String message="first message from Queue1";
		for(String message1:messages) {
			channel.basicPublish("", "Queue-1", null, message1.getBytes());
		}
		//using round robin when there are more than one consumer.
		channel.close();
		connection.close();
	}

}
