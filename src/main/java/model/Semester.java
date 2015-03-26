package model;

import java.util.List;

import control.csvparsing.CsvWriter;

/**
 * Class to storage all information of a semester. This contains a list of the modules, that belong in the semester
 * and the semester average.
 * 
 * @author Joshua Villing
 *
 */
public class Semester {
	
	private String title;
	private String sourceFile;
	private List<Modul> modules;
	private double semesterAverage;
	
	public Semester(String title, String sourceFile, List<Modul> modules){
		this.title = title;
		this.sourceFile = sourceFile;
		this.modules = modules;
		this.semesterAverage = calcSemesterAverage();
	}
	
	// put in controller ??
	public double calcSemesterAverage(){
		double notenSumme = 0;
		for (Modul modul : modules){
			notenSumme += modul.calcAverage();
		}
		return (notenSumme / modules.size());
	}
	
	public String getTitle(){
		return title;
	}
	
	public List<Modul> getModules() {
		return modules;
	}
	
	public void save() throws Exception {
		CsvWriter.writeCsvFile(sourceFile, this.modules);
	}
}
