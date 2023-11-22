
package com.nibble.supermarket.vista;

import java.awt.Color;

public class Login extends javax.swing.JFrame {
    
    
    int xMouse, yMouse;
    public Login() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        nombreMarket = new javax.swing.JLabel();
        imgLogin = new javax.swing.JLabel();
        botonSalida = new javax.swing.JPanel();
        contentSalida = new javax.swing.JLabel();
        header = new javax.swing.JPanel();
        nibble = new javax.swing.JLabel();
        loguito = new javax.swing.JLabel();
        iniSesion = new javax.swing.JLabel();
        contra = new javax.swing.JLabel();
        usuu = new javax.swing.JLabel();
        btnIniciarSesion = new javax.swing.JButton();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nombreMarket.setFont(new java.awt.Font("Roboto Black", 3, 24)); // NOI18N
        nombreMarket.setForeground(new java.awt.Color(255, 204, 51));
        nombreMarket.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreMarket.setText("SuperMarket Nibble");
        background.add(nombreMarket, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 270, 260, 80));

        imgLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/login.jpg"))); // NOI18N
        background.add(imgLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 0, 310, 510));

        botonSalida.setBackground(new java.awt.Color(255, 246, 246));
        botonSalida.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonSalida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonSalidaMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonSalidaMouseExited(evt);
            }
        });

        contentSalida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/salir-alt.png"))); // NOI18N
        contentSalida.setToolTipText("");
        contentSalida.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        contentSalida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                contentSalidaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                contentSalidaMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout botonSalidaLayout = new javax.swing.GroupLayout(botonSalida);
        botonSalida.setLayout(botonSalidaLayout);
        botonSalidaLayout.setHorizontalGroup(
            botonSalidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botonSalidaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contentSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        botonSalidaLayout.setVerticalGroup(
            botonSalidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botonSalidaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contentSalida)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        background.add(botonSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 30));

        header.setBackground(new java.awt.Color(249, 135, 0));
        header.setForeground(new java.awt.Color(255, 255, 255));
        header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                headerMouseDragged(evt);
            }
        });
        header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headerMousePressed(evt);
            }
        });

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 810, Short.MAX_VALUE)
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        background.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 30));

        nibble.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        nibble.setText("SUPERMARKET NIBBLE");
        background.add(nibble, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 230, 40));

        loguito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.png"))); // NOI18N
        background.add(loguito, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        iniSesion.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        iniSesion.setText("INICIAR SESIÓN");
        background.add(iniSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, -1, -1));

        contra.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        contra.setText("Contraseña");
        background.add(contra, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, -1, -1));

        usuu.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        usuu.setText("Usuario");
        background.add(usuu, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, -1, -1));

        btnIniciarSesion.setBackground(new java.awt.Color(255, 153, 0));
        btnIniciarSesion.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btnIniciarSesion.setForeground(new java.awt.Color(255, 255, 255));
        btnIniciarSesion.setText("Iniciar sesión");
        btnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionActionPerformed(evt);
            }
        });
        background.add(btnIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 410, 140, 50));
        background.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 310, 40));
        background.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 350, 300, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        xMouse=evt.getX();
        yMouse=evt.getY();
    }//GEN-LAST:event_headerMousePressed

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        int x=evt.getXOnScreen();
        int y=evt.getYOnScreen();
        this.setLocation(x-xMouse,y-yMouse);
    }//GEN-LAST:event_headerMouseDragged

    private void botonSalidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonSalidaMouseClicked
        System.exit(0);
    }//GEN-LAST:event_botonSalidaMouseClicked

    private void contentSalidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contentSalidaMouseClicked
        System.exit(0);
    }//GEN-LAST:event_contentSalidaMouseClicked

    private void contentSalidaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contentSalidaMouseEntered
        contentSalida.setBackground(Color.RED);
        botonSalida.setBackground(Color.white);
    }//GEN-LAST:event_contentSalidaMouseEntered

    private void botonSalidaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonSalidaMouseExited
        contentSalida.setBackground(Color.RED);

    }//GEN-LAST:event_botonSalidaMouseExited

    private void btnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnIniciarSesionActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JPanel botonSalida;
    public javax.swing.JButton btnIniciarSesion;
    private javax.swing.JLabel contentSalida;
    private javax.swing.JLabel contra;
    private javax.swing.JPanel header;
    private javax.swing.JLabel imgLogin;
    private javax.swing.JLabel iniSesion;
    private javax.swing.JLabel loguito;
    private javax.swing.JLabel nibble;
    private javax.swing.JLabel nombreMarket;
    public javax.swing.JPasswordField txtPassword;
    public javax.swing.JTextField txtUsername;
    private javax.swing.JLabel usuu;
    // End of variables declaration//GEN-END:variables
}
