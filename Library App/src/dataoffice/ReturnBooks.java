package dataoffice;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ReturnBooks extends JInternalFrame implements ActionListener {

    private final CommonVarriables CommonVarriables = new CommonVarriables();

    private ResultSet resultSet = null;
    /**
     * *************************************************************************
     *** declaration of the private variables used in the program ***
     * *************************************************************************
     */
    //for creating the North Panel
    private final JPanel northPanel = new JPanel();
    //for creating the label
    private final JLabel titleret = new JLabel("BOOK INFORMATION");

    //for creating the Center Panel
    private final JPanel centerPanel = new JPanel();
    //for creating an Internal Panel in the center panel
    private final JPanel informationPanel = new JPanel();
    //for creating an array of JLabel
    private final JLabel[] informationLabel = new JLabel[2];
    //for creating an array of String
    private final String[] informationString = {" Write the Book serial no:", " Write the Username:"};
    //for creating an array of JTextField
    private final JTextField[] informationTextField = new JTextField[2];
    //for creating an array of string to store the data
    private String[] data;
    private final JLabel lblFinePerDay = new JLabel("Fine per Day");
    private final JTextField txtFinePerDay = new JTextField();
    private final JLabel lblTotalFineAmt = new JLabel("Total fine amount");
    private final JTextField txtTotalFineAmt = new JTextField();
    //for creating an Internal Panel in the center panel
    private final JPanel returnButtonPanel = new JPanel();
    //for creating the buton
    private final JButton returnButton = new JButton("Return");

    //for creating the panel
    private final JPanel southPanel = new JPanel();
    //for creating the button
    private final JButton cancelButton = new JButton("Cancel");

    //for creating an object
    private Books book;
    private BooksBorrowed borrowed;
    private Members member;
    private Borrow borrow;

    //for checking the information from the text field
    public boolean isCorrect() {
        data = new String[2];
        for (int i = 0; i < informationLabel.length; i++) {
            if (!informationTextField[i].getText().equals("")) {
                data[i] = informationTextField[i].getText().trim();
            } else {
                return false;
            }
        }
        return true;
    }

    //for setting the array of JTextField to null
    public void clearTextField() {
        for (int i = 0; i < informationLabel.length; i++) {
            informationTextField[i].setText(null);
            txtFinePerDay.setText(null);
            txtTotalFineAmt.setText(null);
        }
    }

    //constructor of returnBooks
    public ReturnBooks() {
        //for setting the title for the internal frame
        super("Return books", false, true, false, true);
        //for setting the icon
        setFrameIcon(new ImageIcon(ClassLoader.getSystemResource("images/Import16.gif")));
        //for getting the graphical user interface components display area
        Container cp = getContentPane();

        //for setting the layout
        northPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        //for setting the font
        titleret.setFont(new Font("Cambria Math", Font.BOLD, 14));
        //for adding the label
        northPanel.add(titleret);
        //for adding the north panel to the container
        cp.add("North", northPanel);

        //for setting the layout
        centerPanel.setLayout(new BorderLayout());
        //for setting the layout for the internal panel
        informationPanel.setLayout(new GridLayout(4, 2, 1, 25));

        /**
         * *********************************************************************
         * for adding the strings to the labels, for setting the font * and
         * adding these labels to the panel.	* finally adding the panel to the
         * container	*
         * *********************************************************************
         */
        for (int i = 0; i < informationLabel.length; i++) {
            informationPanel.add(informationLabel[i] = new JLabel(informationString[i]));
            informationLabel[i].setFont(new Font("Cambria Math", Font.BOLD, 14));
            informationPanel.add(informationTextField[i] = new JTextField());
            informationTextField[i].setFont(new Font("Cambria Math", Font.PLAIN, 14));
        }
        informationPanel.add(lblFinePerDay);
        informationPanel.add(txtFinePerDay);
        informationPanel.add(lblTotalFineAmt);
        informationPanel.add(txtTotalFineAmt);
        txtTotalFineAmt.setEditable(false);
        txtFinePerDay.addKeyListener((KeyListener) new keyListener());
        centerPanel.add("Center", informationPanel);
        //for setting the layout
        returnButtonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        //for adding the button
        returnButtonPanel.add(returnButton);
        //for setting the font to the button
        returnButton.setFont(new Font("Cambria Math", Font.BOLD, 14));
        //for adding the internal panel to the panel
        centerPanel.add("South", returnButtonPanel);
        //for setting the border
        centerPanel.setBorder(BorderFactory.createTitledBorder("Return a book:"));
        //for adding the center panel to the container
        cp.add("Center", centerPanel);

        //for setting the layout
        southPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        //for adding the button

        southPanel.add(cancelButton);
        //for setting the font to the button
        cancelButton.setFont(new Font("Cambria Math", Font.BOLD, 14));
        //for setting the border
        southPanel.setBorder(BorderFactory.createEtchedBorder());
        //for adding the south panel to the container
        cp.add("South", southPanel);

        /**
         * *********************************************************************
         * for adding the action listener to the button,first the text will be *
         * taken from the JTextField and make the connection for database, *
         * after that update the table in the database with the new value *
         * *********************************************************************
         */
        returnButton.addActionListener(this);
        //for adding the action listener for the button to dispose the frame
        cancelButton.addActionListener(this);
        //for setting the visible to true
        setVisible(true);
        //show the internal frame
        pack();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == returnButton) {
            //for checking if there is a missing information
            if (isCorrect()) {
                Thread runner = new Thread() {

                    @Override
                    public void run() {
                        book = new Books();
                        borrowed = new BooksBorrowed();
                        member = new Members();
                        borrow = new Borrow();

                        String Query1 = "SELECT * FROM " + CommonVarriables.tablesToCreate[3] + " WHERE " + CommonVarriables.columnsToAdd[0][7]
                                + " = '" + data[1] + "' AND " + CommonVarriables.columnsToAdd[3][0] + " = '" + data[0] + "'";
                        String Query2 = "SELECT * FROM " + CommonVarriables.tablesToCreate[2] + " WHERE " + CommonVarriables.columnsToAdd[3][0]
                                + " = '" + data[0] + "'";
                        String Query3 = "SELECT * FROM " + CommonVarriables.tablesToCreate[0] + " WHERE " + CommonVarriables.columnsToAdd[0][7]
                                + " = '" + data[1] + "'";

                        System.out.println(Query1);
                        System.out.println(Query2);
                        System.out.println(Query3);

                        borrowed.connection(Query1);
                        book.connection(Query2);
                        member.connection(Query3);

                        String checkUsername;
                        checkUsername = member.getIsData();
                        String checkSerialNo;
                        checkSerialNo = book.getIsData();
                        String checkIfBorrowed;
                        checkIfBorrowed = borrowed.getIsData();
                        int numberOfAvailbleBooks = book.getNumberOfAvailbleBooks();
                        int numberOfBooks = member.getNumberOfBooks();
                        //for checking if there is no same information in the database
                        if (checkUsername.equals("available")) {
                            //for checking if there is no same information in the database
                            if (checkSerialNo.equals("available")) {

                                if (numberOfAvailbleBooks == 0 && numberOfBooks > 0) {
                                    if (checkIfBorrowed.equals("available")) {

                                        numberOfAvailbleBooks += 1;
                                        numberOfBooks -= 1;

                                        String sql1 = "UPDATE  " + CommonVarriables.tablesToCreate[2] + " SET " + CommonVarriables.columnsToAdd[5][0]
                                                + " =" + numberOfAvailbleBooks + "," + CommonVarriables.columnsToAdd[4][0] + " = true WHERE "
                                                + CommonVarriables.columnsToAdd[3][0] + " = '" + data[0] + "'";
                                        String sql2 = "UPDATE " + CommonVarriables.tablesToCreate[0] + " SET " + CommonVarriables.columnsToAdd[1][0]
                                                + " = " + numberOfBooks + " WHERE " + CommonVarriables.columnsToAdd[0][7] + " =  '" + data[1] + "'";
                                        String sql3 = "INSERT INTO " + CommonVarriables.tablesToCreate[4] + " SELECT * FROM " + CommonVarriables.tablesToCreate[3]
                                                + " WHERE " + CommonVarriables.columnsToAdd[3][0] + " = '" + data[0] + "' AND "
                                                + CommonVarriables.columnsToAdd[0][7] + " = '" + data[1] + "'";
                                        String sql4 = "DELETE FROM " + CommonVarriables.tablesToCreate[3] + " WHERE " + CommonVarriables.columnsToAdd[3][0]
                                                + " = '" + data[0] + "' AND " + CommonVarriables.columnsToAdd[0][7]
                                                + " = '" + data[1] + "'";

                                        System.out.println(sql1);
                                        System.out.println(sql2);
                                        System.out.println(sql3);
                                        System.out.println(sql4);
                                        // CommonVarriables.getExecutedUpdate(sql1);
                                        // CommonVarriables.getExecutedUpdate(sql2);
                                        //  CommonVarriables.getExecutedUpdate(sql3);
                                        //  CommonVarriables.getExecutedUpdate(sql4);
                                        //for setting the array of JTextField to null
                                        JOptionPane.showMessageDialog(null, "The book is Successfully returned", "Success", JOptionPane.INFORMATION_MESSAGE);
                                        clearTextField();
                                    } else {
                                        JOptionPane.showMessageDialog(null, "borrower and book serial do not match !! ", "Information", JOptionPane.WARNING_MESSAGE);
                                        // informationTextField[0].setText(null);
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "The book is not borrowed", "Warning", JOptionPane.WARNING_MESSAGE);
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "There is no book with that serial number !! \n You can view the list of books to enter the correct serial", "Information", JOptionPane.WARNING_MESSAGE);
                                informationTextField[0].setText(null);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "The username is does not exist !! \n Create an account to borrow book", "Information", JOptionPane.WARNING_MESSAGE);
                            informationTextField[1].setText(null);
                        }
                    }
                };
                runner.start();
            } //if there is a missing data, then display Message Dialog
            else {
                JOptionPane.showMessageDialog(null, "Please, complete the information", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
        if (ae.getSource() == cancelButton) {
            dispose();
        }
    }

    class keyListener extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent k) {

            Date theDate;
            if (k.getKeyCode() == KeyEvent.VK_ENTER) {
                try {
                    int fineamt = Integer.parseInt(txtFinePerDay.getText().trim());
                    String serialNo = informationTextField[0].getText().trim();
                    String username = informationTextField[1].getText().trim();
                    String Query = "SELECT " + CommonVarriables.columnsToAdd[7][3] + " from " + CommonVarriables.tablesToCreate[3] + " WHERE  "
                            + CommonVarriables.columnsToAdd[0][7] + " =  '" + username + "' AND " + CommonVarriables.columnsToAdd[3][0] + " = '"
                            + serialNo + "'";
                    
                    System.out.println(Query);
                    
                    resultSet = CommonVarriables.getResultSet(Query);
                    
                    if (resultSet.next()) {
                        theDate = resultSet.getDate(1);
                        Date today = new Date();
                        Date retdate = new Date(theDate.getYear(), theDate.getMonth(), theDate.getDate());
                        JOptionPane.showMessageDialog(null, "today=" + today + "\nRet date=" + retdate);
                        
                        System.out.println(today.after(theDate));
                        
                        if (today.after(theDate)) {
                            long finedays = today.getTime() - theDate.getTime();
                            int days = (int) (finedays / (1000 * 60 * 60 * 24));
                            System.out.println(days);
                            txtTotalFineAmt.setText(String.valueOf(fineamt * days));
                        } else {
                            txtTotalFineAmt.setText("0");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Member username entered not found on databse");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(ReturnBooks.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//inner class closed
}//class closed
