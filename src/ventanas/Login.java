/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ventanas;

import clases.Conexion;
import com.datasystem.controller.UsuarioController;
import com.datasystem.modelos.Usuario;
import java.sql.*;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;

/**
 *
 * @author bm_vd
 */
public class Login extends javax.swing.JFrame {

    public static String user = "";
    public String pass = "";

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        
        setSize(400, 550);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Acceso al Sistema");

        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(
                JLabelWallpaper.getWidth(), JLabelWallpaper.getHeight(), Image.SCALE_DEFAULT));
        JLabelWallpaper.setIcon(icono);
        this.repaint();

        ImageIcon wallpaperLogo = new ImageIcon("src/images/DS.png");
        Icon iconoLogo = new ImageIcon(wallpaperLogo.getImage().getScaledInstance(
                jLabelLogo.getWidth(), jLabelLogo.getHeight(), Image.SCALE_DEFAULT));
        jLabelLogo.setIcon(iconoLogo);
        this.repaint();

    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon.png"));
        return retValue;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_user = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        jLabelLogo = new javax.swing.JLabel();
        jButton_acceder = new javax.swing.JButton();
        jLabel_footer = new javax.swing.JLabel();
        JLabelWallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setSize(new java.awt.Dimension(400, 550));
       
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_user.setBackground(new java.awt.Color(153, 153, 255));
        txt_user.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt_user.setForeground(new java.awt.Color(255, 255, 255));
        txt_user.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_user.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 330, 210, -1));

        txt_password.setBackground(new java.awt.Color(153, 153, 255));
        txt_password.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt_password.setForeground(new java.awt.Color(255, 255, 255));
        txt_password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_password.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
     
        getContentPane().add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 370, 210, -1));

        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/DS.png"))); // NOI18N
        getContentPane().add(jLabelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 270, 270));

        jButton_acceder.setBackground(new java.awt.Color(153, 153, 255));
        jButton_acceder.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton_acceder.setForeground(new java.awt.Color(255, 255, 255));
        jButton_acceder.setText("Acceder");
        jButton_acceder.setBorder(null);

        jButton_acceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_accederActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_acceder, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 420, 210, 35));

        jLabel_footer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_footer.setText("Creadp por tutoriales de Ernesto");
        getContentPane().add(jLabel_footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 480, 210, -1));

        JLabelWallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/wallpaperPrincipal.jpg"))); // NOI18N
        getContentPane().add(JLabelWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_accederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_accederActionPerformed
        // TODO add your handling code here:
        acceder();
    }//GEN-LAST:event_jButton_accederActionPerformed
	

    private void acceder() {
        user = txt_user.getText().trim();
        pass = txt_password.getText().trim();
        if (!user.equals("") || !pass.equals("")) {
            UsuarioController usuarioController = new UsuarioController();
            Usuario usuario = usuarioController.logearse(user, pass);

            if (usuario != null) {
                String tipo_nivel = usuario.getTipo_nivel();
                String estatus = usuario.getEstatus();

                if (tipo_nivel.equals("Administrador") && estatus.equals("Activo")) {
                    dispose();
                    new Administrador().setVisible(true);
                }
                if (tipo_nivel.equals("Capturista") && estatus.equals("Activo")) {
                    dispose();
                    new Capturista().setVisible(true);
                }
                if (tipo_nivel.equals("Tecnico") && estatus.equals("Activo")) {
                    dispose();
                    new Tecnico().setVisible(true);
                }
            } else {
                txt_user.setText("");
                txt_password.setText("");
                JOptionPane.showMessageDialog(null, "Datos ingresados incorrectos");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
        }
    }

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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabelWallpaper;
    private javax.swing.JButton jButton_acceder;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabel_footer;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_user;
    // End of variables declaration//GEN-END:variables
}
