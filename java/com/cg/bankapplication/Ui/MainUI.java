package com.cg.bankapplication.Ui;

import java.util.Scanner;

import com.cg.bankapplication.beans.CustomerDetails;
import com.cg.bankapplication.beans.TransactionDetails;

import com.cg.bankapplication.service.LoginInterface;
import com.cg.bankapplication.service.LoginService;
import com.cg.bankapplication.service.RegisterInterface;
import com.cg.bankapplication.service.RegisterService;
import com.cg.bankapplication.service.TransactionInterface;
import com.cg.bankapplication.service.TransactionService;

public class MainUI {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		CustomerDetails customerDetails=new CustomerDetails();
		TransactionDetails transactionDetails =new TransactionDetails();
		RegisterInterface  rlt1=new RegisterService();
		LoginInterface rlt2=new LoginService();
		TransactionInterface rlt3=new TransactionService();
		do {
		System.out.println("=======menu for the customers=========");
		System.out.println("1.Registration");
		System.out.println("2.login and transaction");
		
		System.out.println("3.Exit");
		System.out.println("Enter the option");
		int choice=sc.nextInt();
		switch(choice) {
		case 1: 	 System.out.println("enter the first name");
					 String firstName=sc.next();
		customerDetails.setFirstName(firstName);
		System.out.println("enter the last name");
		String lastName=sc.next();
		customerDetails.setLastName(lastName);
		System.out.println("enter the email id");
		String emailId=sc.next();
		customerDetails.setEmailId(emailId);
		System.out.println("enter the password");
		String password=sc.next();
		customerDetails.setPassword(password);
		System.out.println("enter the pancardno name");
		String pancardNo=sc.next();
		customerDetails.setPancardNo(pancardNo);
		System.out.println("enter the aadhar name");
		String aadharNo=sc.next();
		boolean  aadharNo1=rlt1.isAadharValid(aadharNo);
		if(aadharNo1==true) {
		customerDetails.setAadharNo(aadharNo);
		System.out.println("enter the address");
		String address=sc.next();
		customerDetails.setAddress(address);
		System.out.println("enter the mobile number");
		String mobileNo=sc.next();
		boolean mobileNo1=rlt1.isMobileNoValid(mobileNo);
		if(mobileNo1==true) {
			customerDetails.setMobileno(mobileNo);
		}
		 CustomerDetails customerDetails2=rlt1.register(customerDetails);
		if(customerDetails2!=null) {
			System.out.println("successful registration  ");
		}
		}
			break;
		case 2: rlt2.login(customerDetails);
				rlt3.transaction();
		break;
		default:
			System.exit(0);
		
		}
		}while(true);
	}

}
