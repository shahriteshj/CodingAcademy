/**
 * 
 */
package com.jpm.inheritance.tpc.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Smita
 *
 */
@Entity
@Table(name="EMP_TPC1")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Employee {

	@Id
	@Column(name ="EMP_ID")
	@GeneratedValue(generator="emp_gen", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="emp_gen",sequenceName="emp_seq",allocationSize=1)
	private Long empId;
	
	@Column(name ="EMP_NAME")
	private String empName;
	
	@Column(name ="EMP_SAL")
	private Double empSal;

	public Employee() {
		// TODO Auto-generated constructor stub
	}
	//overloaded constructors
	public Employee( String empName, Double empSal) {
		super();
		this.empName = empName;
		this.empSal = empSal;
	}
	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Double getEmpSal() {
		return empSal;
	}

	public void setEmpSal(Double empSal) {
		this.empSal = empSal;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSal=" + getEmpSal() + "]";
	}
	
}
