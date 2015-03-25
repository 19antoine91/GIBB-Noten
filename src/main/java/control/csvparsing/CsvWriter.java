package control.csvparsing;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import model.Modul;

/**
 * Class for writing all grades of a semester in a csv-file. Averages are not stored in the file. One line in the csv-file represents one Module.
 * Each line contains room for 5 semester grades. The sixth number of each line represents the finalExamGrade. Grades
 * that haven't been added (or never will be) are filled in with a 0 (ZERO). 
 * 
 * @author Joshua Villing
 *
 */
public class CsvWriter {

	private static final String NEW_LINE_SEPARATOR = "\n";
	private static final String[] fileHeader = {"title", "ersteNote", "zweiteNote", "dritteNote", "vierteNote", "fuenfteNote", "modulPrNote"};

	public static void writeCsvFile(String fileName, List<Modul> module) throws Exception {         
		FileWriter fileWriter = null;
		CSVPrinter csvFilePrinter = null;
		CSVFormat csvFileFormat = CSVFormat.DEFAULT.withRecordSeparator(NEW_LINE_SEPARATOR);
		fileWriter = new FileWriter(fileName);
		csvFilePrinter = new CSVPrinter(fileWriter, csvFileFormat);
		csvFilePrinter.printRecord(fileHeader);
		for (Modul modul : module) {
			List<String> newSemesterRecord = new ArrayList<String>();
			double[] noten = modul.getGrades();
			newSemesterRecord.add(modul.getTitle());
			for (int i = 0; i<noten.length; i++){
				newSemesterRecord.add(Double.toString(noten[i]));
			}
			newSemesterRecord.add(Double.toString(modul.getFinalExamGrade()));
			csvFilePrinter.printRecord(newSemesterRecord);
		}
		csvFilePrinter.close();
	}
}
