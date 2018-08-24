package dataoffice;

import javax.swing.JOptionPane;

public class Login {

    // Initializing varriables
    CommonVarriables CommonVarriables = new CommonVarriables();
    Members memberObject = new Members();
    LoginFrame loginFrameObject = new LoginFrame();
    private final String usersTable = CommonVarriables.tablesToCreate[0];
    private final String login = CommonVarriables.columnsToAdd[2][2];
    private final String username = CommonVarriables.columnsToAdd[0][7];

    public void login(final String user, final String passw, final boolean Robot) {
        memberObject.connection("select * from " + usersTable + " where " + login + " = 'active'");
        if (!user.equals(memberObject.getUsername())) {   // checks that the same usr is logged in once
            memberObject.connection("SELECT * FROM " + usersTable + ", " + CommonVarriables.tablesToCreate[1] + " WHERE " + username + " = '" + user + "'");
            String usrnm = memberObject.getUsername();
            //System.out.println("required data is :" + usrn);
            if (user.equals(usrnm)) {
                memberObject.connection("SELECT * FROM " + usersTable + " WHERE " + CommonVarriables.columnsToAdd[0][8] + " ='" + passw + "'");
                String pas = memberObject.getPasswords();
                if (passw.equals(pas)) {
                    if (Robot) {
                        CommonVarriables.getExecutedUpdate("UPDATE " + usersTable + " SET " + login + " = 'active' WHERE " + username + " =  '" + user + "'");
                        loginFrameObject.dispose();
                        JOptionPane.showMessageDialog(null, "Login sucessfull !!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        JLibrary jLibrary = new JLibrary();
                    } else {
                        JOptionPane.showMessageDialog(null, "Confirm That You Are Not A robot", "OOPS! ONE MORE STEP", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Login failed  !! \n Check your Username or Password", "Warning", JOptionPane.WARNING_MESSAGE);
                    loginFrameObject.jPasswordField1.setText(null);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Login failed  !! \n Check your Username or Password", "Warning", JOptionPane.WARNING_MESSAGE);
                loginFrameObject.jTextField1.setText(null);
            }
        } else {
            JOptionPane.showMessageDialog(null, "You are already logged in!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }
}
