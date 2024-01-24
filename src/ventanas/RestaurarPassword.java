/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ventanas;

import com.datasystem.controller.UsuarioController;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author bm_vd
 */
public class RestaurarPassword extends javax.swing.JFrame {
    String user= "", user_update ="";
    private UsuarioController usuarioController;
    /**
     * Creates new form RestaurarPassword
     */
    public RestaurarPassword() {
        initComponents();
        usuarioController =  new UsuarioController();
        user = Login.user;
        user_update = GestionarUsuarios.user_update;
        System.out.println(user_update);
        setSize(360,260);
        setResizable(false);
        setTitle("Cambio de password para : "+ user_update);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_Password = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        txt_PasswordConfirmacion = new javax.swing.JPasswordField();
        jButton_restaurarPassword = new javax.swing.JButton();
        jLabelWallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cambio de Password");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Nuevo Password:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        txt_Password.setBackground(new java.awt.Color(153, 153, 255));
        txt_Password.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Password.setForeground(new java.awt.Color(255, 255, 255));
        txt_Password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Password.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 210, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Confirmar Password:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        txt_PasswordConfirmacion.setBackground(new java.awt.Color(153, 153, 255));
        txt_PasswordConfirmacion.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_PasswordConfirmacion.setForeground(new java.awt.Color(255, 255, 255));
        txt_PasswordConfirmacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_PasswordConfirmacion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_PasswordConfirmacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 210, -1));

        jButton_restaurarPassword.setBackground(new java.awt.Color(153, 153, 225));
        jButton_restaurarPassword.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton_restaurarPassword.setForeground(new java.awt.Color(255, 255, 255));
        jButton_restaurarPassword.setText("Restaurar Password");
        jButton_restaurarPassword.setBorder(null);
        jButton_restaurarPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_restaurarPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_restaurarPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 210, 35));

        jLabelWallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/wallpaperPrincipal.jpg"))); // NOI18N
        getContentPane().add(jLabelWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 260));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_restaurarPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_restaurarPasswordActionPerformed
        String password, confirmacion_password;
        password = txt_Password.getText().trim();
        confirmacion_password = txt_PasswordConfirmacion.getText().trim();
        
        if(!password.equals("") && !confirmacion_password.equals("")){
            if(password.equals(confirmacion_password)){
                var  nmodificado= usuarioController.cambiarPassword(password,user_update);
                if(nmodificado>0){
                    txt_Password.setBackground(Color.GREEN);
                    txt_PasswordConfirmacion.setBackground(Color.GREEN);
                    JOptionPane.showMessageDialog(null, "Restauracion exitosa");
                }
            }else{
            txt_PasswordConfirmacion.setBackground(Color.red);
            JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
   
            }
        }else{
            txt_Password.setBackground(Color.red);
            txt_PasswordConfirmacion.setBackground(Color.red);
            JOptionPane.showMessageDialog(null, "No se aceptan contraseñas vacias");
        }
    }//GEN-LAST:event_jButton_restaurarPasswordActionPerformed

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
            java.util.logging.Logger.getLogger(RestaurarPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RestaurarPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RestaurarPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RestaurarPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RestaurarPassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_restaurarPassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelWallpaper;
    private javax.swing.JPasswordField txt_Password;
    private javax.swing.JPasswordField txt_PasswordConfirmacion;
    // End of variables declaration//GEN-END:variables
}