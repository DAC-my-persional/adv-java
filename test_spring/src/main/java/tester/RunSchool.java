package tester;

import dependency.MathsTeacher;
import dependency.ScienceTeacher;
import dependent.PublicSchool;
import dependent.School;

public class RunSchool {

	public static void main(String[] args) {
		
		School mySchool=new PublicSchool(new ScienceTeacher());
		mySchool.manageAcademics();

	}

}
