package dataoffice;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Books {

    private String SerialNo, title, author, publisher, Subject, Clas, ShelfNo,
            DateAdded, state, IsData = "notAvailable";
    private boolean availbility;
    private int ID, NumberOfAvailbleBooks;

    public Books() {
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

    public boolean getAvailble() {
        return availbility;
    }

    public int getNumberOfAvailbleBooks() {
        return NumberOfAvailbleBooks;
    }

    public String getstate() {
        return state;
    }

    public String getIsData() {
        return IsData;
    }

    public void connection(String Query) {
        try {
            ResultSet resultSet = new CommonVarriables().getResultSet(Query);
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
                availbility = resultSet.getBoolean(10);
                NumberOfAvailbleBooks = resultSet.getInt(11);
                state = resultSet.getString(12);
                IsData = "available";
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }
}
