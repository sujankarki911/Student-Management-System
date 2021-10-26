package com.company.phase5;

import java.util.*;

public class Utility {
	public static List<Student> addStudent(){
		int studentNum = Utility.getInputAsInteger("Enter number of Students: ");
		List<Student> studentList = new ArrayList<>();
		for(int i = 0; i <studentNum; i++){
			String name = Utility.getInputAsString("Enter Students name(" + (i+1) +  "):  ");
			Student student = new Student();
			student.setName(name);
			Map<String,Integer> mapOfSub  = Utility.addSubject();
			student.setGradeBySubject(mapOfSub);
			double average = Utility.calculateAverage(mapOfSub);
			student.setAverageGrade(average);
			studentList.add(student);
		}
		return studentList;
	}

	public static double calculateAverage(Map<String, Integer> subjectList){
		if(subjectList== null || subjectList.size() == 0){
			return 0.0;
		}
		int gradeSum = 0;
		double average = 0.0;
		int n = subjectList.size();

		for(Integer grade : subjectList.values()){
			gradeSum += grade;
			average = gradeSum/n;
		}
		return average;
	}

	public static Map<String, Integer> addSubject(){
		int subjectNum = Utility.getInputAsInteger("Enter number of subjects: ");
		System.out.println(" ");
		int gradeSum = 0;
		Map<String, Integer> gradeBySubject = new HashMap<>();

		for(int j=0; j <subjectNum; j++){
			String subjectName = Utility.getInputAsString("Enter Subjects name(" + (j+1) +  "):  ");
			int subjectGrade = Utility.getInputAsInteger("Enter grade of subjects: (" + subjectName + "):  ");
			gradeSum += subjectGrade;
			gradeBySubject.put(subjectName, subjectGrade);				
		}
		System.out.println();
		return gradeBySubject;
	}

	public static int getStudentIndex(String name, List<Student> studentList){
		if(studentList == null || studentList.size() == 0){
			return -123;
		}
		for(int i = 0; i<studentList.size(); i++){
			if(name.equalsIgnoreCase((studentList.get(i)).getName())){
				return i;
			}
		}
		return -1234;
	}

	public static Student modifyStudent(String name, List<Student> studentList){
		int studentIndex = Utility.getStudentIndex(name, studentList);
		Student toBeModifyStudent = studentList.get(studentIndex);
		toBeModifyStudent.setGradeBySubject(addSubject());
		studentList.set(studentIndex, toBeModifyStudent);
		return toBeModifyStudent;
	}



	public static boolean deleteStudent(String name, List<Student> studentList){
		if(studentList == null || studentList.size() == 0){
			System.out.println("Empty Student List.");
		}
		for(Student student : studentList){
			if(name.equalsIgnoreCase(student.getName())){
				boolean deleted = studentList.remove(student);
			}
			else {
				System.out.println("Student Not Found in the list.");
			}
		}
		return false;
	}

	public static void showStudentList(List<Student> studentList){
		if(studentList == null || studentList.size() == 0){
			System.out.println("Empty Student List.");
		}
		for (Student student : studentList){
			System.out.println(student);
		}
	}



	public static boolean isNumber(String name){
		try {
	        	Integer.parseInt(name); //returns integer
	        	return true; //if integers then true 
	        	
	        } catch(Exception e) {
	        	return false;
	        }
	}

	    public static String getInputAsString(String message){
	    	Scanner scanner = new Scanner(System.in);
	    	System.out.print( message );
	    	String input = scanner.next();
	    	return input;
	    }

	    public static int getInputAsInteger(String message){
	    	Scanner scanner = new Scanner(System.in);
	    	while(true) {
	    		try {
	    			System.out.print( message );
	    			int number = scanner.nextInt();
	    			return number;
	    		} catch(Exception e) {
	    			System.out.print("Invalid number. Plzz Try again...");
	    			scanner.next();
	    		}
	    	}
	    }
	}



	