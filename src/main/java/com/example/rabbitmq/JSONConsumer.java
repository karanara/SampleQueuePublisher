package com.example.rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class JSONConsumer {

	public static void main(String[] args) throws IOException, TimeoutException {
		// TODO Auto-generated method stub
		ConnectionFactory factory=new ConnectionFactory();
		Connection connection=factory.newConnection();
		Channel channel=connection.createChannel();
		DeliverCallback deliverCallback = (consumerTag,delivery)->{
			String message = new String(delivery.getBody());
			 try {
                 ObjectMapper objectMapper = new ObjectMapper();
                 JSONObject jsonData = objectMapper.readValue(message, JSONObject.class);
                 System.out.println("Message Received - " + jsonData);
             } catch (IOException e) {
                 e.printStackTrace();
             }
		};
		channel.basicConsume("Queue-1", true, deliverCallback, consumerTag -> {});
	}

}
