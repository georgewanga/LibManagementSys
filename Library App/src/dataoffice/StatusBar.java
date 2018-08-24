package dataoffice;

import java.awt.Color;
import java.awt.Font;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

public class StatusBar extends JPanel {

    private final Members member = new Members();
    private final JLabel statusBar = new JLabel();

    //constructor of StatusBar
    public StatusBar() {
        member.connection("SELECT * FROM " + new CommonVarriables().tablesToCreate[0] + " WHERE "
                + new CommonVarriables().columnsToAdd[2][2] + " = 'active'");
        String nom = member.getFirstName() + " " + member.getSurame() + " " + member.getMiddleName();

        statusBar.addAncestorListener(null);
        statusBar.setOpaque(true);
        statusBar.setFont(new Font("Lucida Calligraphy", Font.BOLD, 15));
        statusBar.setBackground(Color.WHITE);
        statusBar.setForeground(Color.BLACK);
        //statusBar.setText("Logged in as : " + nom + "    At: " + new CommonVarriables().STATUS_BAR_MSG);

        Thread clock = new Thread() {
            @Override
            public void run() {
                for (;;) {
                    try {
                        statusBar.setText("Logged in as : " + nom + new CommonVarriables().STATUS_BAR_MSG);
                        sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(StatusBar.class
                                .getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        clock.start();

        this.add(statusBar);
        this.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
    }
}
