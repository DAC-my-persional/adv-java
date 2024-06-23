package dependent;

import dependency.Teacher;

public class PublicSchool implements School {	
	private Teacher subjectTeacher;//=new MathsTeacher();
	
	//constructor based D.I
	public PublicSchool(Teacher myTeacher) {
		this.subjectTeacher=myTeacher;
		System.out.println("In constructor - " + getClass());
	}

	@Override
	public void manageAcademics() {
		System.out.println("Managing academics here -");
		subjectTeacher.teach();//depnt obj is using depcy !
	}

	

}
