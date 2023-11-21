
package com.nibble.supermarket.vista;

import java.awt.Color;

public class Login extends javax.swing.JFrame {
    
    int xMouse, yMouse;
    public Login() {
        initComponents();
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
        jSeparator1 = new javax.swing.JSeparator();
        usuu = new javax.swing.JLabel();
        ingresoUsu1 = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        pass = new javax.swing.JPasswordField();
        labelBoton = new javax.swing.JPanel();
        contentBoton = new javax.swing.JLabel();

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

        imgLogin.setIcon(new javax.swing.ImageIcon("C:\\Users\\dial_\\Documents\\NetBeansProjects\\supermarket\\src\\main\\java\\com\\nibble\\supermarket\\img\\login.jpg")); // NOI18N
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

        contentSalida.setIcon(new javax.swing.ImageIcon("C:\\Users\\dial_\\Documents\\NetBeansProjects\\supermarket\\src\\main\\java\\com\\nibble\\supermarket\\img\\salir-alt.png")); // NOI18N
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
        background.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 380, 300, 40));

        usuu.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        usuu.setText("Usuario");
        background.add(usuu, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, -1, -1));

        ingresoUsu1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        ingresoUsu1.setForeground(new java.awt.Color(255, 204, 153));
        ingresoUsu1.setText("Ingrese su número de DNI");
        ingresoUsu1.setToolTipText("");
        ingresoUsu1.setBorder(null);
        ingresoUsu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ingresoUsu1MousePressed(evt);
            }
        });
        ingresoUsu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresoUsu1ActionPerformed(evt);
            }
        });
        background.add(ingresoUsu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 280, 30));
        background.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, 300, 40));

        pass.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        pass.setForeground(new java.awt.Color(255, 204, 153));
        pass.setText("********");
        pass.setBorder(null);
        pass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                passMousePressed(evt);
            }
        });
        pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passActionPerformed(evt);
            }
        });
        background.add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, 250, 30));

        labelBoton.setBackground(new java.awt.Color(249, 135, 0));
        labelBoton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        contentBoton.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        contentBoton.setForeground(new java.awt.Color(255, 255, 255));
        contentBoton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        contentBoton.setText("Iniciar sesión");
        contentBoton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        contentBoton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                contentBotonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                contentBotonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                contentBotonMouseExited(evt);
            }
        });

        javax.swing.GroupLayout labelBotonLayout = new javax.swing.GroupLayout(labelBoton);
        labelBoton.setLayout(labelBotonLayout);
        labelBotonLayout.setHorizontalGroup(
            labelBotonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentBoton, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );
        labelBotonLayout.setVerticalGroup(
            labelBotonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentBoton, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        background.add(labelBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 420, 140, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ingresoUsu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresoUsu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ingresoUsu1ActionPerformed

    private void passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passActionPerformed

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

    private void contentBotonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contentBotonMouseEntered
        contentBoton.setBackground(Color.gray);
    }//GEN-LAST:event_contentBotonMouseEntered

    private void contentBotonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contentBotonMouseExited
        contentBoton.setBackground(Color.gray);
    }//GEN-LAST:event_contentBotonMouseExited

    private void ingresoUsu1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ingresoUsu1MousePressed
        ingresoUsu1.setText("");
        ingresoUsu1.setForeground(Color.black);
        pass.setText("*********");
        pass.setForeground(Color.gray);

    }//GEN-LAST:event_ingresoUsu1MousePressed

    private void passMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passMousePressed
        ingresoUsu1.setText("Ingrese su número de DNI");
        ingresoUsu1.setForeground(Color.gray);
        pass.setText("");
        pass.setForeground(Color.black);

    }//GEN-LAST:event_passMousePressed

    private void contentBotonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contentBotonMouseClicked
        //
    }//GEN-LAST:event_contentBotonMouseClicked

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
    private javax.swing.JLabel contentBoton;
    private javax.swing.JLabel contentSalida;
    private javax.swing.JLabel contra;
    private javax.swing.JPanel header;
    private javax.swing.JLabel imgLogin;
    private javax.swing.JTextField ingresoUsu1;
    private javax.swing.JLabel iniSesion;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel labelBoton;
    private javax.swing.JLabel loguito;
    private javax.swing.JLabel nibble;
    private javax.swing.JLabel nombreMarket;
    private javax.swing.JPasswordField pass;
    private javax.swing.JLabel usuu;
    // End of variables declaration//GEN-END:variables
}
