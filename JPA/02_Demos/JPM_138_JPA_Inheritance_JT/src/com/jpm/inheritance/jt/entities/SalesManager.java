/**
 * 
 */
package com.jpm.inheritance.jt.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Smita
 *
 */
@Entity
@Table(name="SMGR_JT")
public class SalesManager extends Manager {	
	@Column(name="comm")
	private double comm;
	//no-arg constructor, Overloaded constructor
	//toString() method, setters and setters
	public SalesManager() {
		// TODO Auto-generated constructor stub
	}	
	public SalesManager(String empName, Double empSal, Double bonus, double comm) {
		super(empName, empSal, bonus);
		this.comm = comm;
	}
	@Override
	public Double getEmpSal() {
		// TODO Auto-generated method stub
		return super.getEmpSal()+comm;
	}
	@Override
	public String toString() {
		return "SalesManager [comm=" + comm + ", toString()=" + super.toString() + "]";
	}
	public double getComm() {
		return comm;
	}
	public void setComm(double comm) {
		this.comm = comm;
	}
}
