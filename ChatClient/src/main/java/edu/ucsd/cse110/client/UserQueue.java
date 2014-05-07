package edu.ucsd.cse110.server.db;

import java.io.Serializable;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.Session;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.context.annotation.Bean;

@Entity
public class UserQueue implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue
	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	private Integer id;
	
	@Column(name="dataName")
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	private String name;
	
	
	public Queue getQueue() {return queue;}
	public void setQueue(Queue queue) {this.queue=queue;}
	private Queue queue;
	
	 @Bean
	 Queue clientQueue(ConnectionFactory factory) throws JMSException {
	 return queue = factory.createConnection().createSession(false, Session.AUTO_ACKNOWLEDGE).createTemporaryQueue();
	 }
	
	
	public UserQueue() {	}
	
	public UserQueue(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "DataElement [id=" + id + ", name=" + name + "]";
	}	
}
