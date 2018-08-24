package dataoffice;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Borrow {

    private final CommonVarriables CommonVarriables = new CommonVarriables();

    private String SerialNo, Title, Author, Publisher, Subject, Clas, ShelfNo,
            DateAdded, DateBorrowed, borrowerSurname, borrowerUsername, returnDate;
    private int ID;

    public Borrow() {
    }

    public int getID() {
        return ID;
    }

    public String getSerialNo() {
        return SerialNo;
    }

    public String getTitle() {
        return Title;
    }

    public String getAuthor() {
        return Author;
    }

    public String Publisher() {
        return Publisher;
    }

    public String getSubject() {
        return Subject;
    }

    public String getClas() {
        return Clas;
    }

    public String getShelfNo() {
        return ShelfNo;
    }

    public String getDateAdded() {
        return DateAdded;
    }

    public String getDateBorrowed() {
        return DateBorrowed;
    }

    public String getborrowerSurname() {
        return borrowerSurname;
    }

    public String getborrowerUsername() {
        return borrowerUsername;
    }

    public String getreturnDate() {
        return returnDate;
    }

    public void connection() {
        try {
            // Open a connection
            String Query1 = "select * from " + CommonVarriables.tablesToCreate[3];
            ResultSet resultSet = CommonVarriables.getResultSet(Query1);
            while (resultSet.next()) {
                ID = resultSet.getInt(1);
                SerialNo = resultSet.getString(2);
                Title = resultSet.getString(3);
                Author = resultSet.getString(4);
                Publisher = resultSet.getString(5);
                Subject = resultSet.getString(6);
                Clas = resultSet.getString(7);
                ShelfNo = resultSet.getString(8);
                DateAdded = resultSet.getString(9);
                DateBorrowed = resultSet.getString(10);
                borrowerSurname = resultSet.getString(11);
                borrowerUsername = resultSet.getString(12);
                returnDate = resultSet.getString(13);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Borrow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
