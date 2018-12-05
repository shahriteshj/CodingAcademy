package com.lnt.day18_hibernate.customer.model;
//JPA annotation  javax.persistence.*
import javax.persistence.Column;
import javax.persistence.Entity; // JPA 
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "lnt_customer")
public class Customer {

	@Id//primary key
	//in oracle primary key can be automatically generated by using sequence
	/*@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_GEN")
	@SequenceGenerator(name = "CUST_GEN", sequenceName = "seq_lnt_customer", allocationSize = 1)
	*/
	@GeneratedValue(strategy = GenerationType.AUTO)//database independent
	@Column(name = "cust_Id")
	private Long custId;

	@Column(name = "cust_Name")
	private String custName;

	@Column(name = "email")
	private String email;

	@Column(name = "phone")
	private String phone;

	public Customer() {
		super();
	}

	public Customer(String custName, String email, String phone) {
		super();
		this.custName = custName;
		this.email = email;
		this.phone = phone;
	}

	public Customer(Long custId, String custName, String email, String phone) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.email = email;
		this.phone = phone;
	}

	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", email=" + email + ", phone=" + phone + "]";
	}

}
