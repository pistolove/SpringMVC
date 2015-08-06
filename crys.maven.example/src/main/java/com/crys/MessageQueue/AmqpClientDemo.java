package com.crys.MessageQueue;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

/**
 * AMQP模板类，适用于RabbitMQ
 */
public class AmqpClientDemo {

	public static void main(String[] args) {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		String QUEUE_NAME = "hello" + System.currentTimeMillis();

		Connection connection = null;
		Channel channel = null;
		try {
			connection = factory.newConnection();
			/*
			 * Channel instances are safe for use by multiple threads. Requests
			 * into a Channel are serialized, with only one thread being able to
			 * run a command on the Channel at a time. Even so, applications
			 * should prefer using a Channel per thread instead of sharing the
			 * same Channel across multiple threads.
			 */
			channel = connection.createChannel();
			channel.queueDeclare(QUEUE_NAME, false, false, false, null);

			/*
			 * To send, we must declare a queue for us to send to; then we can
			 * publish a message to the queue: Declaring a queue is idempotent -
			 * it will only be created if it doesn't exist already. The message
			 * content is a byte array, so you can encode whatever you like
			 * there.
			 */
			for (int i = 0; i < 1000; i++) {
				String message = "Hello World!" + i;
				channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
				System.out.println(" [x] Sent '" + message + "'");
			}

			/*
			 * In order to make sure a message is never lost, RabbitMQ supports
			 * message acknowledgments. An ack(nowledgement) is sent back from
			 * the consumer to tell RabbitMQ that a particular message has been
			 * received, processed and that RabbitMQ is free to delete it.
			 */
			QueueingConsumer consumer = new QueueingConsumer(channel);
			boolean autoAck = false;
			channel.basicConsume(QUEUE_NAME, autoAck, consumer);
			while (true) {
				/*
				 * unlike the sender which publishes a single message, we'll
				 * keep it running to listen for messages and print them out.
				 * QueueingConsumer.nextDelivery() blocks until another message
				 * has been delivered from the server.
				 */
				QueueingConsumer.Delivery delivery = consumer.nextDelivery();
				String messageR = new String(delivery.getBody());
				System.out.println(" [x] Received '" + messageR + "'");

				channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				channel.close();
			} catch (Exception ee) {
			}
			try {
				connection.close();
			} catch (Exception ee) {
			}
		}
	}
}
