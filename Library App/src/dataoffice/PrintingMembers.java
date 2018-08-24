package dataoffice;

import java.awt.Container;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JTextArea;

public class PrintingMembers extends JInternalFrame implements Printable {

    private final CommonVarriables CommonVarriables = new CommonVarriables();
    private ResultSet resultset = null;
    //for creating the text area
    private JTextArea textArea = new JTextArea();
    //for creating the vector to use it in the print
    private Vector lines;
    public static final int TAB_SIZE = 5;

    //constructor of JLibrary
    public PrintingMembers(String query) {
        super("Printing Members", false, true, false, true);
        try {
            //for getting the graphical user interface components display area
            Container cp = getContentPane();
            //for setting the font
            textArea.setFont(new Font("Cambria Math", Font.PLAIN, 14));
            //for adding the textarea to the container
            cp.add(textArea);
            resultset = CommonVarriables.getResultSet(query);
            textArea.append("=============== Members Information ===============\n\n");
            while (resultset.next()) {
                String name = resultset.getString(CommonVarriables.columnsToAdd[0][0])
                        + " " + resultset.getString(CommonVarriables.columnsToAdd[0][2]) + " "
                        + resultset.getString(CommonVarriables.columnsToAdd[0][1]);
                textArea.append("Name: " + name + "\n"
                        + "Postal Address: " + resultset.getString(CommonVarriables.columnsToAdd[0][3]) + "\n"
                        + "Phone Number: " + resultset.getString(CommonVarriables.columnsToAdd[0][4]) + "\n"
                        + "Email Address: " + resultset.getString(CommonVarriables.columnsToAdd[0][6]) + "\n\n");
            }
            textArea.append("=============== Members Information ===============");

            //for setting the visible to true
            setVisible(true);
            //to show the frame
            pack();
        } catch (SQLException ex) {
            Logger.getLogger(PrintingMembers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int print(Graphics pg, PageFormat pageFormat, int pageIndex) throws PrinterException {
        pg.translate((int) pageFormat.getImageableX(), (int) pageFormat.getImageableY());
        int wPage = (int) pageFormat.getImageableWidth();
        int hPage = (int) pageFormat.getImageableHeight();
        pg.setClip(0, 0, wPage, hPage);

        pg.setColor(textArea.getBackground());
        pg.fillRect(0, 0, wPage, hPage);
        pg.setColor(textArea.getForeground());

        Font font = textArea.getFont();
        pg.setFont(font);
        FontMetrics fm = pg.getFontMetrics();
        int hLine = fm.getHeight();

        if (lines == null) {
            lines = getLines(fm, wPage);
        }

        int numLines = lines.size();
        int linesPerPage = Math.max(hPage / hLine, 1);
        int numPages = (int) Math.ceil((double) numLines / (double) linesPerPage);
        if (pageIndex >= numPages) {
            lines = null;
            return NO_SUCH_PAGE;
        }
        int x = 0;
        int y = fm.getAscent();
        int lineIndex = linesPerPage * pageIndex;
        while (lineIndex < lines.size() && y < hPage) {
            String str = (String) lines.get(lineIndex);
            pg.drawString(str, x, y);
            y += hLine;
            lineIndex++;
        }
        return PAGE_EXISTS;
    }

    protected Vector getLines(FontMetrics fm, int wPage) {
        Vector v = new Vector();

        String text = textArea.getText();
        String prevToken = "";
        StringTokenizer st = new StringTokenizer(text, "\n\r", true);
        while (st.hasMoreTokens()) {
            String line = st.nextToken();
            if (line.equals("\r")) {
                continue;
            }
            // StringTokenizer will ignore empty lines, so it's a bit tricky to get them...
            if (line.equals("\n") && prevToken.equals("\n")) {
                v.add("");
            }
            prevToken = line;
            if (line.equals("\n")) {
                continue;
            }

            StringTokenizer st2 = new StringTokenizer(line, " \t", true);
            String line2 = "";
            while (st2.hasMoreTokens()) {
                String token = st2.nextToken();
                if (token.equals("\t")) {
                    int numSpaces = TAB_SIZE - line2.length() % TAB_SIZE;
                    token = "";
                    for (int k = 0; k < numSpaces; k++) {
                        token += " ";
                    }
                }
                int lineLength = fm.stringWidth(line2 + token);
                if (lineLength > wPage && line2.length() > 0) {
                    v.add(line2);
                    line2 = token.trim();
                    continue;
                }
                line2 += token;
            }
            v.add(line2);
        }
        return v;
    }
}
