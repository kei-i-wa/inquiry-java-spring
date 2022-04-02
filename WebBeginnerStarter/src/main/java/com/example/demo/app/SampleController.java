package com.example.demo.app;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * Add annotations here
 */
@Controller
@RequestMapping("/sample")
public class SampleController {
	
 	private final JdbcTemplate jdbcTemplate;

// 	//Add an annotation here 
 	@Autowired
 	public SampleController(JdbcTemplate jdbcTemplate) {
 		this.jdbcTemplate = jdbcTemplate;
 	}
	
	//Getの場合はこれで良いけどpostだt
	@GetMapping("/test")
	public String test(Model model) {
		model.addAttribute("title","inquiry form");
		String sql = "SELECT id,　name,　email　"
				+ "FROM inquiry WHERE id =　1";
		
		String sql2 = "SELECT id,　name,　email　"
				+ "FROM inquiry WHERE id =　1";
		
		Map<String,Object> map = jdbcTemplate.queryForMap(sql);
		Map<String,Object> map2 = jdbcTemplate.queryForMap(sql2);
		model.addAttribute("name", map.get("name"));
		model.addAttribute("email", map.get("email"));
		model.addAttribute("name2", map.get("name"));
		model.addAttribute("email2", map.get("email"));
		model.addAttribute("title","Inquiry Form");

		return "test";
}

}
