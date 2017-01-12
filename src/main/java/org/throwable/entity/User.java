package org.throwable.entity;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

import java.util.Date;

/**
 * @author zjc
 * @version 2017/1/4 1:20
 * @description
 */
@Table("TB_AT_USER")
public class User {

	@Id
	@Column("ID")
	private Integer id;
	@Column("NAME")
	private String name;
	@Column("BIRTH")
	private Date birth;
	@Column("AGE")
	private Integer age;
	@Column("EMAIL")
	private String email;

	public User() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", birth=" + birth +
				", age=" + age +
				", email='" + email + '\'' +
				'}';
	}
}
