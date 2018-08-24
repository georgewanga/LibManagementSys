package dataoffice;

import java.sql.SQLException;

public class AddDefaultData {

    //Creating objects of another class
    private final WriteToLogFile WriteLogFile = new WriteToLogFile();

    public void addDefaultData(String title, String data, String tableName, int run) {
        try {
            if (new CommonVarriables().getResultSet("SELECT * FROM " + tableName + " WHERE ID = '1'").next()) {
                WriteLogFile.writeIntoLog(tableName + " table defaults exists");
            } else {
                new CommonVarriables().getExecutedUpdate("INSERT INTO " + tableName + " (" + title + ") VALUES (" + data + ")");
                WriteLogFile.writeIntoLog(tableName + " table defaults added successfully...");
            }
        } catch (SQLException ex) {
            WriteLogFile.writeIntoLog(ex.toString());
        }

    }
}
