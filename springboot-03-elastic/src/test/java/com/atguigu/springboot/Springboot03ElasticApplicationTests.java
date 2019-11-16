package com.atguigu.springboot;

import com.atguigu.springboot.entities.Book;
import com.atguigu.springboot.entities.Company;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot03ElasticApplicationTests {

	@Autowired
	JestClient jestClient;

//	@Autowired
//	CompanyReporsitory companyReporsitory;

//	@Autowired
//	ElasticsearchTemplate elasticsearchTemplate;

	@Test
	public void testSearch2() {
		Company company = new Company();
		company.setId(1);
		company.setName("阿里巴巴");
		company.setCeo("马云");
//		boolean b = elasticsearchTemplate.putMapping("atguigu", "company", company);
//		System.out.println(b);

	}

	@Test
	public void testSearch1() {
		Company company = new Company();
		company.setId(1);
		company.setName("阿里巴巴");
		company.setCeo("马云");
//		companyReporsitory.index(company);
	}

	@Test
	public void contextLoads() throws IOException {
		Book book = new Book();
		book.setId(1);
		book.setBookName("西游记");
		book.setAuthor("吴承恩");

		//给ES中索引（保存）一个文档
		Index index = new Index.Builder(book)
				.index("atguigu") //设置索引
				.type("book") //设置类型
				//.id(book.getId()) 因为我们已经在book类上标注了id是哪个属性，所以就不需要写上这一句了
				.build();

		//执行
		jestClient.execute(index);
	}

	@Test
	public void testSearch() throws IOException {
		String json = "{\n" +
				"    \"query\" : {\n" +
				"        \"match\" : {\n" +
				"            \"author\" : \"吴\"\n" +
				"        }\n" +
				"    }\n" +
				"}";

		Search build = new Search.Builder(json)
				.addIndex("atguigu")
				.addType("book")
				.build();

		SearchResult execute = jestClient.execute(build);
		System.out.println("---------"+execute.getHits(Book.class));
		System.out.println("----------"+execute.getJsonString());


	}

}
