package com.example.rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class TopicPublisher {

	public static void main(String[] args) throws IOException, TimeoutException {
		// TODO Auto-generated method stub
		ConnectionFactory factory=new ConnectionFactory();
		Connection connection=factory.newConnection();
		Channel channel=connection.createChannel();
		String message = "This is a Mobile Consumer and AC Consumer";
		channel.basicPublish("Topic-Exchange", "tv.mobile.ac", null, message.getBytes());
		channel.close();
		connection.close();
	}

}
