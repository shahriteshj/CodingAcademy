/**
 * 
 */
package com.lnt.day15_io_file_iostream01;
import java.io.Serializable;
import java.util.Date;/** * @author SMita * */
public class Employee implements Serializable {
	private int empId;
	private String firstName;
	private String lastName;
	private String phoneNo;
	private String email;
	private Date doj;//date of joining
	//step 4 : private static variables
	private static int numId;//automatic id generation
	//step 5 : static initializer block
	static {
		System.out.println("****Static Initializer Block**** executed only once and before constuctor");
		//automatic id generation
		numId=10000+(int) (Math.random()*122.123);//explicitly type cast long to int
	}
	//step 6: initializer block
	{
		System.out.println("****Initializer Block****executed for every object and before constuctor");
		empId=numId;//assigned the auto-generated numId to custId
	}
	public Employee() {
		System.out.println("****no_arg Employee constuctor ****executed for every object created using default constructor ");
	}
	public Employee(String firstName, String lastName, String phoneNo, String email, Date doj) {
		System.out.println("****Overloaded Employee constuctor ****executed for every object created using Overloaded constructor ");

		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNo = phoneNo;
		this.email = email;
		this.doj = doj;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNo="
				+ phoneNo + ", email=" + email + ", doj=" + doj + "]";
	}//generate getters and setters
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}

}
