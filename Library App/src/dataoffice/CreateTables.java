package dataoffice;

import com.healthmarketscience.jackcess.ColumnBuilder;
import com.healthmarketscience.jackcess.DataType;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.DatabaseBuilder;
import com.healthmarketscience.jackcess.IndexBuilder;
import com.healthmarketscience.jackcess.TableBuilder;
import java.io.File;
import java.io.IOException;

public class CreateTables {

    //Creating objects of another class
    private final WriteToLogFile WriteLogFile = new WriteToLogFile();
    Database db = null;

    public void createTables(String path, String tableName) {
        // Open a connection
        WriteLogFile.writeIntoLog("Connecting to database " + path);
        try {
            Database myDatabase = null;
            myDatabase = DatabaseBuilder.open(new File(path));
            if (myDatabase.getTableNames().contains(tableName)) {
                WriteLogFile.writeIntoLog("The table *" + tableName + " already Exist and will be used");
            } else {
                WriteLogFile.writeIntoLog("Creating " + tableName + " table...");
                new TableBuilder(tableName)
                        .addColumn(new ColumnBuilder("ID", DataType.LONG).setAutoNumber(true))
                        .addIndex(new IndexBuilder(IndexBuilder.PRIMARY_KEY_NAME).addColumns("ID").setPrimaryKey())
                        .toTable(myDatabase);
                WriteLogFile.writeIntoLog(tableName + " table created successfully...");
            }

        } catch (IOException ex) {
            WriteLogFile.writeIntoLog("Exception occured : " + ex.toString());
        }
    }//end users table
}
