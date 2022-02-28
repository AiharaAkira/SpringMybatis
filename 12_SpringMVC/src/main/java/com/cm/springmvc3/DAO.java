package com.cm.springmvc3;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

@Service
public class DAO {


	public static void cal(StudentDTO sDTO, HttpServletRequest request) {
		
		String name = sDTO.getN();
		double middle = sDTO.getM();
		double finalP = sDTO.getF();
		
		double avg = (middle+finalP)/2;
		
		String grade = "F";
		
		if(avg>=90) {
			grade = "A";
		}else if(avg>=80) {
			grade = "B";
		}else if(avg>=70) {
			grade = "C";
		}else if(avg>=60) {
			grade = "D";
		}
		
		sDTO.setAvg(avg);
		sDTO.setGrade(grade);
		
		request.setAttribute("student", sDTO);
		
		
		
		
	}

}
