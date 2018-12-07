package com.jpm.oto.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ADDRESS_OTO_BI1")
public class Address implements Serializable{
	private static final long serialVersionUID = -5151370633278889220L;
/*
	@Id
	@Column(name="emp_id", 	unique=true, nullable=false)
	@GeneratedValue(generator="gen")@GenericGenerator(name="gen", 
	strategy="foreign", parameters=@Parameter(name="property",value="employee"))
	private Long empId;*/
	
	@Id
	@Column(name="ADDRESS_ID")
	private Long addressId;
	
	@Column(name="ADDRESS_STREET")
	private String street;
	
	@Column(name="ADDRESS_CITY")
	private String city;
	
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", street=" + street + ", city=" + city + ", state=" + state
				+ ", zipCode=" + zipCode + "]";
	}
	@Column(name="ADDRESS_STATE")
	private String state;
	
	@Column(name="ADDRESS_ZIPCODE")
	private String zipCode;

	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	//@PrimaryKeyJoinColumn
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
	private Employee employee;
	
	public Long getAddressId() {
		return addressId;
	}
	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	
}
