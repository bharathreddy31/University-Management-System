package Grade;

public class printGrade {
     public static String gradePrint(int marks) {
    	String grade;
    	if(marks>=90 && marks<=100) {
			grade="O";
		}
		else if(marks>=80 && marks<90) {
			grade="A+";
		}
		else if(marks>=70 && marks<80) {
			grade="A";
		}
		else if(marks>=60 && marks<70) {
			grade="B+";
		}
		else if(marks>=50 && marks<60) {
			grade="B";
		}
		else {
			grade="Fail";
		}
    	return grade;
    }
}
