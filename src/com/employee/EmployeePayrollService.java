package com.employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {

	enum IOStream {
		CONSOLE_IO, FILE_IO,
	}

	List<EmployeePayroll> employeePayrollList;

	public EmployeePayrollService() {
		employeePayrollList = new ArrayList<>();
	}

	public EmployeePayrollService(EmployeePayroll[] empsData) {
		employeePayrollList = Arrays.asList(empsData);
	}

	public static void main(String[] args) {
		EmployeePayrollService service = new EmployeePayrollService();

		service.readEmpPayrollData(IOStream.CONSOLE_IO);
		service.writeEmpPayrollData(IOStream.CONSOLE_IO);
	}

	public void readEmpPayrollData(IOStream iOStream) {
		if (iOStream.equals(IOStream.CONSOLE_IO)) {
			Scanner consoleScn = new Scanner(System.in);
			System.out.println("Enter the Employee Id : ");
			int id = consoleScn.nextInt();

			System.out.println("Enter the Employee Name : ");
			String name = consoleScn.next();

			System.out.println("Enter the Employee Salary : ");
			double salary = consoleScn.nextDouble();
			consoleScn.close();
			employeePayrollList
					.add(new EmployeePayroll(id, name, salary));
		} else if(iOStream.equals(IOStream.FILE_IO)) {
			EmployeePayrollFileService fileService = new EmployeePayrollFileService();
			fileService.readEmpPayrollData();
		}
	}

	public void writeEmpPayrollData(IOStream iOStream) {
		if (iOStream.equals(IOStream.CONSOLE_IO)) {
			System.out.println("All Employee Payroll details : "
					+ employeePayrollList);
		} else if (iOStream.equals(IOStream.FILE_IO)) {
			EmployeePayrollFileService fileService = new EmployeePayrollFileService();
			fileService.writeEmpPayrollData(employeePayrollList);
		}

	}

	public long countEntries() {
		long count = 0;
		EmployeePayrollFileService fileService = new EmployeePayrollFileService();
		count = fileService.countLines();
		return count;
	}
}