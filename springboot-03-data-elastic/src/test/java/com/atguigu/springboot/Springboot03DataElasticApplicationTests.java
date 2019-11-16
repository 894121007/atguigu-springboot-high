package com.atguigu.springboot;

import com.atguigu.springboot.entities.Book;
import com.atguigu.springboot.entities.Company;
import com.atguigu.springboot.entities.MyBean;
import com.atguigu.springboot.reporsitory.BookRepository;
import com.atguigu.springboot.reporsitory.CompanyReporsitory;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.SimpleQueryStringBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.management.Query;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot03DataElasticApplicationTests {


//	@Autowired
//	CompanyReporsitory companyReporsitory;

//	@Autowired
//	ElasticsearchTemplate elasticsearchTemplate;

//	@Autowired
//	MyBean myBean;

	@Autowired
	private BookRepository bookRepository;

//	@Test
//	public void testSearch2() {
//		Company company = new Company();
//		company.setId(1);
//		company.setName("阿里巴巴");
//		company.setCeo("马云");
//		boolean b = elasticsearchTemplate.putMapping("atguigu", "company", company);
//		System.out.println(b);
////		ElasticsearchTemplate template = myBean.getTemplate();
////		template.putMapping("atguigu", "company", company);
//
//	}

	@Test
	public void testSearch1() {
		Company company = new Company();
		company.setId(1);
		company.setName("阿里巴巴");
		company.setCeo("马云");
//		companyReporsitory.save(company);
//		QueryBuilder query = new SimpleQueryStringBuilder("");
////		QueryBuilder query2 = new TermsQueryBuilder();
//		QueryBuilder query3 = new MultiMatchQueryBuilder("search", new String[]{"a","b"});
////		companyReporsitory.search(query);
//		Pageable pageable = PageRequest.of(1,10);
//		companyReporsitory.search(query,pageable);
	}

	@Test
	public void test03() {
//		Book book = new Book();
//		book.setId(2);
//		book.setAuthor("李白");
//		book.setBookName("飞流直下三千尺");
//		bookRepository.save(book);
		QueryBuilder query = new SimpleQueryStringBuilder("");
//		bookRepository.search(query);
		Iterable<Book> all = bookRepository.findAll();
		System.out.println(all);
	}


}
