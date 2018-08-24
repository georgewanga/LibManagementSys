package dataoffice;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BooksBorrowed {
    private final CommonVarriables CommonVarriables = new CommonVarriables();
    private ResultSet resultSet = null;

    private String SerialNo, title, author, publisher, Subject, Clas, ShelfNo,
            DateAdded, DateBorrowed, borrowerName, Username, ReturnDate, IsData = "notAvailable";
    private int ID;

    public BooksBorrowed() {
    }

    public int getID() {
        return ID;
    }

    public String getSerialNo() {
        return SerialNo;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
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

    public String getborrowerName() {
        return borrowerName;
    }

    public String getUsername() {
        return Username;
    }

    public String getReturnDate() {
        return ReturnDate;
    }

    public String getIsData() {
        return IsData;
    }

    public void connection(String Query) {
        try {
            resultSet = CommonVarriables.getResultSet(Query);
            while (resultSet.next()) {
                ID = resultSet.getInt(1);
                SerialNo = resultSet.getString(2);
                title = resultSet.getString(3);
                author = resultSet.getString(4);
                publisher = resultSet.getString(5);
                Subject = resultSet.getString(6);
                Clas = resultSet.getString(7);
                ShelfNo = resultSet.getString(8);
                DateAdded = resultSet.getString(9);
                DateBorrowed = resultSet.getString(10);
                borrowerName = resultSet.getString(11);
                Username = resultSet.getString(12);
                ReturnDate = resultSet.getString(13);
                IsData = "available";
            }
        } catch (SQLException ex) {
            Logger.getLogger(BooksBorrowed.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
