package dataoffice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyVetoException;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

public class JLibrary extends JFrame implements ActionListener {

    private final CommonVarriables CommonVarriables = new CommonVarriables();
    private final Menubar menu = new Menubar();
    private final Toolbar toolbar = new Toolbar();
    private final JDesktopPane desktop = new JDesktopPane();
    private final JPanel searchPanel = new JPanel();
    private final JToolBar searchToolBar = new JToolBar();
    private final JLabel searchLabel = new JLabel("Book title: ");
    private final JTextField searchTextField = new JTextField(15);
    private final JButton goButton = new JButton("Go");
    private final StatusBar statusbar = new StatusBar();
    private AddBooks addBooks;
    private AddMembers addMembers;
    private ListMembers listMembers;
    private ListBooks listBooks;
    private BorrowBooks borrowBooks;
    private ReturnBooks returnBooks;
    private DeleteMembers deleteMembers;
    private SearchBooksAndMembers search;
    private Members member;

    private final String usersTable = CommonVarriables.tablesToCreate[0];
    private final String login = CommonVarriables.columnsToAdd[2][2];

    public JLibrary() {
        super(new CommonVarriables().mainHeader);
        //for setting the size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width - 50, screenSize.height - 50);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        Toolkit kit = Toolkit.getDefaultToolkit();
        Image image = kit.getImage(ClassLoader.getSystemResource("images/logo.png"));
        setIconImage(image);
        // menu bar Action.........
        setJMenuBar(menu);
        menu.exit.addActionListener(this);
        menu.addBook.addActionListener(this);
        menu.listBook.addActionListener(this);
        menu.addMember.addActionListener(this);
        menu.listMember.addActionListener(this);
        menu.deleteMember.addActionListener(this);
        menu.searchBooksAndMembers.addActionListener(this);
        menu.borrowBook.addActionListener(this);
        menu.returnBook.addActionListener(this);

        //get the graphical user interface components display the desktop
        Container cp = getContentPane();
        desktop.setOpaque(true);
        desktop.setBackground(Color.black);
        cp.add("Center", desktop);
        //for setting the font
        searchLabel.setFont(new Font("Cambria Math", Font.BOLD, 14));
        //for setting the font
        searchTextField.setFont(new Font("Cambria Math", Font.PLAIN, 14));
        goButton.setFont(new Font("Cambria Math", Font.BOLD, 14));
        //for adding the searchLable to the searchToolBar
        searchToolBar.add(searchLabel);
        //for adding the searchTextField to searchToolBar
        searchToolBar.add(searchTextField);
        //for adding the goButton to searchToolBar
        searchToolBar.add(goButton);
        //for adding listenerAction for the button
        goButton.addActionListener(this);
        //for setting the layout
        searchPanel.setLayout(new BorderLayout());
        //for adding the toolBar to the searchPanel
        searchPanel.add("Center", toolbar);
        //for adding the searchPanel to the Container
        cp.add("North", searchPanel);
        //for adding the statusbar to the Container
        cp.add("South", statusbar);

        for (int i = 0; i < toolbar.imageName.length; i++) {
            //for adding the action to the button
            toolbar.button[i].addActionListener(this);
        }
        //for adding WindowListener to the program
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        //show the program
        show();
    }

    //this method is invoked when an action occurs.
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == menu.addBook || ae.getSource() == toolbar.button[0]) {
            Thread runner = new Thread() {
                @Override
                public void run() {
                    addBooks = new AddBooks();
                    desktop.add(addBooks);
                    try {
                        addBooks.setSelected(true);
                    } catch (PropertyVetoException ex) {
                        System.err.println(ex.toString());
                    }
                }
            };
            runner.start();
        }
        if (ae.getSource() == menu.listBook || ae.getSource() == toolbar.button[1]) {
            Thread runner = new Thread() {
                @Override
                public void run() {
                    try {
                        listBooks = new ListBooks();
                        desktop.add(listBooks);
                        listBooks.setSelected(true);
                    } catch (PropertyVetoException ex) {
                        System.err.println(ex.toString());
                    }
                }
            };
            runner.start();
        }
        if (ae.getSource() == menu.addMember || ae.getSource() == toolbar.button[2]) {
            Thread runner = new Thread() {

                @Override
                public void run() {
                    try {
                        addMembers = new AddMembers();
                        desktop.add(addMembers);
                        addMembers.setSelected(true);
                    } catch (PropertyVetoException ex) {
                        System.err.println(ex.toString());
                    }
                }
            };
            runner.start();
        }
        if (ae.getSource() == menu.listMember || ae.getSource() == toolbar.button[3]) {
            Thread runner = new Thread() {

                @Override
                public void run() {
                    try {
                        listMembers = new ListMembers();
                        desktop.add(listMembers);
                        listMembers.setSelected(true);
                    } catch (PropertyVetoException ex) {
                        System.err.println(ex.toString());
                    }
                }
            };
            runner.start();
        }
        if (ae.getSource() == menu.deleteMember || ae.getSource() == toolbar.button[4]) {
            Thread runner = new Thread() {

                @Override
                public void run() {

                    member = new Members();
                    member.connection("SELECT * FROM " + usersTable + " WHERE " + login + " = 'active'");
                    String Identity = member.getidentity();
                    if (Identity.equalsIgnoreCase("admin")) {
                        try {
                            deleteMembers = new DeleteMembers();
                            desktop.add(deleteMembers);
                            deleteMembers.setSelected(true);
                        } catch (PropertyVetoException ex) {
                        System.err.println(ex.toString());
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Sorry! Only Administrators Can Delete Existing User !!", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                }
            };
            runner.start();
        }
        if (ae.getSource() == menu.searchBooksAndMembers || ae.getSource() == toolbar.button[5]) {
            Thread runner = new Thread() {

                @Override
                public void run() {
                    try {
                        search = new SearchBooksAndMembers();
                        desktop.add(search);
                        search.setSelected(true);
                    } catch (PropertyVetoException ex) {
                        System.err.println(ex.toString());
                    }
                }
            };
            runner.start();
        }
        if (ae.getSource() == menu.borrowBook || ae.getSource() == toolbar.button[6]) {
            Thread runner = new Thread() {

                @Override
                public void run() {
                    try {
                        borrowBooks = new BorrowBooks();
                        desktop.add(borrowBooks);
                        borrowBooks.setSelected(true);
                    } catch (PropertyVetoException ex) {
                        System.err.println(ex.toString());
                    }
                }
            };
            runner.start();
        }
        if (ae.getSource() == menu.returnBook || ae.getSource() == toolbar.button[7]) {
            Thread runner;
            runner = new Thread() {

                @Override
                public void run() {
                    try {
                        returnBooks = new ReturnBooks();
                        desktop.add(returnBooks);
                        returnBooks.setSelected(true);
                    } catch (PropertyVetoException ex) {
                        System.err.println(ex.toString());
                    }
                }
            };
            runner.start();
        }
        if (ae.getSource() == menu.exit || ae.getSource() == toolbar.button[8]) {
            CommonVarriables.getExecutedUpdate("UPDATE " + usersTable + " SET " + login + " = 'inactive' where " + login + " = 'active'");
            JOptionPane.showMessageDialog(null, "THANK YOU FOR USING OUR LIBRARY", "BYE !!!", JOptionPane.INFORMATION_MESSAGE);
            dispose();
            System.exit(0);
        }
    }
}
