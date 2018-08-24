package dataoffice;

public class RunApp {

    private final String dbPath;
    private final CommonVarriables CommonVarriables = new CommonVarriables();

    // public void RunOrder() {
    public RunApp() {
        dbPath = CommonVarriables.dbPath;
        String[] tableName = CommonVarriables.tablesToCreate;
        String[][] defaultData = CommonVarriables.DefaultData;
        String[] Directory = {CommonVarriables.dbDirectory, CommonVarriables.logFileDirectory};

        new CreateDirectory().createDirectory(Directory);
        new CreateLogFile().createLogFile(CommonVarriables.logFilePath, CommonVarriables.fullDate);
        new CreateDatabase().createDatabase(dbPath);
        for (int i = 0; i < tableName.length; i++) {
            new CreateTables().createTables(dbPath, tableName[i]);
            new CreateColumns().createColumns(dbPath, tableName[i], CommonVarriables.columnsToAdd, i);
            new AddDefaultData().addDefaultData(defaultData[0][i], defaultData[1][i], tableName[i], i);
        }
       // JOptionPane.showMessageDialog(null, "Defaults check complete!!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }
}
