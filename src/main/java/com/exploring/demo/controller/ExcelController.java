package com.exploring.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/excel")
@CrossOrigin(origins = "*")
public class ExcelController {

	@Autowired
	private com.exploring.demo.service.ExcelService ExcelService;
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/jsonData")
	public ResponseEntity<?> getExcelToJsonData(@RequestParam("file")MultipartFile file){
		try {
			
			Map excelToMapJson = ExcelService.getExcelToMapJson(file);
			return ResponseEntity.status(HttpStatus.OK).body(excelToMapJson);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
		}
	}
	
	
}
