package com.example.rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class FanoutConsumer {

	public static void main(String[] args) throws IOException, TimeoutException {
		// TODO Auto-generated method stub
		ConnectionFactory factory=new ConnectionFactory();
		Connection connection=factory.newConnection();
		Channel channel=connection.createChannel();
		String[] queues={"Mobile","AC"};
		DeliverCallback deliverCallback = (consumerTag, delivery) -> {
			String message = new String (delivery.getBody());
			System.out.println("Message received = " + message);
		};
		for(String queue:queues) {
			channel.basicConsume(queue, true, deliverCallback, consumerTag -> {});
		}
	}
}
