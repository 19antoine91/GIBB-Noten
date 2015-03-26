package model;

/**
 * A Modul object (modul in the sense of schoo subject) contains all information to a single modul. This contains:
 * Grades of exams during semester, grade of final exam, average before final exam and average after final exam.
 * 
 * @author Joshua Villing
 *
 */
public class Modul {

	private String title;
	private double[] grades = new double[5];
	private double finalExamGrade = 0;
	private double average;
	private double averageAfterFinal;
	private double sumOfGrades = 0;
	private double numberOfGrades = 0;

	public Modul(String[] data) {
		this.title = data[0];
		processModulData(data);
		this.average = calcAverage();
		this.averageAfterFinal = calcAverageMP();
	}

	public void processModulData(String[] notenStrings) {
		try {
			for (int i = 1; i < (notenStrings.length - 1); i++) {
				this.grades[(i-1)] = Double.parseDouble(notenStrings[i]);
			}
			this.finalExamGrade = Double.parseDouble(notenStrings[6]);
		} catch (NumberFormatException e) {
			System.out.println("Note konnte nicht gelesen werden");
		}
	}

	public double calcAverage(){
		for (double note : grades){
			if (note != 0){   
				numberOfGrades += 1;
				sumOfGrades += note;
			}
		}
		return (sumOfGrades / numberOfGrades);
	}

	public double calcAverageMP(){
		if (finalExamGrade != 0){
			return (average + finalExamGrade) / 2;
		} else {
			return 0;
		}
	}

	public void addGrade(double grade, int index){
		grades[index] = grade;
	}
	
	public void addFinalExamGrade(double grade){
		this.finalExamGrade = grade;
	}

	public String getTitle(){
		return title;
	}

	public double[] getGrades(){
		return grades;
	}

	public double getFinalExamGrade(){
		return finalExamGrade;
	}
}
