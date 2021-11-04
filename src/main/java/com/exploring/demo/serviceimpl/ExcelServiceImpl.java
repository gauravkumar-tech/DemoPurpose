package com.exploring.demo.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.exploring.demo.helper.ExcelHelper;
import com.exploring.demo.service.ExcelService;

@Service
public class ExcelServiceImpl implements ExcelService{

	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Map getExcelToMapJson(MultipartFile file) {
		Map map = new HashMap();
		try {
			if(ExcelHelper.excelValidator(file)) {
				List excelToJson = ExcelHelper.getExcelToJson(file.getInputStream());
				map.put("data", excelToJson);
			}else {
				map.put("data", "Please Add A Valid Excel");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

}
