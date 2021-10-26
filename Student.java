package com.company.phase5;


import java.util.*;

public class Student{
	private String name;
	private double averageGrade;
	private Map<String, Integer> gradeBySubject;

	public Student(){
		gradeBySubject = new HashMap<>();
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public double getAverageGrade(){
		return averageGrade;
	}

	public void setAverageGrade(double averageGrade){
		this.averageGrade = averageGrade;
	}

	public Map<String, Integer> getGradeBySubject(){
		return this.gradeBySubject;
	}

	public void setGradeBySubject(Map<String, Integer> gradeBySubject){
		this.gradeBySubject = gradeBySubject;
	}

    @Override
	public String toString(){
		String subjectInfo = " ";
		for (Map.Entry<String, Integer> entry : getGradeBySubject().entrySet()) {
			subjectInfo = subjectInfo + "\nSubject :" + " " + entry.getKey() + " ---> " + "Marks : " + entry.getValue()
					+ "\n";
		}
		return "Details of Student name : " + this.name + " \n  Average Grade is : " + this.averageGrade + subjectInfo;
	}
}
