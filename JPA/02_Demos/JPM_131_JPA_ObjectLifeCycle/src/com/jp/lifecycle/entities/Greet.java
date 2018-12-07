package com.jp.lifecycle.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/*Create Table
 * 
 */
@Entity
public class Greet {
	//Create Sequence greet_seq;
	@Id
	@SequenceGenerator(name="greet_gen",sequenceName="greet_seq",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,
	generator="greet_gen")
	@Column(name="message_id")
	private int messageId;
	
	@Column(name="message")
	private String messsage;
	//getters and setters

	@Override
	public String toString() {
		return "Greet [messageId=" + messageId + ", messsage=" + messsage + "]";
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public String getMesssage() {
		return messsage;
	}

	public void setMesssage(String messsage) {
		this.messsage = messsage;
	}
	
	
	

}
