package com.atguigu.springboot.zhsq;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhanglong
 * @description: TODO
 * @date 2019/8/19 15:29
 *
 */
@RestController
@RequestMapping("/modelAnalysis")
public class ModelAnalysisController {

//	@Autowired
//	private VacanyHouseReporsitory vacanyHouseReporsitory;

//	@GetMapping("/vacanyHouse")
//	public Page<VacanyHouse> vacanyHouse(@RequestParam(required = false) Integer pageNumber,
//										 @RequestParam(required = false) Integer pageSize) {

//		QueryBuilder query = new MultiMatchQueryBuilder("search",new String[]{"residenceAddress"});
//		Pageable pageable = PageRequest.of(pageNumber,pageSize);
//		Page<VacanyHouse> search = vacanyHouseReporsitory.search(query, pageable);
//		return search;
//	}

}
