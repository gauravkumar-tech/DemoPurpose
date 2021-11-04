package com.exploring.demo.helper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

public class ExcelHelper {

	public static boolean excelValidator(MultipartFile file) {
		return file.getContentType()
				.equalsIgnoreCase("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List getExcelToJson(InputStream is) {
		List returnList = new ArrayList<Map>();

		try {

			XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
			XSSFSheet sheet = xssfWorkbook.getSheetAt(0);
			int row = 0;

			ArrayList<String> heaingStrings = new ArrayList<String>();

			Iterator<Row> iterator = sheet.iterator();

			while (iterator.hasNext()) {

				if (row == 0) {
					Row TotalRows = iterator.next();
					Iterator<Cell> totalCellsInRow = TotalRows.iterator();

					while (totalCellsInRow.hasNext()) {
						heaingStrings.add(totalCellsInRow.next().toString());
					}
					row++;

				} else {
					Row TotalRows = iterator.next();
					Map map = new HashMap();
					Iterator<Cell> totalCellsInRow = TotalRows.iterator();

					int cell=0;
					while (totalCellsInRow.hasNext()) {
						map.put(heaingStrings.get(cell++), totalCellsInRow.next().toString());
						
					}
					returnList.add(map);
					row++;
				}
			}
			
			xssfWorkbook.close();
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return returnList;

	}

}
