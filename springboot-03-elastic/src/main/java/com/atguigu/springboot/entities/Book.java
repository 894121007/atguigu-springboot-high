package com.atguigu.springboot.entities;

import io.searchbox.annotations.JestId;

/**
 * @author zhanglong
 * @description: TODO
 * @date 2019/7/23 18:01
 *
 */
public class Book {

	@JestId
	private Integer id;
	private String bookName;
	private String author;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
}
