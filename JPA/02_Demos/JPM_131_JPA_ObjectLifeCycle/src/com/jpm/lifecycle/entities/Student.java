package com.jpm.lifecycle.entities;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
/*
 * CREATE TABLE student_master
(student_id NUMBER(6) PRIMARY KEY,
student_name VARCHAR2(25));
CREATE SEQUENCE student_seq;
 */
@Entity
@Table(name="student_master")
public class Student implements Serializable {	
	private static final long serialVersionUID = 1L;
	//CREATE SEQUENCE student_seq;
	@Id
	@SequenceGenerator(name="student_gen"
		,sequenceName="student_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,
	generator="student_gen")	
	@Column(name="student_id")
	private int studentId;
	
	@Column(name="student_name")
	private String name;
//getters and setters and toString() method	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
