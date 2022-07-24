package com.techno.batch.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.techno.batch.models.Employee;

public class Helper {
	public static List<Employee> excelEmployeeList() {
		List<Employee> employeeList = new ArrayList<Employee>();
		try {
			File file = new File("src/main/resources/EmpTable.xlsx");
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheetAt(0);
			Iterator<Row> itr = sheet.iterator();
			int rowNumber = 0;
			while (itr.hasNext()) {
				Row row = itr.next();
				// skip header
				if (rowNumber == 0) {
					rowNumber++;
					continue;
				}
				Iterator<Cell> cellIterator = row.cellIterator();
				Employee employee = new Employee();
				int cellIdx = 0;
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					switch (cellIdx) {
					case 0:
						employee.setId((int) cell.getNumericCellValue());
						break;
					case 1:
						employee.setName(cell.getStringCellValue());
						break;
					case 2:
						employee.setPhoneNo((long) cell.getNumericCellValue());
						break;
					case 3:
						employee.setAddress(cell.getStringCellValue());
						break;
					case 4:
						employee.setSalary(cell.getNumericCellValue());
						break;

					default:
						break;
					}
					cellIdx++;
				}
				employeeList.add(employee);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeeList;
	}
}