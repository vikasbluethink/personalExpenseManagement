package com.expensemanagement;

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.expensemanagement.*;

public class PEMService {

	Scanner in = new Scanner(System.in);

	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction transaction = session.beginTransaction();

	public void showMenu() {
		while (true) {
			this.printMenu();
			System.out.print("Enter your choice:");
			int choice = in.nextInt();
			switch (choice) {
			case 1:
				this.addCategory();
				this.pressanykeytocontinue();
				break;
			case 2:
				this.categoryList();
				this.pressanykeytocontinue();
				break;
			case 3:
				this.expenseEntry();

				this.pressanykeytocontinue();
				break;
			case 4:
				this.expenseList();
				this.pressanykeytocontinue();
				break;

			case 0:
				// TODO
				System.out.println("Bye..");
				System.exit(0);
				break;

			}

		}
	}

	private void categoryList() {
		// TODO Auto-generated method stub
		System.out.println("Category list:\n");
		System.out.println("1.Default Category\n");
	}

	private void expenseEntry() {
		System.out.println("Enter Details For Expense Entry...");
		this.categoryList();

		System.out.print("Please select a category:");
		int selectedCategory = in.nextInt();

		System.out.println(selectedCategory);

		System.out.print("Enter Amount:");
		float amt = in.nextFloat();

		in.nextLine();
		System.out.print("Enter Remark:");
		String rmk = in.nextLine();

		Date date = new Date();

		Expense ex = new Expense();
		ex.setAmount(amt);
		ex.setDate(date);
		ex.setRemark(rmk);

		session.save(ex);
		transaction.commit();
		System.out.println("Expense saved successfully.");

	}

	private void expenseList() {
		// TODO Auto-generated method stub
		System.out.println("Expense List...");

	}

	private void printMenu() {
		System.out.println("-----Personal Expense Management-----");
		System.out.println("1. Adding Category");
		System.out.println("2. Category List");
		System.out.println("3. Expense Entry");
		System.out.println("4. Expense List");
		System.out.println("0. Exit");
		System.out.println("--------------------------------------");

	}

	private void pressanykeytocontinue() {
		try {
			System.out.println("Press Any Key To Continue...");
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void addCategory() {
		in.nextLine(); // new line char is read here.
		System.out.println("Adding Category...");
		System.out.println("Sorry! currently this feature is not available.");
//		String catName = in.nextLine();
		Category cat = new Category();
		cat.setCat_name("Default Category");
		session.save(cat);
//		transaction.commit();
//		List<Category> catList = new ArrayList();
//		catList.add(catName);
//		cat.setCat_name(catName);
		System.out.println("Default Category Added Successfully.");
	}

}
