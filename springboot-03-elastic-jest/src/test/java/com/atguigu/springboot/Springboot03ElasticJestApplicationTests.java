package com.atguigu.springboot;

import com.atguigu.springboot.entities.Book;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import io.searchbox.core.search.sort.Sort;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Collection;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot03ElasticJestApplicationTests {

	@Autowired
	private JestClient jestClient;

	@Test
	public void contextLoads() throws IOException {
		Book book = new Book();
		book.setId(1);
		book.setBookName("西游记2");
		book.setAuthor("吴承恩22");

		//给ES中索引（保存）一个文档
		Index index = new Index.Builder(book)
				.index("atguigu") //设置索引
				.type("book1") //设置类型
				//.id(book.getId()) 因为我们已经在book类上标注了id是哪个属性，所以就不需要写上这一句了
				.build();
		//执行
		jestClient.execute(index);
	}

	@Test
	public void test2() throws IOException {

//精确查找  ----   可用
		String query1 = "{\n" +
				"    \"query\" : {\n" +
				"        \"constant_score\" : { \n" +
				"            \"filter\" : {\n" +
				"                \"term\" : { \n" +
				"                    \"residence_address\" : 田林十四寸\n" +
				"                }\n" +
				"            }\n" +
				"        }\n" +
				"    }\n" +
				"}";
		//组合条件


		// ---------- 可用
		String query4 = "{\n" +
				"    \"query\" : {\n" +
				"        \"bool\" : {\n" +
				"            \"must\" : {\n" +
				"                \"match\" : {\n" +
				"                    \"place_id\" : \"31010416011301\"\n" +
				"                }\n" +
				"            }\n" +
				"        }\n" +
				"    }\n" +
				"}\n";

		//组合查询，可用
		String query5 = "{\n" +
				"\t\"query\": {\n" +
				"\t\t\"bool\": {\n" +
				"\t\t\t\"must\": {\n" +
				"\t\t\t\t\"match\": {\n" +
				"\t\t\t\t\t\"place_id\": \"31010416011301\"\n" +
				"\t\t\t\t}\n" +
				"\t\t\t},\n" +
				"\t\t\t\"filter\": {\n" +
				"\t\t\t\t\"range\" : {\n" +
				"                    \"open_timestamp\" : { \"gt\" : \"2019-08-13 12:11:01\" } \n" +
				"                }\n" +
				"\t\t\t}\n" +
				"\t\t}\n" +
				"\t}\n" +
				"}";

		String query6 = "{\n" +
				"\t\"query\": {\n" +
				"\t\t\"bool\": {\n" +
				"\t\t\t\"must\": [{\n" +
				"\t\t\t\t\"match\": {\n" +
				"\t\t\t\t\t\"place_id\": \"31010416011301\"\n" +
				"\t\t\t\t}\n" +
				"\t\t\t},\n" +
				"\t\t\t{\n" +
				"\t\t\t\t\"match\": {\n" +
				"\t\t\t\t\t\"building_no\": \"42\"\n" +
				"\t\t\t\t}\n" +
				"\t\t\t}],\n" +
				"\t\t\t\"filter\": {\n" +
				"\t\t\t\t\"range\": {\n" +
				"\t\t\t\t\t\"open_timestamp\": {\n" +
				"\t\t\t\t\t\t\"gt\": \"2019-08-13 08:11:01\",\n" +
				"\t\t\t\t\t\t\"lt\": \"2019-12-13 08:11:01\"\n" +
				"\t\t\t\t\t}\n" +
				"\t\t\t\t}\n" +
				"\t\t\t}\n" +
				"\t\t}\n" +
				"\t}\n" +
				"}\n";

		String query7 = "{\n" +
				"\t\"from\":0,\"size\":10,\n" +
				"\t\"query\": {\n" +
				"\t\t\"bool\": {\n" +
				"\t\t\t\"must\": [{\n" +
				"\t\t\t\t\"match\": {\n" +
				"\t\t\t\t\t\"place_id\": \"31010416011301\"\n" +
				"\t\t\t\t}\n" +
				"\t\t\t},\n" +
				"\t\t\t{\n" +
				"\t\t\t\t\"match\": {\n" +
				"\t\t\t\t\t\"building_no\": \"42\"\n" +
				"\t\t\t\t}\n" +
				"\t\t\t}],\n" +
				"\t\t\t\"filter\": {\n" +
				"\t\t\t\t\"range\": {\n" +
				"\t\t\t\t\t\"open_timestamp\": {\n" +
				"\t\t\t\t\t\t\"gt\": \"2019-08-13 08:11:01\",\n" +
				"\t\t\t\t\t\t\"lt\": \"2019-12-13 08:11:01\"\n" +
				"\t\t\t\t\t}\n" +
				"\t\t\t\t}\n" +
				"\t\t\t}\n" +
				"\t\t}\n" +
				"\t}\n" +
				"}";

		Search search = new Search.Builder(query7)
				.addIndex("es_dm_house_vacany")
				.addType("_doc")
				.build();
		SearchResult execute = jestClient.execute(search);
		System.out.println(execute);
	}

	@Test
	public void test02() {
//		JSONArray jsonArray = new JSONArray();
//		Map<String,Object> match = new HashMap<>(1);
//		match.put("match",null);


	}

}
