package com.exploring.demo.serviceimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.exploring.demo.service.DemoService;

@Service
public class DemoServiceImpl implements DemoService {

	
	@Value("${spring.datasource.url}")
	private String url;
	
	@Value("${spring.datasource.username}")
	private String username;
	
	@Value("${spring.datasource.password}")
	private String password;
	
	@Value("${spring.datasource.driver-class-name}")
	private String driverClassName;
	
	
	@Override
	public Map getTableNameAndType() {
		Map returnMap= new HashMap();
		try {
			Class.forName(driverClassName);
			
			Connection connection=DriverManager.getConnection(url, username, password);
			
			Statement statement= connection.createStatement();
			
			String queryString="select * from AssetMaster am left join AssetHead ah on am.assetid=ah.assetid";
			
			
			ResultSet resultSet = statement.executeQuery(queryString);
			
			ResultSetMetaData metaData = resultSet.getMetaData();
			
			int columnCount = metaData.getColumnCount();
		
			
			List listToBeRetureList=new ArrayList();
			
			
			for(int i=1;i<=columnCount;i++) {
				
				Map m= new HashMap();
				m.put("columnname", metaData.getColumnName(i));
				m.put("columntype",metaData.getColumnClassName(i).split("\\.")[2]);
			
				listToBeRetureList.add(m);
			}
			
			returnMap.put("mainList", listToBeRetureList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		
		
		
		
		return returnMap;
	}

}
