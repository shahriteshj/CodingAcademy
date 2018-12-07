/**
 * 
 */
package com.jpm.joins.entities;

import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author brije
 *
 */
@Entity
@Table(name="Emp_Task")
public class Employee {
  @Id
  @GeneratedValue
  private long id;
  private String name;
  
  @ManyToMany(cascade = CascadeType.ALL)
  private List<Task> tasks;
  
    public Employee() {
		// TODO Auto-generated constructor stub
	}
	public Employee(String name, List<Task> tasks) {
		super();
		this.name = name;
		this.tasks = tasks;
	}
	//user defined method
 public static Employee create(String name, Task... task) {
        Employee e = new Employee();
        e.name = name;
        if (task != null) {
            e.tasks = Arrays.asList(task);
        }
        return e;
    }
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Task> getTasks() {
		return tasks;
	}
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", tasks=" + tasks + "]";
	}
}