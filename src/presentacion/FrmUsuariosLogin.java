package presentacion;

import datos.Fusuarios;
import javax.swing.JOptionPane;
import negocio.Lusuarios;
import java.sql.*;
import datos.Conexion;

/**
 * @author Ing. Carlos Alberto Guisbert Salazar UTB 2020
 */
public class FrmUsuariosLogin extends javax.swing.JFrame {

    /**
     * Creates new form FrmUsuariosLogin
     */
    private Conexion objBD = new Conexion();
    private Connection con = null;

    public FrmUsuariosLogin() {
        initComponents();
        con = objBD.conectar();
        if (con != null) {
            lblestado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/archivos/dbok.png")));
        } else {
            lblestado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/archivos/dberror.png")));
        }
        System.out.println(con);
        /*Las siguientres tres lineas funcionan con la propiedad undecorated habilitada*/
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setOpacity(0.9f);
        this.txtusuario.requestFocus();
    }

    //Atributo estatico que controla el numero de intentos fallidos para ingresar al sistema
    private static Integer conteoingreso = 1;

    private void cerrar() {
        String botones[] = {"Cerrar", "Cancelar"};
        int eleccion = JOptionPane.showOptionDialog(this, "¿Estás seguro de Salir de la Aplicacion.?", "Confirmar", 0, 0, null, botones, this);
        if (eleccion == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else if (eleccion == JOptionPane.NO_OPTION) {
            System.out.println("Se cancelo el cierre de la aplicación.");
            txtusuario.requestFocus();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtusuario = new javax.swing.JTextField();
        txtpassword = new javax.swing.JPasswordField();
        btnsalir = new javax.swing.JButton();
        btningresar = new javax.swing.JButton();
        lblconteointentos = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblestado = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Acceso al Sistema .:.");
        setAlwaysOnTop(true);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Usuario");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password");

        txtusuario.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusuarioActionPerformed(evt);
            }
        });

        txtpassword.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpasswordActionPerformed(evt);
            }
        });

        btnsalir.setBackground(new java.awt.Color(51, 51, 51));
        btnsalir.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnsalir.setForeground(new java.awt.Color(0, 0, 51));
        btnsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/archivos/salir.gif"))); // NOI18N
        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        btningresar.setBackground(new java.awt.Color(51, 51, 51));
        btningresar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btningresar.setForeground(new java.awt.Color(0, 0, 51));
        btningresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/archivos/key_add.png"))); // NOI18N
        btningresar.setText("Ingresar");
        btningresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btningresarActionPerformed(evt);
            }
        });

        lblconteointentos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblconteointentos.setForeground(new java.awt.Color(255, 255, 204));
        lblconteointentos.setText("Intento: 1 de 3");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/archivos/login02.png"))); // NOI18N
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblestado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/archivos/dberror.png"))); // NOI18N
        lblestado.setToolTipText("");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("PEP UTB 2020");

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("SISADMIN Ing. Carlos Alberto Guisbert Salazar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(93, 93, 93)
                        .addComponent(lblconteointentos)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btningresar)
                                .addGap(18, 18, 18)
                                .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(31, 31, 31)
                                    .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLabel4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addComponent(lblestado)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btningresar)
                            .addComponent(btnsalir))
                        .addGap(18, 18, 18)
                        .addComponent(lblestado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblconteointentos)
                    .addComponent(jLabel5))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusuarioActionPerformed
        txtusuario.transferFocus();
    }//GEN-LAST:event_txtusuarioActionPerformed

    private void txtpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpasswordActionPerformed
        txtpassword.transferFocus();
    }//GEN-LAST:event_txtpasswordActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        cerrar();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        cerrar();
    }//GEN-LAST:event_formWindowClosing

    /*EVENTO QUE SE ESTA UTILIZANDO YA VALIDADO Y FUNCIONAL*/
    private void btningresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btningresarActionPerformed
        if (conteoingreso <= 3) {
            lblconteointentos.setText("Intento: " + conteoingreso + " de 3");
            try {
                /*Cerramos la conexion abierta en el constructor*/
                con.close();
                System.out.println("Conexion cerrada");

                String loginInto = txtusuario.getText();
                //String passwordInto=txtpassword.getText(); //el metodo getText esta obsoleto y es poco seguro
                String passwordInto = String.valueOf(txtpassword.getPassword()); //String.valueOf(miarray) mucho mas seguro

                Fusuarios func = new Fusuarios();
                Lusuarios dts = new Lusuarios();
                dts.setUsuario(loginInto);
                dts.setContrasenia(passwordInto);

                String registros[] = func.logueando(dts.getUsuario(), dts.getContrasenia());

                if ((registros != null) && (func.totalregistros == 1)) {
                    /*Si el metodo logueando no es nulo y por lo menos hay un registro se cierra este
                    formulario y se abre el Formulario Principal*/
                    this.dispose(); //Se cierra en formulario FrmUsuariosLogin
                    System.out.println("Ingresando al sistema!!!");
                    System.out.println("Id usuario "+registros[0]);
                    System.out.println("Nombre usuario "+registros[1]);
                    System.out.println("Login usuario "+registros[2]);
                    System.out.println("Contraseña usuario "+registros[3]);
                    System.out.println("Perfil usuario "+registros[4]);
                    FrmPrincipal formPrincipal = new FrmPrincipal();
                    formPrincipal.toFront();
                    formPrincipal.setVisible(true);
                    //Se almacena en los label del FrmPrincipal lo que esta almacenado en el arreglo
                    FrmPrincipal.lblUsuario.setText(registros[1]+" ");
                    FrmPrincipal.lblPerfil.setText(registros[4]);
                    /*En la propiedad estatica y publica varacceso se almacena el tipo de Rol*/
                    FrmPrincipal.varacceso=registros[4];
                    
                    /*Esta parte para restringir accesos segun el Rol*/
                    if (!(FrmPrincipal.varacceso.equals("ADMIN"))) {
                        FrmPrincipal.mnuiUsuarios.setEnabled(false);
                        FrmPrincipal.mnuiServicios.setEnabled(false);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Acceso Denegado. Intento: " + conteoingreso + " de 3", "Acceso al Sistema", JOptionPane.ERROR_MESSAGE);
                    if (conteoingreso == 3) {
                        this.dispose();
                    }
                    conteoingreso++;
                    this.txtpassword.requestFocus();
                    this.txtpassword.setText("");
                }
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(rootPane, e);
            }
        } else {
            this.dispose(); 
        }
    }//GEN-LAST:event_btningresarActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmUsuariosLogin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmUsuariosLogin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmUsuariosLogin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmUsuariosLogin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmUsuariosLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btningresar;
    private javax.swing.JButton btnsalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblconteointentos;
    private javax.swing.JLabel lblestado;
    private javax.swing.JPasswordField txtpassword;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
}