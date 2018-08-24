package dataoffice;

import com.healthmarketscience.jackcess.ColumnBuilder;
import com.healthmarketscience.jackcess.DataType;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.DatabaseBuilder;
import com.healthmarketscience.jackcess.Table;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CreateColumns {

    //Creating objects of another class
    private final WriteToLogFile WriteLogFile = new WriteToLogFile();

    public void createColumns(final String path, final String tableName, final String[][] columnTitle, final int run) {
        try {
            Database db = DatabaseBuilder.open(new File(path));
            if (run == 0) {
                WriteLogFile.writeIntoLog("*************** Columns added to " + tableName + " table ***************");
                Table myTable = db.getTable(tableName);
                for (int i = 0; i < columnTitle[0].length; i++) {
                    if (myTable.getColumns().toString().contains(columnTitle[0][i])) {
                        WriteLogFile.writeIntoLog("The column *" + columnTitle[0][i] + " already Exist and will be used");
                    } else {
                        new ColumnBuilder(columnTitle[0][i])
                                .setType(DataType.TEXT)
                                .addToTable(myTable);
                        WriteLogFile.writeIntoLog(columnTitle[0][i]);
                    }
                }

                for (int i = 0; i < columnTitle[1].length; i++) {
                    if (myTable.getColumns().toString().contains(columnTitle[1][i])) {
                        WriteLogFile.writeIntoLog("The column *" + columnTitle[1][i] + " already Exist and will be used");
                    } else {
                        new ColumnBuilder(columnTitle[1][i])
                                .setType(DataType.INT)
                                .addToTable(myTable);
                        WriteLogFile.writeIntoLog(columnTitle[1][i]);
                    }
                }
                for (int i = 0; i < columnTitle[2].length; i++) {
                    if (myTable.getColumns().toString().contains(columnTitle[2][i])) {
                        WriteLogFile.writeIntoLog("The column *" + columnTitle[2][i] + " already Exist and will be used");
                    } else {
                        new ColumnBuilder(columnTitle[2][i])
                                .setType(DataType.TEXT)
                                .addToTable(myTable);
                        WriteLogFile.writeIntoLog(columnTitle[2][i]);
                    }
                }
                WriteLogFile.writeIntoLog("******************** END " + run + " ********************");
            } else if (run == 1) {
                WriteLogFile.writeIntoLog("*************** Columns added to " + tableName + " table ***************");
                Table myTable = db.getTable(tableName);
                for (int i = 0; i < columnTitle[0].length; i++) {
                    if (myTable.getColumns().toString().contains(columnTitle[0][i])) {
                        WriteLogFile.writeIntoLog("The column *" + columnTitle[0][i] + " already Exist and will be used");
                    } else {
                        new ColumnBuilder(columnTitle[0][i])
                                .setType(DataType.TEXT)
                                .addToTable(myTable);
                        WriteLogFile.writeIntoLog(columnTitle[0][i]);
                    }
                }
                for (int i = 0; i < columnTitle[8].length; i++) {
                    if (myTable.getColumns().toString().contains(columnTitle[8][i])) {
                        WriteLogFile.writeIntoLog("The column *" + columnTitle[8][i] + " already Exist and will be used");
                    } else {
                        new ColumnBuilder(columnTitle[8][i])
                                .setType(DataType.TEXT)
                                .addToTable(myTable);
                        WriteLogFile.writeIntoLog(columnTitle[8][i]);
                    }
                }
                WriteLogFile.writeIntoLog("******************** END " + run + " ********************");
            } else if (run == 2) {
                WriteLogFile.writeIntoLog("*************** Columns added to " + tableName + " table ***************");
                Table myTable = db.getTable(tableName);
                for (int i = 0; i < columnTitle[3].length; i++) {
                    if (myTable.getColumns().toString().contains(columnTitle[3][i])) {
                        WriteLogFile.writeIntoLog("The column *" + columnTitle[3][i] + " already Exist and will be used");
                    } else {
                        new ColumnBuilder(columnTitle[3][i])
                                .setType(DataType.TEXT)
                                .addToTable(myTable);
                        WriteLogFile.writeIntoLog(columnTitle[3][i]);
                    }
                }
                for (int i = 0; i < columnTitle[4].length; i++) {
                    if (myTable.getColumns().toString().contains(columnTitle[4][i])) {
                        WriteLogFile.writeIntoLog("The column *" + columnTitle[4][i] + " already Exist and will be used");
                    } else {
                        new ColumnBuilder(columnTitle[4][i])
                                .setType(DataType.BOOLEAN)
                                .addToTable(myTable);
                        WriteLogFile.writeIntoLog(columnTitle[4][i]);
                    }
                }
                for (int i = 0; i < columnTitle[5].length; i++) {
                    if (myTable.getColumns().toString().contains(columnTitle[5][i])) {
                        WriteLogFile.writeIntoLog("The column *" + columnTitle[5][i] + " already Exist and will be used");
                    } else {
                        new ColumnBuilder(columnTitle[5][i])
                                .setType(DataType.INT)
                                .addToTable(myTable);
                        WriteLogFile.writeIntoLog(columnTitle[5][i]);
                    }
                }
                for (int i = 0; i < columnTitle[6].length; i++) {
                    if (myTable.getColumns().toString().contains(columnTitle[6][i])) {
                        WriteLogFile.writeIntoLog("The column *" + columnTitle[6][i] + " already Exist and will be used");
                    } else {
                        new ColumnBuilder(columnTitle[6][i])
                                .setType(DataType.TEXT)
                                .addToTable(myTable);
                        WriteLogFile.writeIntoLog("Column added: " + columnTitle[6][i]);
                    }
                }
                WriteLogFile.writeIntoLog("******************** END " + run + " ********************");
            } else if (run == 3) {
                WriteLogFile.writeIntoLog("*************** Columns added to " + tableName + " table ***************");
                Table myTable = db.getTable(tableName);
                for (int i = 0; i < columnTitle[3].length; i++) {
                    if (myTable.getColumns().toString().contains(columnTitle[3][i])) {
                        WriteLogFile.writeIntoLog("The column *" + columnTitle[3][i] + " already Exist and will be used");
                    } else {
                        new ColumnBuilder(columnTitle[3][i])
                                .setType(DataType.TEXT)
                                .addToTable(myTable);
                        WriteLogFile.writeIntoLog(columnTitle[3][i]);
                    }
                }
                for (int i = 0; i < columnTitle[7].length; i++) {
                    if (myTable.getColumns().toString().contains(columnTitle[7][i])) {
                        WriteLogFile.writeIntoLog("The column *" + columnTitle[7][i] + " already Exist and will be used");
                    } else {
                        new ColumnBuilder(columnTitle[7][i])
                                .setType(DataType.TEXT)
                                .addToTable(myTable);
                        WriteLogFile.writeIntoLog(columnTitle[7][i]);
                    }
                }
                WriteLogFile.writeIntoLog("******************** END " + run + " ********************");
            } else if (run == 4) {
                WriteLogFile.writeIntoLog("*************** Columns added to " + tableName + " table ***************");
                Table myTable = db.getTable(tableName);
                for (int i = 0; i < columnTitle[3].length; i++) {
                    if (myTable.getColumns().toString().contains(columnTitle[3][i])) {
                        WriteLogFile.writeIntoLog("The column *" + columnTitle[3][i] + " already Exist and will be used");
                    } else {
                        new ColumnBuilder(columnTitle[3][i])
                                .setType(DataType.TEXT)
                                .addToTable(myTable);
                        WriteLogFile.writeIntoLog(columnTitle[3][i]);
                    }
                }
                for (int i = 0; i < columnTitle[7].length; i++) {
                    if (myTable.getColumns().toString().contains(columnTitle[7][i])) {
                        WriteLogFile.writeIntoLog("The column *" + columnTitle[7][i] + " already Exist and will be used");
                    } else {
                        new ColumnBuilder(columnTitle[7][i])
                                .setType(DataType.TEXT)
                                .addToTable(myTable);
                        WriteLogFile.writeIntoLog(columnTitle[7][i]);
                    }
                }
                WriteLogFile.writeIntoLog("******************** END " + run + " ********************");
            } else if (run > 4) {
                WriteLogFile.writeIntoLog("*************** Columns added to " + tableName + " table ***************");
                WriteLogFile.writeIntoLog("Please consider creating a table for new columns");
                WriteLogFile.writeIntoLog("******************** END " + run + " ********************");
            } else {
            }
        } catch (IOException ex) {
            Logger.getLogger(CreateColumns.class.getName()).log(Level.SEVERE, null, ex);
            WriteLogFile.writeIntoLog("Exception: " + ex.getMessage().toString());
        }
    }
}
