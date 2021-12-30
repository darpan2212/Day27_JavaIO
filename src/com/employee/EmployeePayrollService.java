package com.employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {

	List<EmployeePayroll> employeePayrollList;
	
	public EmployeePayrollService() {
		employeePayrollList = new ArrayList<>();
	}
	
	public static void main(String[] args) {
		EmployeePayrollService service = new EmployeePayrollService();
		
		service.readInputFromConsole();
		service.writeOpToConsole();
	}
	
	public void readInputFromConsole() {
		Scanner consoleScn = new Scanner(System.in);
		System.out.println("Enter the Employee Id : ");
		int id = consoleScn.nextInt();
		
		System.out.println("Enter the Employee Name : ");
		String name = consoleScn.next();
		
		System.out.println("Enter the Employee Salary : ");
		double salary = consoleScn.nextDouble();
		consoleScn.close();
		employeePayrollList.add(new EmployeePayroll(id, name, salary));
	}
	
	public void writeOpToConsole() {
		System.out.println("All Employee Payroll details : "+employeePayrollList);
	}
}