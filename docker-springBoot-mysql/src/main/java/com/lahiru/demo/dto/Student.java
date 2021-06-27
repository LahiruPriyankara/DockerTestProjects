package com.lahiru.demo.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int stuId;
	String stuName;
	int stuAge;
	int stuGrade;
	String stuAddress;

	public Student() {

	}

	public Student(String stuName, int stuAge, int stuGrade, String stuAddress) {
		this.stuName = stuName;
		this.stuAge = stuAge;
		this.stuGrade = stuGrade;
		this.stuAddress = stuAddress;
	}

	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public int getStuAge() {
		return stuAge;
	}

	public void setStuAge(int stuAge) {
		this.stuAge = stuAge;
	}

	public int getStuGrade() {
		return stuGrade;
	}

	public void setStuGrade(int stuGrade) {
		this.stuGrade = stuGrade;
	}

	public String getStuAddress() {
		return stuAddress;
	}

	public void setStuAddress(String stuAddress) {
		this.stuAddress = stuAddress;
	}

	@Override
	public String toString() {
		return "Student [stuId=" + stuId + ", stuName=" + stuName + ", stuAge=" + stuAge + ", stuGrade=" + stuGrade
				+ ", stuAddress=" + stuAddress + "]";
	}

}
