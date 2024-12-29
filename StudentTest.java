package com.company.phase5;

import java.util.*;
public class StudentTest {
	private static final int EXIT = 0;
	private static final int ADD_STUDENT = 1;
	private static final int SHOW_STUDENT_LIST = 2;
	private static final int SEARCHSTUDENT = 3;
	private static final int EDIT_STUDENT_INFO = 4;
	private static final int DELETE = 5;
	private static final int HELP = 6;

	private static List<Student> studentList = new ArrayList<>();


	public static void help() {
		System.out.println("****Teacher Management System****");
		System.out.println(ADD_STUDENT + " to add a student.");
		System.out.println(SHOW_STUDENT_LIST + " to show student list.");
		System.out.println(SEARCHSTUDENT + " to search the student.");
		System.out.println(EDIT_STUDENT_INFO + " to edit student information.");
		System.out.println(DELETE + "to delete student from the system.");
		System.out.println(HELP + " for help menu.");
		System.out.println(EXIT + " to Exit");
		System.out.println("**** End of Menu ****");
	}


	public static void main(String[] args) {
		help();
		int options;

		Student searchedStudentObject = new Student();

		do {
			options = Utility.getInputAsInteger("Enter options between 0 - 6 & enter 6 for help : ");

			switch (options) {
				case ADD_STUDENT:
				studentList = Utility.addStudent();
				break;

				case SHOW_STUDENT_LIST:
				Utility.showStudentList(studentList);
				break;

				case SEARCHSTUDENT:
				String studentName = Utility.getInputAsString("Enter name of student that you want to SEARCH : ");
				int studentIndex = Utility.getStudentIndex(studentName, studentList);
				if(studentIndex < 0 ){
					System.out.println("not found!!");
				} else {
					Student student = studentList.get(studentIndex);
					System.out.println(student);
				}
				break;

				case EDIT_STUDENT_INFO:
				String sName = Utility.getInputAsString("Enter name of student that you want to EDIT :");
				Student student = Utility.modifyStudent(sName, studentList);

				System.out.println("successfully edited.");
				System.out.println(student);
				break;

				case DELETE:
				String studName = Utility.getInputAsString("Enter name of student that you want to DELETE : ");
				boolean deleted = Utility.deleteStudent(studName, studentList);
				if(deleted){
					System.out.println("Successfully deleted from the system.");
				}
				break;


				case HELP:
				help();
				break;

				case EXIT:
				System.out.println("EXITING!!!");
				break;

				default:
				System.out.println("invalid input");
			}
		}
		while(options != EXIT);

	}
}






