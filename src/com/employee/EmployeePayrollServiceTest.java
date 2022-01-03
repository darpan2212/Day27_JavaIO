package com.employee;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import com.employee.EmployeePayrollService.IOStream;

public class EmployeePayrollServiceTest {

	@Test
	public void writeEmpDataToFile() {
		EmployeePayroll[] empsData = {
				new EmployeePayroll(1, "Jeff Bezos", 100000),
				new EmployeePayroll(2, "Mark Zukerberg", 200000),
				new EmployeePayroll(4, "Bill Gates", 400000),
				new EmployeePayroll(3, "Elon Musk", 300000), };

		EmployeePayrollService empService = new EmployeePayrollService(
				empsData);
		empService.writeEmpPayrollData(IOStream.FILE_IO);
		long count = empService.countEntries();
		System.out.println("Number of entries : " + count);
		assertEquals(4, count);
//		empService.readEmpPayrollData(IOStream.FILE_IO);
	}

	@Test
	public void getEmpPayrollDataFromFile() {
		EmployeePayrollFileService fileService = new EmployeePayrollFileService();
		System.out.println(fileService.getEmpPayrollData());
		assertEquals(4, fileService.getEmpPayrollData().size());
	}
	
}