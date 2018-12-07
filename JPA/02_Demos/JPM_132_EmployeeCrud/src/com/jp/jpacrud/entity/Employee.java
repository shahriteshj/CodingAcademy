package com.jp.jpacrud.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * @author Administrator
 *
 */
@Entity // tell JPA that this class object need to be persisted
@Table(name="emp_master") // tell JPA that this class object need to be mapped 
public class Employee {

	@Id //Primary key
	//@GeneratedValue(strategy=GenerationType.TABLE)
	@SequenceGenerator(name="EMP_GEN" ,sequenceName="emp_master_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EMP_GEN")
	private Long employeeId;
	private String name;
	private Double salary;
	
	public Employee(){
		
	}
	
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", salary=" + salary + "]";
	}
	public Employee(Long employeeId, String name, Double salary) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.salary = salary;
	}

	public Employee(String name, Double salary){
	this.name = name;
	this.salary= salary;
	}
}

	//
	

