package dataoffice;

import com.healthmarketscience.jackcess.Database.FileFormat;
import com.healthmarketscience.jackcess.DatabaseBuilder;
import java.io.File;
import java.io.IOException;

public class CreateDatabase {
    //Creating objects of another class
    private final WriteToLogFile WriteLogFile = new WriteToLogFile();
    
    //declaration of instance varriables
    public void createDatabase(final String dbPath) {
        File theDatabase = new File(dbPath);
        // if the database does not exist, create it
        if (!theDatabase.exists()) {
            WriteLogFile.writeIntoLog("Creating database: " + theDatabase.getName() + " in " + dbPath);
            boolean result = false;
            try {
                DatabaseBuilder.create(FileFormat.V2010, theDatabase);
                result = true;
            } catch (IOException ex) {
                WriteLogFile.writeIntoLog(ex.toString());
            }
            if (result) {
                WriteLogFile.writeIntoLog("Database created successfully");
            }
        } else {
            WriteLogFile.writeIntoLog("The database " + theDatabase.getName() + " already Exist and will be used");
        }
    }
}
