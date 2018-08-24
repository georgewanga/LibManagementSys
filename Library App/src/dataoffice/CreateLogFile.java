package dataoffice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class CreateLogFile {
    //creating an object of another class to be used within this class
    public void createLogFile(String logFilePath , Date Date) {
        try {
            // Create new logFile
            File logFile = new File(logFilePath);

            // If logFile doesn't exists, then create it
            if (!logFile.exists()) {
                logFile.createNewFile();

                FileWriter fw = new FileWriter(logFile.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);

                // Write in logFile
                try {
                    bw.write("\tThis log file shows todays events only ");
                    bw.newLine();
                    bw.write("    NOTE: Log files are Generated on a daily basis ");
                    bw.newLine();
                    bw.write("***********  " + Date + "  ***********");
                    bw.newLine();
                    bw.newLine();
                    bw.write("  TIME  \tEVENT");
                    bw.newLine();
                    bw.write("********\t***********");
                    // Close connection
                    bw.flush();
                } catch (IOException ioe) {
                } finally { // always close the logFile
                    if (bw != null) {
                        try {
                            bw.close();
                        } catch (IOException ioe2) {
                            // just ignore it
                        }
                    }
                } // end try/catch/finally
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
} // end class
