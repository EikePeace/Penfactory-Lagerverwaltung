package database.model;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class ImExport
{

    private void clearFile(String PfadZuData) {
        // clears the file to existing PfadZuData
        try {
            FileWriter fw = new FileWriter(PfadZuData);
            fw.write("");
            fw.close();
        } catch (IOException ex) {
            System.out.println("Could not clear file since IOExeption was thrown. Does file exist?\n");
        }
    }
    private String getEntryAsString(DataBase DB, int entryIndex) {
        // return string "anz;bez;gew;kat;pla;pre" with entries from entryIndex
        String anz_str = String.valueOf(DB.anz[entryIndex]);
        String gew_str = String.valueOf(DB.gew[entryIndex]);
        String pla_str = String.valueOf(DB.pla[entryIndex]);
        String pre_str = String.valueOf(DB.pre[entryIndex]);

        return anz_str + ";" + DB.bez[entryIndex] + ";" + gew_str + ";" + DB.kat[entryIndex] + ";" + pla_str + ";" + pre_str;
    }
    private void addLineToDataBase(String entryLine, DataBase DB, int entryIndex) {
        // parses the entryLine string of the form "anz;bez;gew;kat;pla;pre" and adds the values into DataBase at index entryIndex
        Scanner LineScanner = new Scanner(entryLine);
        LineScanner.useDelimiter(";");
        LineScanner.useLocale(Locale.US);
        int anz = LineScanner.nextInt();
        String bez = LineScanner.next();
        double gew = LineScanner.nextDouble();
        String kat = LineScanner.next();
        int pla = LineScanner.nextInt();
        double pre = LineScanner.nextDouble();

        DB.anz[entryIndex] = anz;
        DB.bez[entryIndex] = bez;
        DB.gew[entryIndex] = gew;
        DB.kat[entryIndex] = kat;
        DB.pla[entryIndex] = pla;
        DB.pre[entryIndex] = pre;
    }
    private void makeSureFileExists(File file) {
        // checks if file exist. If it doesn't, it creates all necessary directories and the file itself.
        if (!file.exists()) {// first check if file exists
            file.getParentFile().mkdirs(); //create the parent directories
            try {
                file.createNewFile();      // and also create the file itself in directory
            } catch (IOException ex) {
                System.out.println("IOExeption: Couldn't create file.");
            }
        }
    }

    public void ExportFunktion( int[] array_anz,
                                String[] array_bez,
                                String[] array_kat,
                                double[] array_gew,
                                double[] array_pre,
                                int[] array_pla,
                                String PfadZuData ) {

        // create my database object
        int size = array_anz.length;
        DataBase DB = new DataBase(array_anz, array_bez, array_kat, array_gew, array_pre, array_pla, size);


        // if file does not yet exist, create it. Otherwise clear file content.
        File dataFile = new File(PfadZuData);


        // make sure file exists by creating it and folders, if they don't yet exist.
        makeSureFileExists(dataFile);

        // if file already existed and was not empty, clear previous contents of file.
        clearFile(PfadZuData);


        // write the content of data base to file via FileWriter
        try {
            FileWriter fw = new FileWriter(PfadZuData, true);//Create a filewriter writing to test.txt
            for (int entryIndex = 0; entryIndex < size; entryIndex++) {   // for each data base entry
                String entryString = getEntryAsString(DB,entryIndex);
                fw.write(entryString + "\n");
            }
            fw.close();                            // nothing will be written if file not closed at end.
        } catch (IOException ex) {
            System.out.println("Could not write to file.");
            System.exit(0);
        }
    }


    public void ImportFunktion( int[] array_anz,
                                String[] array_bez,
                                String[] array_kat,
                                double[] array_gew,
                                double[] array_pre,
                                int[] array_pla,
                                String PfadZuData ) {

        // Checks if PfadZuData exists. If not, this function does nothing.
        // Otherwise, it imports the data from PfadZuData into the arrays.



        // check existance of data file. If there is none, return.
        File dataFileObj = new File(PfadZuData);
        if (!dataFileObj.exists()) {
            return;
        }


        // create my database object
        int size = array_anz.length;
        DataBase DB = new DataBase(array_anz, array_bez, array_kat, array_gew, array_pre, array_pla, size);


        try {
            Scanner scanObj = new Scanner(dataFileObj);
            int count = 0;
            while (scanObj.hasNextLine()) {           // loop through line
                String line = scanObj.nextLine();     // get line after line as string from file
                addLineToDataBase(line, DB, count);
                count++;
            }

        }catch (FileNotFoundException ex) {
            System.out.println("Could not scan file.. Maybe it does not exist?");
            System.exit(0);
        }
    }
}



class DataBase
{
    int size;
    public int[] anz = new int[size];
    public int[] pla = new int[size];
    public String[] bez = new String[size];
    public String[] kat = new String[size];
    public double[] gew = new double[size];
    public double[] pre = new double[size];




    public DataBase(
            int[] array_anz,
            String[] array_bez,
            String[] array_kat,
            double[] array_gew,
            double[] array_pre,
            int[] array_pla,
            int size)
    {
        anz = array_anz;
        pre = array_pre;
        pla = array_pla;
        bez = array_bez;
        gew = array_gew;
        kat = array_kat;
    }
}