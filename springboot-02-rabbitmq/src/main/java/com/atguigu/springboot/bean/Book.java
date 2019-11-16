package com.atguigu.springboot.bean;

/**
 * @author zhanglong
 * @description: TODO
 * @date 2019/7/22 16:22
 *
 */
public class Book {
	private String bookName;
	private String author;

	public Book() {
	}

	public Book(String bookName, String author) {
		this.bookName = bookName;
		this.author = author;
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
