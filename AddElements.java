package com.ojas.arraylist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class AddElements {

	static final Logger logger = Logger.getLogger(AddElements.class);
	static Scanner sc = new Scanner(System.in);
	static ArrayList<String> colors = new ArrayList<String>();
	static int loop = 0;

	public static void main(String[] args) {

		BasicConfigurator.configure();

		PropertyConfigurator.configure("log.properties");

		while (loop == 0) {

			logger.info("Select your choice ");
			logger.info("1. add colors into ArrayList");
			logger.info("2.print colors");
			logger.info("3.ext");

			int choice = Integer.valueOf(sc.nextLine());
			
			switch (choice) {
			case 1:
				createArrayList();
				break;
			case 2:
				printColors();
				break;
			case 3:
				logger.info("terminated the operation");
				loop++;
				break;
			default:
				logger.info("enter correct choice");
			}
		}

	}

	public static void createArrayList() {

		logger.info("enter number of colors you want to add : ");
		int count = Integer.valueOf(sc.nextLine());
		for (int i = 1; i <= count; i++) {
			logger.info("Enter color number " + i + " : ");
			colors.add(sc.nextLine());
		}

	}

	public static void printColors() {
		Iterator<String> itr = colors.iterator();
		if (colors.size() != 0) {
			logger.info("The colors in arraylist are : ");

			while (itr.hasNext()) {
				logger.info(itr.next());
			}

		} else {

			logger.info("No colors are there in the ArrayList");
			logger.info("Please add the colors first into arraylist to display");

		}
	}

}
