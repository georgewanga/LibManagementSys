package dataoffice;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CommonVarriables {

    //declaration of instance varriables
    private ResultSet resultSet = null;
    private PreparedStatement preparedStatement = null;
    private Statement statement = null;
    public final Date fullDate = new Date();

    private final String localDisk = "C";
    private final String dbFolderName = "My Folder";
    private final String databaseName = "My Database";
    private final String logFolderName = "Logfiles";
    private final String driver = "jdbc:ucanaccess://";
    public final int BORROW_DURATION_days = 100;
    private final DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    private final DateFormat sdf = new SimpleDateFormat("HH:mm:ss");

    public final String dbDirectory = localDisk + ":/" + dbFolderName;
    public final String dbPath = dbDirectory + "/" + databaseName + ".accdb";
    public final String logFileDirectory = dbDirectory + "/" + logFolderName;
    public final String dateToday = dateFormat.format(Calendar.getInstance(TimeZone.getDefault()).getTime());
    public final String CURRENT_TIME = sdf.format(fullDate.getTime());
    public final String logFilePath = logFileDirectory + "/" + dateToday + ".txt";

    public final String mainHeader = "GEORGE'S LIBRARY SYSTEM";
    public final String STATUS_BAR_MSG = "    Date Today: " + dateToday +" " + CURRENT_TIME
            + "             Software Property of © george.wanga@gmail.com";

    public final String[] tablesToCreate = {"Users", "DeletedUsers", "AvailableBooks", "BorrowedBooks", "BorrowLog"};
    public final String[][] columnsToAdd = {
        {"FirstName", "MiddleName", "Surname", "PostalAddress", "PhoneNumber", "AltPhoneNumber", "EmailAddress",
            "Username", "passwords", "DateAdded"},
        {"NumberOfBooks", "duration", "maxbooks"},
        {"identity", "state", "login"},
        {"SerialNo", "title", "author", "publisher", "Subject", "Class", "ShelfNo", "DateAdded"},
        {"Avilability"},
        {"NumberOfAvailbleBooks"},
        {"state"},
        {"DateOfBorrow", "BorrowerName", "BorrowerUserName", "DateOfReturn"},
        {"Identity", "DeleteDate", "DeletedBy", "RasonForDeletion"}};
    public final String COLS_Borrow_books = columnsToAdd[3][0] + "," + columnsToAdd[3][1] + "," + columnsToAdd[3][2] + ","
            + columnsToAdd[3][3] + "," + columnsToAdd[3][4] + "," + columnsToAdd[3][5] + "," + columnsToAdd[3][6] + "," 
            + columnsToAdd[3][7];
    public final String COLS_DELETING_users = columnsToAdd[0][0] + "," + columnsToAdd[0][1] + "," + columnsToAdd[0][2] + "," + columnsToAdd[0][3]
            + "," + columnsToAdd[0][4] + "," + columnsToAdd[0][5] + "," + columnsToAdd[0][6] + "," + columnsToAdd[0][7]
            + "," + columnsToAdd[0][8] + "," + columnsToAdd[0][9] + "," + columnsToAdd[2][0];// + ", '" + dateToday;

    public final String COLS_lISTING_users = columnsToAdd[0][0] + "," + columnsToAdd[0][1] + "," + columnsToAdd[0][2] + "," + columnsToAdd[0][3]
            + "," + columnsToAdd[0][4] + "," + columnsToAdd[0][5] + "," + columnsToAdd[0][6]
            + "," + columnsToAdd[0][9] + "," + columnsToAdd[1][0];
    public final String COLS_Users = columnsToAdd[0][0] + "," + columnsToAdd[0][1] + "," + columnsToAdd[0][2] + "," + columnsToAdd[0][3]
            + "," + columnsToAdd[0][4] + "," + columnsToAdd[0][5] + "," + columnsToAdd[0][6] + "," + columnsToAdd[0][7]
            + "," + columnsToAdd[0][8] + "," + columnsToAdd[0][9] + "," + columnsToAdd[1][0] + "," + columnsToAdd[1][1]
            + "," + columnsToAdd[1][2] + "," + columnsToAdd[2][0] + "," + columnsToAdd[2][1] + "," + columnsToAdd[2][2];
    public final String COLS_AvailableBooks
            = columnsToAdd[3][0] + "," + columnsToAdd[3][1] + "," + columnsToAdd[3][2] + "," + columnsToAdd[3][3]
            + "," + columnsToAdd[3][4] + "," + columnsToAdd[3][5] + "," + columnsToAdd[3][6] + "," + columnsToAdd[3][7]
            + "," + columnsToAdd[4][0];

    public final String[][] DefaultData = {
        {
            COLS_Users,
            columnsToAdd[0][0] + "," + columnsToAdd[0][1] + "," + columnsToAdd[0][2] + "," + columnsToAdd[0][3]
            + "," + columnsToAdd[0][4] + "," + columnsToAdd[0][5] + "," + columnsToAdd[0][6] + "," + columnsToAdd[0][7]
            + "," + columnsToAdd[0][8] + "," + columnsToAdd[0][9] + "," + columnsToAdd[8][0] + "," + columnsToAdd[8][1]
            + "," + columnsToAdd[8][2] + "," + columnsToAdd[8][3],
            COLS_AvailableBooks + "," + columnsToAdd[5][0] + "," + columnsToAdd[6][0],
            columnsToAdd[3][0] + "," + columnsToAdd[3][1] + "," + columnsToAdd[3][2] + "," + columnsToAdd[3][3]
            + "," + columnsToAdd[3][4] + "," + columnsToAdd[3][5] + "," + columnsToAdd[3][6] + "," + columnsToAdd[3][7]
            + "," + columnsToAdd[7][0] + "," + columnsToAdd[7][1] + "," + columnsToAdd[7][2] + "," + columnsToAdd[7][3],
            columnsToAdd[3][0] + "," + columnsToAdd[3][1] + "," + columnsToAdd[3][2] + "," + columnsToAdd[3][3]
            + "," + columnsToAdd[3][4] + "," + columnsToAdd[3][5] + "," + columnsToAdd[3][6] + "," + columnsToAdd[3][7]
            + "," + columnsToAdd[7][0] + "," + columnsToAdd[7][1] + "," + columnsToAdd[7][2] + "," + columnsToAdd[7][3]
        },
        {
            "'George', '-', 'Wanga', 'P. O. Box 32 - 40110 Songhor', '0729646982', '0787445147', "
            + "'george.wanga@gmail.com', 'admin', 'admin', '02/02/2016', 0, 0, 10, 'admin', 'state', 'inactive'",
            "'George', '-', 'Wanga', 'P. O. Box 32 - 40110 Songhor', '0729646982', '0787445147', "
            + "'george.wanga@gmail.com', 'admins', 'admins', '02/02/2016', 'identity', '02/02/2016', 'George', "
            + "'administrative'",
            "'WSPS002', 'Java Programming', 'George Wanga', 'publisher', 'Computer', 'Three', 'ws01', '02/01/2016', "
            + "yes, 3, 'state'",
            "'WSPS003', 'Java Programming', 'Chapman', 'KLB', 'Computer', 'Three', 'ws01', '01-01-2016', '02-01-2016', "
            + "'George Wanga', 'admin', '02-03-2016'",
            "'WSPS004', 'Java Programming', 'Chapman', 'KLB', 'Computer', 'Three', 'ws01', '01-01-2016', '02-01-2016', "
            + "'George Wanga', 'admin', '02-03-2016'"
        }
    };

    public ResultSet getResultSet(String Query) {
        try {
            resultSet = DriverManager.getConnection(driver + dbPath).createStatement().executeQuery(Query);
        } catch (SQLException ex) {
            Logger.getLogger(CommonVarriables.class.getName()).log(Level.SEVERE, null, ex);
            new WriteToLogFile().writeIntoLog(ex.toString());
        }
        return resultSet;
    }

    public PreparedStatement getPreparedStatement(String sql) {
        try {
            preparedStatement = DriverManager.getConnection(driver + dbPath).prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(CommonVarriables.class.getName()).log(Level.SEVERE, null, ex);
            new WriteToLogFile().writeIntoLog(ex.toString());
        }
        return preparedStatement;
    }

    public Statement getStatement(int constant1, int constant2) {
        try {
            statement = DriverManager.getConnection(driver + dbPath).createStatement(constant1, constant2);
        } catch (SQLException ex) {
            Logger.getLogger(CommonVarriables.class.getName()).log(Level.SEVERE, null, ex);
            new WriteToLogFile().writeIntoLog(ex.toString());
        }
        return statement;
    }

    public void getExecutedUpdate(String sql) {
        try {
            DriverManager.getConnection(driver + dbPath).createStatement().executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(CommonVarriables.class.getName()).log(Level.SEVERE, null, ex);
            new WriteToLogFile().writeIntoLog(ex.toString());
        }
    }
}
