package com.atguigu.springboot.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author zhanglong
 * @description: TODO
 * @date 2019/8/19 16:37
 *
 */
@Document(indexName = "atguigu",type = "book")
public class Book {
	@Id
	private Integer id;
	private String author;
	private String bookName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
}
