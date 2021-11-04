package com.exploring.demo.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface ExcelService {

	public Map getExcelToMapJson(MultipartFile file);
	
}
