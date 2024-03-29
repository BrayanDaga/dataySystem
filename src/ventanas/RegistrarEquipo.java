/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ventanas;

/**
 *
 * @author bm_vd
 */
public class RegistrarEquipo extends javax.swing.JFrame {

    /**
     * Creates new form RegistrarEquipo
     */
    public RegistrarEquipo() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_titulo = new javax.swing.JLabel();
        jLabel_Nombre = new javax.swing.JLabel();
        jLabel_Email = new javax.swing.JLabel();
        jTextField_Email = new javax.swing.JTextField();
        jLabel_Telefono = new javax.swing.JLabel();
        jLabel_Direccion = new javax.swing.JLabel();
        jTextField_Direccion = new javax.swing.JTextField();
        jLabel_UltimaModicacion = new javax.swing.JLabel();
        jTextField_NombreCliente = new javax.swing.JTextField();
        jLabel_Wallpaper = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_titulo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel_titulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_titulo.setText("Registro del Equipo");
        getContentPane().add(jLabel_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, 20));

        jLabel_Nombre.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel_Nombre.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre.setText("Nombre del cliente");
        getContentPane().add(jLabel_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel_Email.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel_Email.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Email.setText("Tipo de Equipo");
        getContentPane().add(jLabel_Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jTextField_Email.setBackground(new java.awt.Color(153, 153, 225));
        jTextField_Email.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTextField_Email.setForeground(new java.awt.Color(255, 255, 255));
        jTextField_Email.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_Email.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jTextField_Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 210, -1));

        jLabel_Telefono.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel_Telefono.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Telefono.setText("Marca");
        getContentPane().add(jLabel_Telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel_Direccion.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel_Direccion.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Direccion.setText("Modelo");
        getContentPane().add(jLabel_Direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jTextField_Direccion.setBackground(new java.awt.Color(153, 153, 225));
        jTextField_Direccion.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTextField_Direccion.setForeground(new java.awt.Color(255, 255, 255));
        jTextField_Direccion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_Direccion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jTextField_Direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 210, -1));

        jLabel_UltimaModicacion.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel_UltimaModicacion.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_UltimaModicacion.setText("Numero de serie");
        getContentPane().add(jLabel_UltimaModicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        jTextField_NombreCliente.setBackground(new java.awt.Color(153, 153, 225));
        jTextField_NombreCliente.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTextField_NombreCliente.setForeground(new java.awt.Color(255, 255, 255));
        jTextField_NombreCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_NombreCliente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTextField_NombreCliente.setEnabled(false);
        getContentPane().add(jTextField_NombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 210, -1));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 445));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        jLabel1.setText("Daño reportado y observaciones");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, -1, -1));

        jScrollPane1.setViewportView(jTextPane1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, 260, 130));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(RegistrarEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarEquipo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_Direccion;
    private javax.swing.JLabel jLabel_Email;
    private javax.swing.JLabel jLabel_Nombre;
    private javax.swing.JLabel jLabel_Telefono;
    private javax.swing.JLabel jLabel_UltimaModicacion;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JLabel jLabel_titulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField_Direccion;
    private javax.swing.JTextField jTextField_Email;
    private javax.swing.JTextField jTextField_NombreCliente;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
