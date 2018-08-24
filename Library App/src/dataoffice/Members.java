package dataoffice;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Members {

    CommonVarriables CommonVarriables = new CommonVarriables();
    private String FirstName, MiddleName, Surname, PostalAddress, PhoneNumber,
            AltPhoneNumber, EmailAddress, Username, DateAdded, passwords, identity,
            state, login, IsData = "notAvailable";
    private int ID, NumberOfBooks, duration, maxbooks;//, rowCount;

    public Members() {
    }

    public int getID() {
        return ID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public String getSurame() {
        return Surname;
    }

    public String getPostalAddress() {
        return PostalAddress;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getAltPhoneNumber() {
        return AltPhoneNumber;
    }

    public String getEmailAddress() {
        return EmailAddress;
    }

    public String getUsername() {
        return Username;
    }

    public String getDateAdded() {
        return DateAdded;
    }

    public String getPasswords() {
        return passwords;
    }

    public int getNumberOfBooks() {
        return NumberOfBooks;
    }

    public int getduration() {
        return duration;
    }

    public int getmaxbooks() {
        return maxbooks;
    }

    public String getidentity() {
        return identity;
    }

    public String getstate() {
        return state;
    }

    public String getlogin() {
        return login;
    }
    /*
     public int getrowCount() {
     return rowCount;
     }
     */

    public String getIsData() {
        return IsData;
    }

    public void connection(String Query) {
        try {
            ResultSet resultSet = CommonVarriables.getResultSet(Query);
            while (resultSet.next()) {
                ID = resultSet.getInt(1);
                FirstName = resultSet.getString(2);
                MiddleName = resultSet.getString(3);
                Surname = resultSet.getString(4);
                PostalAddress = resultSet.getString(5);
                PhoneNumber = resultSet.getString(6);
                AltPhoneNumber = resultSet.getString(7);
                EmailAddress = resultSet.getString(8);
                Username = resultSet.getString(9);
                passwords = resultSet.getString(10);
                DateAdded = resultSet.getString(11);
                NumberOfBooks = resultSet.getInt(12);
                duration = resultSet.getInt(13);
                maxbooks = resultSet.getInt(14);
                identity = resultSet.getString(15);
                state = resultSet.getString(16);
                login = resultSet.getString(17);
                IsData = "available";
                // rowCount = resultSet.last() ? resultSet.getRow() : 0;
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }
}
