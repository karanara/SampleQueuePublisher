package com.example.rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.json.JSONObject;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class JSONPublisher {

	public static void main(String[] args) throws IOException, TimeoutException {
		// TODO Auto-generated method stub
		ConnectionFactory factory= new ConnectionFactory();
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		JSONObject json=new JSONObject();
		json.put("from_date", "04-Jan-2024");
		json.put("to_date", "31-Dec-2024");
		json.put("email", "ramya@gmail.com");
		json.put("query", "select * from data");
		channel.basicPublish("", "Queue-1", null, json.toString().getBytes());
		channel.close();
		connection.close();
	}

}
