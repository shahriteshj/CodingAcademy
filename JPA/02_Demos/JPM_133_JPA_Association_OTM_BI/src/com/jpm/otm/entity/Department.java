/**
 * 
 */
package com.jpm.otm.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

/**
 * @author Smita
 *
 */
@Entity
@Table(name="DEPT_OTM")
public class Department {
	
	@Id
	@Column(name ="dept_id")
	private Long deptId;
	
	@Column(name ="dept_name")
	private String deptName;
	
	@OneToMany(mappedBy="department", cascade=CascadeType.ALL)
	private Set<Employee> employees;
	//no_arg constructor
	//getters and setters 
	//toSTring()
	public Department() {
		// TODO Auto-generated constructor stub
	}
	public Long getDeptId() {
		return deptId;
	}
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + "]";
	}
	
}
