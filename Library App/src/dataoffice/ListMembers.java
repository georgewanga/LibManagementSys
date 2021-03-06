package dataoffice;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

public class ListMembers extends JInternalFrame {

    private final CommonVarriables CommonVarriables = new CommonVarriables();

    //for creating the North Panel
    private final JPanel northPanel = new JPanel();
    //for creating the Center Panel
    private final JPanel centerPanel = new JPanel();
    //for creating the label
    private final JLabel label = new JLabel("MEMBERS LIST");
    //for creating the button
    private JButton printButton = null;
    //for creating the table
    private JTable table = null;
    //for creating the TableColumn
    private TableColumn column = null;
    //for creating the JScrollPane
    private JScrollPane scrollPane = null;
    //for creating an object for the ResultSetTableModel class
    private ResultSetTableModel tableModel = null;
    private final String DEFAULT_QUERY = "SELECT " + CommonVarriables.COLS_lISTING_users + " FROM " + CommonVarriables.tablesToCreate[0];

    //constructor of listMembers
    public ListMembers() {
        //for setting the title for the internal frame
        super("Members", false, true, false, true);
        try {
            //for setting the icon
            setFrameIcon(new ImageIcon(ClassLoader.getSystemResource("images/List16.gif")));
            //for getting the graphical user interface components display area
            Container cp = getContentPane();
            tableModel = new ResultSetTableModel(DEFAULT_QUERY);
            //for setting the table with the information
            table = new JTable(tableModel);
            //for setting the size for the table
            table.setPreferredScrollableViewportSize(new Dimension(1280, 450));
            //for setting the font
            table.setFont(new Font("Cambria Math", Font.PLAIN, 14));
            //for setting the scrollpane to the table
            scrollPane = new JScrollPane(table);

            //for setting the size for the table columns
            for (int i = 0; i < 9; i++) {
                column = table.getColumnModel().getColumn(i);
                if (i == 3) {
                    column.setPreferredWidth(110);
                } else if (i == 6) {
                    column.setPreferredWidth(80);
                } else if (i == 7 | i == 8) {
                    column.setPreferredWidth(20);
                } else {
                    column.setPreferredWidth(30);
                }
            }
            //for setting the font to the label
            label.setFont(new Font("Cambria Math", Font.BOLD, 14));
            //for setting the layout to the panel
            northPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
            //for adding the label to the panel
            northPanel.add(label);
            //for adding the panel to the container
            cp.add("North", northPanel);

            //for setting the layout to the panel
            centerPanel.setLayout(new BorderLayout());
            //for creating an image for the button
            ImageIcon printIcon = new ImageIcon(ClassLoader.getSystemResource("images/Print16.gif"));
            //for adding the button to the panel
            printButton = new JButton("print the members", printIcon);
            //for setting the tip text
            printButton.setToolTipText("Print");
            //for setting the font to the button
            printButton.setFont(new Font("Cambria Math", Font.PLAIN, 14));
            //for adding the button to the panel
            centerPanel.add(printButton, BorderLayout.NORTH);
            //for adding the scrollpane to the panel
            centerPanel.add(scrollPane, BorderLayout.CENTER);
            //for setting the border to the panel
            centerPanel.setBorder(BorderFactory.createTitledBorder("Members:"));
            //for adding the panel to the container
            cp.add("Center", centerPanel);

            //for adding the actionListener to the button
            printButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    Thread runner = new Thread() {
                        @Override
                        public void run() {
                            try {
                                PrinterJob prnJob = PrinterJob.getPrinterJob();
                                prnJob.setPrintable(new PrintingMembers(DEFAULT_QUERY));
                                if (!prnJob.printDialog()) {
                                    return;
                                }
                                setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                                prnJob.print();
                                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                            } catch (PrinterException ex) {
                                JOptionPane.showMessageDialog(null, ex);
                            }
                        }
                    };
                    runner.start();
                }
            });
            //for setting the visible to true
            setVisible(true);
            //to show the frame
            pack();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ListMembers.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
