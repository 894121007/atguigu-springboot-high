package com.atguigu.springboot.entities;


/**
 * @author zhanglong
 * @description: TODO
 * @date 2019/7/24 11:00
 *
 */

//@Document(indexName = "atguigu",type = "company")
public class Company {
	private Integer id;
	private String name;
	private String ceo;

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

	public String getCeo() {
		return ceo;
	}

	public void setCeo(String ceo) {
		this.ceo = ceo;
	}
}
