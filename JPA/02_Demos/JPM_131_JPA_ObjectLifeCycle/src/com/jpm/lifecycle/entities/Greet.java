/**
 * 
 */
package com.jpm.lifecycle.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
/**
 * @author Smita
 *
 */
/*CREATE TABLE greet(message_id number(5) PRIMARY KEY,
 message VARCHAR2(25));  
 */
@Entity
public class Greet {
	//CREATE SEQUENCE greet_seq;
	@Id
	@SequenceGenerator(name="greet_gen",sequenceName="greet_seq",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,
	generator="greet_gen")	
	@Column(name="message_id")
	private int messageId;
	
	@Column(name="message")
	private String message;
	//getters and setters 
	public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}	
	//toString method
	@Override
	public String toString() {
		return "Greet [messageId=" + messageId + ", message=" + message + "]";
	}	
}
