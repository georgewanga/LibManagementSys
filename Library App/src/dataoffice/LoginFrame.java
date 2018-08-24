package dataoffice;

public class LoginFrame extends javax.swing.JFrame {

    private String user, passw;
    private boolean Robot = false;

    public LoginFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JToggleButton jToggleButton1 = new javax.swing.JToggleButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LOGIN SYSTEM");
        setBackground(new java.awt.Color(0, 255, 0));
        setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N
        setForeground(new java.awt.Color(255, 0, 0));
        setLocation(new java.awt.Point(200, 80));
        setMinimumSize(new java.awt.Dimension(480, 390));
        setResizable(false);
        getContentPane().setLayout(null);

        jToggleButton1.setBackground(new java.awt.Color(0, 102, 255));
        jToggleButton1.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N
        jToggleButton1.setForeground(new java.awt.Color(102, 255, 255));
        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Information24.gif"))); // NOI18N
        jToggleButton1.setText("Click to continue");
        jToggleButton1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "I'm Not a Robot", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Cambria Math", 1, 12), new java.awt.Color(204, 204, 204))); // NOI18N
        jToggleButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jToggleButton1.setOpaque(true);
        jToggleButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bulb green.jpg"))); // NOI18N
        jToggleButton1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/OK_24.png"))); // NOI18N
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButton1);
        jToggleButton1.setBounds(170, 180, 180, 50);

        jTextField1.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(0, 0, 255));
        jTextField1.setText("admin");
        jTextField1.setToolTipText("");
        getContentPane().add(jTextField1);
        jTextField1.setBounds(210, 80, 240, 30);

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Bodoni MT Black", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("DATAOFFICE LIBRARY SYSTEM");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel4);
        jLabel4.setBounds(50, 10, 410, 24);

        jButton3.setFont(new java.awt.Font("Cambria Math", 0, 12)); // NOI18N
        jButton3.setText("SIGNUP ");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButton3);
        jButton3.setBounds(340, 300, 100, 30);

        jLabel6.setBackground(new java.awt.Color(51, 255, 0));
        jLabel6.setFont(new java.awt.Font("Lucida Calligraphy", 2, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Please Login Below:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(140, 40, 190, 20);

        jLabel1.setFont(new java.awt.Font("Cambria Math", 0, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("USERNAME :");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(110, 80, 100, 30);

        jLabel2.setFont(new java.awt.Font("Cambria Math", 0, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("PASSWORD :");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel2);
        jLabel2.setBounds(120, 120, 100, 30);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Cambria Math", 0, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 224, 0));
        jButton1.setText("CLICK HERE!");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setIconTextGap(6);
        getContentPane().add(jButton1);
        jButton1.setBounds(80, 300, 99, 30);

        jButton2.setBackground(new java.awt.Color(0, 255, 0));
        jButton2.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        jButton2.setText("LOGIN");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setMaximumSize(new java.awt.Dimension(75, 25));
        jButton2.setMinimumSize(new java.awt.Dimension(75, 25));
        jButton2.setOpaque(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(280, 260, 150, 30);

        jLabel3.setFont(new java.awt.Font("Cambria Math", 2, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Forgot Username or Password?");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 270, 190, 29);

        jPasswordField1.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N
        jPasswordField1.setForeground(new java.awt.Color(0, 0, 255));
        jPasswordField1.setText("admin");
        getContentPane().add(jPasswordField1);
        jPasswordField1.setBounds(210, 120, 240, 30);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/flowers2.jpg"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 470, 70);

        jLabel9.setFont(new java.awt.Font("Cambria Math", 2, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("No Account?");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(260, 310, 70, 20);

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/login.jpg"))); // NOI18N
        getContentPane().add(jLabel7);
        jLabel7.setBounds(10, 70, 450, 260);

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 255, 0), new java.awt.Color(0, 255, 0), null, null), "Property of © george.wanga@gmail.com", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Cambria Math", 0, 11), new java.awt.Color(255, 0, 255))); // NOI18N
        jLabel8.setOpaque(true);
        getContentPane().add(jLabel8);
        jLabel8.setBounds(0, 0, 470, 360);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        RunApp runApp = new RunApp();
        user = jTextField1.getText().trim();
        passw = jPasswordField1.getText().trim();
        Login Login = new Login();
        Login.login(user, passw, Robot);
        // JLibrary jLibrary = new JLibrary();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
        javax.swing.JToggleButton jBtn = (javax.swing.JToggleButton) evt.getSource();
        Robot = jBtn.isSelected();
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public javax.swing.JPasswordField jPasswordField1;
    public javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
