package com.atguigu.springboot.reporsitory;

import com.atguigu.springboot.entities.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * @author zhanglong
 * @description: TODO
 * @date 2019/8/19 17:21
 *
 */
public interface BookRepository extends CrudRepository<Book, String> {
//	@Query("{"bool" : {"must" : {"field" : {"name" : "?0"}}}}")
//	Page<Book> findByName(String name, Pageable pageable);
}
