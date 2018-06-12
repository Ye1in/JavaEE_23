package org.bookbook.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Usertable entity. @author MyEclipse Persistence Tools
 */

public class Usertable implements java.io.Serializable {

	// Fields

	private Integer userid;
	private String username;
	private String password;
	private String sex;
	private Integer age;
	private Set orderses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Usertable() {
	}

	/** minimal constructor */
	public Usertable(String username, String password) {
		this.username = username;
		this.password = password;
	}

	/** full constructor */
	public Usertable(String username, String password, String sex, Integer age,
			Set orderses) {
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.age = age;
		this.orderses = orderses;
	}

	// Property accessors

	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Set getOrderses() {
		return this.orderses;
	}

	public void setOrderses(Set orderses) {
		this.orderses = orderses;
	}

}