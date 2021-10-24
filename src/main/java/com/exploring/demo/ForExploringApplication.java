package com.exploring.demo;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.hibernate.mapping.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.exploring.demo.model.AssetMaster;
import com.exploring.demo.repo.AssetMasterRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.javafx.collections.MappingChange.Map;

@SpringBootApplication
public class ForExploringApplication implements CommandLineRunner{

	@Autowired
	EntityManagerFactory entitymanagerfactory;
	@Autowired
	AssetMasterRepo assetmasterrepo;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(ForExploringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		
		
		
	}

}
