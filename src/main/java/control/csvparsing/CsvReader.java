package control.csvparsing;

import java.util.List;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import model.*;

/**
 * Class for reading Information out of a csv file. One csv-file contains all grades of one semester. Averages
 * are calculated after reading, and are not stored in the file. One line in the csv-file represents one Module.
 * Each line contains room for 5 semester grades. The sixt number of each line represents the finalExamGrade. Grades
 * that haven't been added (or never will be) are filled in with a 0 (ZERO). 
 * 
 * @author Joshua Villing
 *
 */
public class CsvReader {

    //Header des CSV file
    private static final String[] fileHeader = {"title", "ersteNote", "zweiteNote", "dritteNote", "vierteNote", "fuenfteNote", "modulPrNote"};

    //Modul Attribute
    private static final String MODUL_title = "title";
    private static final String MODUL_ersteNote = "ersteNote";
    private static final String MODUL_zweiteNote = "zweiteNote";
    private static final String MODUL_dritteNote = "dritteNote";
    private static final String MODUL_vierteNote = "vierteNote";
    private static final String MODUL_fuenfteNote = "fuenfteNote";
    private static final String MODUL_modulPrNote = "modulPrNote";
    
    public static List<Modul> readCsvFile(String fileName) throws Exception {
        FileReader fileReader = null;
        CSVParser csvFileParser = null;
        CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader(fileHeader);
        List<Modul> module = new ArrayList<Modul>();
        fileReader = new FileReader(fileName);
        csvFileParser = new CSVParser(fileReader, csvFileFormat);
        List<CSVRecord> csvRecords = csvFileParser.getRecords(); 
        for (int i = 1; i < csvRecords.size(); i++) {
            CSVRecord record = csvRecords.get(i);
            String[] data = {record.get(MODUL_title), record.get(MODUL_ersteNote), record.get(MODUL_zweiteNote), record.get(MODUL_dritteNote),
                    record.get(MODUL_vierteNote), record.get(MODUL_fuenfteNote), record.get(MODUL_modulPrNote)};
            Modul modul = new Modul(data);
            module.add(modul);
        }
        try {
            fileReader.close();
            csvFileParser.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return module;
    }
}