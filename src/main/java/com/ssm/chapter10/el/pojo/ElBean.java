package com.ssm.chapter10.el.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("elBean")
public class ElBean {
	
    //通过beanName获取bean，然后注入
	@Value("#{role}")
	private Role role;
	
    //获取bean的属性id
	@Value("#{role.id}")
	private Long id;
	
    //调用bean的getNote方法，获取角色名称
	@Value("#{role.getNote().toString()}")
	private String note;

	@Value("#{role.getNote()?.toString()}")
	private String note1;


	@Value("#{T(java.lang.Math).PI}")
	private double pi;

	@Value("#{T(java.lang.Math).random()}")
	private double random;

	/**
	 * + 可以运算 和 字符串拼接
	 * eq == > <
	 * 还有三目运算符号
	 */
	@Value("#{role.id+1}")
	private int num;

	@Value("#{role.id > 2 ? 5 : 1}")
	private int aBoolean;



	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	} 
	
	
}
