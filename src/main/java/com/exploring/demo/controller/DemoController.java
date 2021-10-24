package com.exploring.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exploring.demo.service.DemoService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/democontroller")
public class DemoController {
	
	@Autowired
	DemoService demoservice;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping("/gettablename")
	public ResponseEntity<Map> getTableNameAndType(){
		System.out.println("Gaurav working");
		try {
			Map tableNameAndType = demoservice.getTableNameAndType();
			return ResponseEntity.status(HttpStatus.OK).body(tableNameAndType);
		} catch (Exception e) {
			Map map= new HashMap();
			map.put("error", e.getLocalizedMessage());
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(map);
		}
		
		
		
		
	}
	

}
