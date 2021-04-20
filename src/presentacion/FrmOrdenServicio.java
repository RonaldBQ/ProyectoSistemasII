package presentacion;

import datos.FordenServicio;
import datos.Fusuarios;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import negocio.LordenServicio;

public class FrmOrdenServicio extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmUsuarios
     */
    public FrmOrdenServicio() {
        initComponents();
        ConstTablaOS();
        inhabilitar();
        muestra("");
        txtBuscar.requestFocus();
    }

    private String accion = "guardar";
    private String accionCambio = "nocambio";

    public void inhabilitar() {
        txtIdOS.setVisible(false);
        txtCliente.setEnabled(false);
        txtDefecto1.setEnabled(false);
        txtEquipo.setEnabled(false);
        txtFecha.setEnabled(false);
        txtServicio.setEnabled(false);
        txtSituacion.setEnabled(false);
        txtTecnico.setEnabled(false);
        txtTipo.setEnabled(false);
        txtValor2.setEnabled(false);

        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnEliminar.setEnabled(false);

        txtIdOS.setText(null);
        txtCliente.setText(null);
        txtDefecto1.setText(null);
        txtEquipo.setText(null);
        txtFecha.setText(null);
        txtServicio.setText(null);
        txtSituacion.setText(null);
        txtTecnico.setText(null);
        txtTipo.setText(null);
        txtValor2.setText(null);
        txtBuscar.setText(null);
    }

    public void habilitar() {

        txtIdOS.setVisible(false);
        txtCliente.setEnabled(true);
        txtDefecto1.setEnabled(true);
        txtEquipo.setEnabled(true);
        txtServicio.setEnabled(true);
        txtSituacion.setEnabled(true);
        txtTecnico.setEnabled(true);
        txtTipo.setEnabled(true);
        txtValor2.setEnabled(true);

        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnEliminar.setEnabled(true);

        txtIdOS.setText(null);
        txtCliente.setText(null);
        txtDefecto1.setText(null);
        txtEquipo.setText(null);
        txtFecha.setText(null);
        txtServicio.setText(null);
        txtSituacion.setText(null);
        txtTecnico.setText(null);
        txtTipo.setText(null);
        txtValor2.setText(null);
        txtBuscar.setText(null);

    }
    
    public void muestra(String buscar) {
        try {
            DefaultTableModel modelo;
            Fusuarios func = new Fusuarios();
            modelo = func.mostrar(buscar);
            jTableUsuarios.setModel(modelo);
            ocultarColumnas();
            lblTotalRegistros.setText("N° de registros " + func.totalregistros);
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }
    }
    
    public void ocultarColumnas() {
        jTableUsuarios.getColumnModel().getColumn(4).setMaxWidth(0);
        jTableUsuarios.getColumnModel().getColumn(4).setMinWidth(0);
        jTableUsuarios.getColumnModel().getColumn(4).setPreferredWidth(0);
    }
    
    public DefaultTableModel ConstTablaOS() {
        try {
            DefaultTableModel modelo = null;
            FordenServicio func = new FordenServicio();
            modelo = func.listarOS();
            tblOS.setModel(modelo);
            lblTotalRegistros.setText("N° de registros " + func.totalregistros);
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
            return null;
        }
    }

    public void busqueda(String buscar, String campo) {
        try {
            DefaultTableModel modelo;
            FordenServicio func = new FordenServicio();
            modelo = func.buscarOS(buscar, campo);
            tblOS.setModel(modelo);
            lblTotalRegistros.setText("N° de registros " + func.totalregistros);
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }
    }

    public void seleccionarcampos() {
        int fila = tblOS.getSelectedRow();
        txtIdOS.setText(tblOS.getValueAt(fila, 0).toString());
        txtFecha.setText(tblOS.getValueAt(fila, 1).toString());
        txtTipo.setText(tblOS.getValueAt(fila, 2).toString());
        txtSituacion.setText(tblOS.getValueAt(fila, 3).toString());
        txtEquipo.setText(tblOS.getValueAt(fila, 4).toString());
        txtDefecto1.setText(tblOS.getValueAt(fila, 5).toString());
        txtServicio.setText(tblOS.getValueAt(fila, 6).toString());
        txtTecnico.setText(tblOS.getValueAt(fila, 7).toString());
        txtValor2.setText(tblOS.getValueAt(fila, 8).toString());
        txtCliente.setText(tblOS.getValueAt(fila, 9).toString());
        txtSituacion.requestFocus();
    }

    public void guardar_registrar_OS() {

        if (txtEquipo.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar un Equipo para la orden de servicio");
            txtEquipo.requestFocus();
            return;
        }

        LordenServicio dts = new LordenServicio();
        FordenServicio func = new FordenServicio();

        dts.setFecha_os(txtFecha.getText());
        dts.setEquipo(txtEquipo.getText());
        dts.setTipo(txtTipo.getText());
        dts.setDefecto(txtDefecto1.getText());
        dts.setServicio(txtServicio.getText());
        dts.setSituacion(txtSituacion.getText());
        dts.setTecnico(txtTecnico.getText());
        dts.setValor(Double.parseDouble(txtValor2.getText()));
        dts.setIdcliente(txtCliente.getText());

        if (accion.equals("guardar")) {
            if (func.insertar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "El Orden de servicio fue registrado satisfactoriamente");
                ConstTablaOS();
                inhabilitar();
            }
        } else if (accion.equals("editar")) {
          
            if (FrmPrincipal.varacceso.equals("ADMIN")) {
                dts.setIdos(Integer.parseInt(txtIdOS.getText()));
                if (func.editar(dts)) {
                    JOptionPane.showMessageDialog(rootPane, "El Orden de servicio fue editado satisfactoriamente");
                    ConstTablaOS();
                }
            } else {
                inhabilitar();
            }

        }
        btnNuevoOS.setEnabled(true);
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
        txtIdOS = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtEquipo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnNuevoOS = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtTecnico = new javax.swing.JTextField();
        txtServicio = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtSituacion = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtDefecto1 = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        txtValor2 = new javax.swing.JTextField();
        txtTipo = new javax.swing.JTextField();
        cboClientes = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        cboTipoBusqueda = new javax.swing.JComboBox<>();
        txtBuscar = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOS = new javax.swing.JTable();
        lblTotalRegistros = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableUsuarios = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Orden de Servicio", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255)));
        jPanel1.setLayout(null);

        txtIdOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdOSActionPerformed(evt);
            }
        });
        jPanel1.add(txtIdOS);
        txtIdOS.setBounds(160, 10, 64, 20);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Defecto:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(30, 120, 42, 14);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Situación");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 290, 43, 14);

        txtEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEquipoActionPerformed(evt);
            }
        });
        jPanel1.add(txtEquipo);
        txtEquipo.setBounds(90, 80, 140, 20);

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Equipo:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(32, 80, 40, 14);

        txtFecha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaActionPerformed(evt);
            }
        });
        jPanel1.add(txtFecha);
        txtFecha.setBounds(90, 40, 140, 21);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Fecha:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 40, 50, 20);

        btnNuevoOS.setText("Nuevo");
        btnNuevoOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoOSActionPerformed(evt);
            }
        });
        jPanel1.add(btnNuevoOS);
        btnNuevoOS.setBounds(150, 530, 63, 23);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar);
        btnGuardar.setBounds(50, 530, 71, 23);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar);
        btnCancelar.setBounds(240, 530, 75, 23);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Tecnico:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(30, 250, 40, 14);

        txtTecnico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTecnicoActionPerformed(evt);
            }
        });
        jPanel1.add(txtTecnico);
        txtTecnico.setBounds(90, 250, 195, 20);

        txtServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtServicioActionPerformed(evt);
            }
        });
        jPanel1.add(txtServicio);
        txtServicio.setBounds(90, 210, 195, 20);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Servicio:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(30, 210, 41, 14);

        txtSituacion.setColumns(20);
        txtSituacion.setRows(5);
        jScrollPane2.setViewportView(txtSituacion);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(90, 290, 200, 70);

        txtDefecto1.setColumns(20);
        txtDefecto1.setRows(5);
        jScrollPane3.setViewportView(txtDefecto1);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(90, 120, 240, 70);

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Tipo:");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(40, 460, 30, 14);

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Valor:");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(40, 420, 30, 14);

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Cliente:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(40, 380, 44, 14);

        txtCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClienteActionPerformed(evt);
            }
        });
        jPanel1.add(txtCliente);
        txtCliente.setBounds(90, 380, 120, 20);

        txtValor2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValor2ActionPerformed(evt);
            }
        });
        jPanel1.add(txtValor2);
        txtValor2.setBounds(90, 420, 120, 20);

        txtTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipoActionPerformed(evt);
            }
        });
        jPanel1.add(txtTipo);
        txtTipo.setBounds(90, 460, 120, 20);
        jPanel1.add(cboClientes);
        cboClientes.setBounds(220, 380, 110, 20);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado Usuarios.:."));

        jLabel6.setText("Buscar:");

        cboTipoBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "equipo", "tecnico", "nombrecli" }));
        cboTipoBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTipoBusquedaActionPerformed(evt);
            }
        });

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        tblOS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblOS.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblOS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblOSMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblOS);

        lblTotalRegistros.setText("N° de registros");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboTipoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(207, 207, 207))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSalir)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addComponent(lblTotalRegistros)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cboTipoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar)
                    .addComponent(btnSalir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotalRegistros)
                .addGap(0, 0, 0))
        );

        jPanel3.setBackground(new java.awt.Color(0, 102, 255));
        jPanel3.setLayout(null);

        jTableUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(jTableUsuarios);

        jPanel3.add(jScrollPane4);
        jScrollPane4.setBounds(20, 60, 690, 230);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 735, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoOSActionPerformed
        habilitar();
        btnEliminar.setEnabled(false);
        btnGuardar.setText("Guardar");
        btnNuevoOS.setEnabled(false);
        accion = "guardar";
        txtSituacion.requestFocus();

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date fecha = new Date();
        txtFecha.setText(dateFormat.format(fecha));
    }//GEN-LAST:event_btnNuevoOSActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        guardar_registrar_OS();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        ConstTablaOS();
        inhabilitar();
        btnNuevoOS.setEnabled(true);
        txtBuscar.requestFocus();
        accionCambio = "nocambio";
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        //Cierra la ventana correspondiente
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void tblOSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOSMouseClicked
        //String perfil = FrmPrincipal.lblPerfil.toString();

        if (FrmPrincipal.varacceso.equals("ADMIN")) {
            btnGuardar.setText("Editar");
            habilitar();
            btnNuevoOS.setEnabled(false);
            btnEliminar.setEnabled(true);
            accion = "editar";
            seleccionarcampos();
        } else {
            seleccionarcampos();
            txtIdOS.setVisible(false);
            txtCliente.setEnabled(false);
            txtDefecto1.setEnabled(false);
            txtEquipo.setEnabled(false);
            txtFecha.setEnabled(false);
            txtServicio.setEnabled(false);
            txtSituacion.setEnabled(false);
            txtTecnico.setEnabled(false);
            txtTipo.setEnabled(false);
            txtValor2.setEnabled(false);
        }

    }//GEN-LAST:event_tblOSMouseClicked

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        String cadena = txtBuscar.getText();
        int seleccionado = cboTipoBusqueda.getSelectedIndex();
        String campo = cboTipoBusqueda.getItemAt(seleccionado);
        busqueda(cadena, campo);
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        
        if (FrmPrincipal.varacceso.equals("ADMIN")) {
            if (!txtIdOS.getText().equals("")) {
                int confirmacion = JOptionPane.showConfirmDialog(rootPane, "Estas seguro de eliminar el Orden de Servicio seleccionado?", "Confirmar", 2);
                if (confirmacion == 0) {
                    FordenServicio func = new FordenServicio();
                    LordenServicio dts = new LordenServicio();
                    dts.setIdos(Integer.parseInt(txtIdOS.getText()));
                    func.eliminar(dts);
                    ConstTablaOS();
                    inhabilitar();
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "NO PUEDE ELIMINAR POR SER USUARIO");
        }
        btnNuevoOS.setEnabled(true);
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEquipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEquipoActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void cboTipoBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTipoBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboTipoBusquedaActionPerformed

    private void txtTecnicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTecnicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTecnicoActionPerformed

    private void txtTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoActionPerformed

    private void txtServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtServicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtServicioActionPerformed

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaActionPerformed

    private void txtClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClienteActionPerformed

    private void txtValor2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValor2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValor2ActionPerformed

    private void txtIdOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdOSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdOSActionPerformed

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
            java.util.logging.Logger.getLogger(FrmOrdenServicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmOrdenServicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmOrdenServicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmOrdenServicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmOrdenServicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevoOS;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cboClientes;
    private javax.swing.JComboBox<String> cboTipoBusqueda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTableUsuarios;
    private javax.swing.JLabel lblTotalRegistros;
    private javax.swing.JTable tblOS;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextArea txtDefecto1;
    private javax.swing.JTextField txtEquipo;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtIdOS;
    private javax.swing.JTextField txtServicio;
    private javax.swing.JTextArea txtSituacion;
    private javax.swing.JTextField txtTecnico;
    private javax.swing.JTextField txtTipo;
    private javax.swing.JTextField txtValor2;
    // End of variables declaration//GEN-END:variables
}
