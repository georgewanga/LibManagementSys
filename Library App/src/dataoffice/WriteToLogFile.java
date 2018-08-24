package dataoffice;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WriteToLogFile {

    private final CommonVarriables CommonVarriables = new CommonVarriables();
    //declaration of instance varriables
    BufferedWriter bw = null;

    public void writeIntoLog(String AddToLog) {
        try {
            // APPEND MODE SET HERE
            bw = new BufferedWriter(new FileWriter(CommonVarriables.logFilePath, true));
            bw.newLine();
            bw.write(CommonVarriables.CURRENT_TIME + "   " + AddToLog);
            bw.flush();
        } catch (IOException ex) {
            Logger.getLogger(WriteToLogFile.class.getName()).log(Level.SEVERE, null, ex);
        } finally { // always close the logFile
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException ex) {
                    Logger.getLogger(WriteToLogFile.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }
}
