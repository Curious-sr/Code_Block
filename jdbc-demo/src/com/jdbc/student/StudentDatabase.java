package com.jdbc.student;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentDatabase {

	private static Scanner scanner = new Scanner(System.in);
	private static Connection connection = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentDatabase sudentobject =new StudentDatabase();
		try {
			//Step-----1========= Load And Register The Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String dbUrl="jdbc:mysql://localhost:3306/student";
			String username="root";
			String password="Sudhansu@123";
			connection = DriverManager.getConnection(dbUrl, username, password);
			
			System.out.println("::::Enter Your Choice::::");
			System.out.println("1.Insert Record");
			System.out.println("2.View Record");
			System.out.println("3.View Record by Id");
			System.out.println("4.Callable Selectall");
			System.out.println("5.Callable SelectById");
			System.out.println("6.Update Record");
			System.out.println("7.Delete Record");
			System.out.println("8.Understanding Transaction");
			System.out.println("9.Perform BatchOperation");
			
			
			
			int choice = Integer.parseInt(scanner.nextLine());
			
			
			switch (choice) {
			case 1:
				sudentobject.insertRecord();
				break;
			case 2:
				sudentobject.viewRecord();
				break;
			case 3:
				sudentobject.viewRecordById();
				break;
			case 4:
				sudentobject.callableSelectall();
				break;
			case 5:
				sudentobject.callableSelectById();
				break;
			case 6:
				sudentobject.updateRecord();
				break;
			case 7:
				sudentobject.deleteRecord();
				break;
			case 8:
				sudentobject.knowTransaction();
				break;
			case 9:
				sudentobject.performBatch();
				break;
			default:
				break;
			}
			
		}
		catch(Exception e){
			throw new RuntimeException("Something Went Wrong...");
		}

	}
	
	
	private void performBatch() throws SQLException {
		connection.setAutoCommit(false);
		
		String sql1="insert into customers(name,email,address) values('sima0','sima0@smail.com','npt')";
		String sql2="insert into customers(name,email,address) values('sima1','sima1@smail.com','npt')";
		String sql3="insert into customers(name,email,address) values('sima2','sima2@smail.com','npt')";
		
		Statement statement= connection.createStatement();
		statement.addBatch(sql1);
		statement.addBatch(sql2);
		statement.addBatch(sql3);
		
		int[] row =statement.executeBatch();
		for(int i : row) {
			if(i>0) {
				continue;
			}
			else {
				connection.rollback();
			}
		}
		connection.commit();
	}


	private void knowTransaction() throws SQLException {
		connection.setAutoCommit(false);
		
		String sql1="insert into customers(name,email,address) values('sima','sima@smail.com','npt')";
		String sql2="inser into customers(name,email,address) values('rajesh','rajesh@smail.com','ctd')"; // incorrect sql statement
		
		PreparedStatement prepareStatement = connection.prepareStatement(sql1);
		int row1 =prepareStatement.executeUpdate();
		
		prepareStatement = connection.prepareStatement(sql2);
		int row2 = prepareStatement.executeUpdate();
		
		if(row1 > 0 && row2 > 0) {
			connection.commit();
		}
		else {
			connection.rollback();
		}
		
	}


	private void deleteRecord() throws SQLException {
		System.out.println("Enter Id to delete ");
		int id=Integer.parseInt(scanner.nextLine());
		String sql="delete from customers where customer_id = "+id;
		Statement statement = connection.createStatement();
		int rec =statement.executeUpdate(sql);
		if(rec > 0) {
			System.out.println("record deleted successfully ");
		}

	}


	private void updateRecord() throws SQLException {
		System.out.println("Enter Id..");
		int id=Integer.parseInt(scanner.nextLine());
		String sql="select * from customers where customer_id = "+id;
		Statement statement=connection.createStatement();
		ResultSet result =	statement.executeQuery(sql);
		if(result.next()) {
			String name=result.getString("name");
			String email=result.getString("email");
			String address=result.getString("address");
			System.out.println("=================================");
			System.out.println("Name is "+name);
			System.out.println("Email is "+email);
			System.out.println("Address is "+address);
			System.out.println("=================================");
			System.out.println("What do you want to update ? ");
			System.out.println("1.Name");
			System.out.println("2.Email");
			System.out.println("3.Address");
			
			int choice = Integer.parseInt(scanner.nextLine());
			String sqlQuery ="update customers set ";
			switch (choice) {
			case 1:
//				System.out.println("Name to be updated");
				sqlQuery = sqlQuery + "name = ? where customer_id = "+id;
				PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
				System.out.println("Enter the name");
				preparedStatement.setString(1,scanner.nextLine());
				
				int rows = preparedStatement.executeUpdate();
				if(rows>0) {
					System.out.println("Name Updated Successfully");
				}
				break;
			case 2:
//				System.out.println("Email to be updated");
				sqlQuery = sqlQuery + "email = ? where customer_id = "+id;
				PreparedStatement preparedStatement1 = connection.prepareStatement(sqlQuery);
				System.out.println("Enter the Email");
				preparedStatement1.setString(1,scanner.nextLine());
				
				int rows1 = preparedStatement1.executeUpdate();
				if(rows1>0) {
					System.out.println("Email Updated Successfully");
				}
				
				break;
			case 3:
				System.out.println("Address to be updated");
				sqlQuery = sqlQuery + "address = ? where customer_id = "+id;
				PreparedStatement preparedStatement2 = connection.prepareStatement(sqlQuery);
				System.out.println("Enter the Address");
				preparedStatement2.setString(1,scanner.nextLine());
				
				int rows2 = preparedStatement2.executeUpdate();
				if(rows2>0) {
					System.out.println("Address Updated Successfully");
				}
				break;
			default:
				break;
			}
			
			
			
		}
		else {
			System.out.println("No record With id "+id);
		}
		
		
	}


	private void callableSelectById() throws SQLException {
		System.out.println("Inside callable selectById Method.....");
		System.out.println("Enter Id..");
		int id=scanner.nextInt();
		CallableStatement callableStatement = connection.prepareCall("{call usp_SelectById(?)}");
		callableStatement.setInt(1,id);
		ResultSet result =	callableStatement.executeQuery();
		
		if(result.next()) {
			String name=result.getString("name");
			String email=result.getString("email");
			String address=result.getString("address");
			
			System.out.println("Name is "+name);
			System.out.println("Email is "+email);
			System.out.println("Address is "+address);
			
		}
		else {
			System.out.println("No record found with id "+id);
		}
	}


	private void callableSelectall() throws SQLException {
		System.out.println("Inside callable select Method.....");
		CallableStatement callableStatement = connection.prepareCall("{call usp_SelectAll()}");
		ResultSet result =	callableStatement.executeQuery();
		
		while(result.next()) {
			String name=result.getString("name");
			String email=result.getString("email");
			String address=result.getString("address");
			
			System.out.println("Name is "+name);
			System.out.println("Email is "+email);
			System.out.println("Address is "+address);
			System.out.println("+++++++++++++++++++++++++++++++++++++++");
		}
		
		
		
	}


	private void viewRecordById()throws SQLException {
		
System.out.println("Inside viewRecordById Method.....");
		
		System.out.println("Enter Student Id..");
		int id	= Integer.parseInt(scanner.nextLine());
		String sql="select * from customers where customer_id = "+id;
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(sql);
		if(result.next()) {
			String name= result.getString("name");
			String email= result.getString("email");
			String address= result.getString("address");
			
			System.out.println("Name is "+name);
			System.out.println("Email is "+email);
			System.out.println("Address is "+address);
		}
		else {
			System.out.println("No record Found with id "+id);
		}
		
	}


	private void viewRecord()throws SQLException {
		
		System.out.println("Inside view Method.....");
		
		String sql="select * from customers";
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(sql);
		
		while(result.next()) {
			Integer Id= result.getInt("customer_id");
			String name= result.getString("name");
			String email= result.getString("email");
			String address= result.getString("address");
			
			System.out.println("Id is "+Id);
			System.out.println("Name is "+name);
			System.out.println("Email is "+email);
			System.out.println("Address is "+address);
			
			System.out.println("+++++++++++++++++++++++++++++++++++++++");
		}
		
		
	}


	private void insertRecord()throws SQLException {
//		System.out.println("Inside Insert Method.....");
		String sql="insert into customers(name,email,address) values(?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		System.out.println("Enter Student Name..");
		preparedStatement.setString(1,scanner.nextLine());
		
		System.out.println("Enter Student Email..");
		preparedStatement.setString(2,scanner.nextLine());
		
		System.out.println("Enter Student Address..");
		preparedStatement.setString(3,scanner.nextLine());
		
		int rows = preparedStatement.executeUpdate();
		if(rows > 0) {
			System.out.println("Record Inserted Successfully......");
		}

	}

}
