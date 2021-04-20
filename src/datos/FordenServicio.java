package datos;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import negocio.LordenServicio;

public class FordenServicio {

    //Atributos de la clase
    private Conexion objBaseDatos = new Conexion();
    private Connection cn = objBaseDatos.conectar();
    private String sSQL = "";
    public Integer totalregistros;

    //Metodo Listar Ordenes de Servicios
    public DefaultTableModel listarOS() {
        DefaultTableModel modelo;
        String[] titulos = {"ID", "Fecha", "Tipo", "Situacion", "Equipo", "Defecto", "Servicio", "Tecnico", "Valor", "Cliente"};
        String[] registro = new String[10];
        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        sSQL = "SELECT * FROM vistaOS";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                registro[0] = rs.getString("idos");
                registro[1] = rs.getString("fecha_os");
                registro[2] = rs.getString("tipo");
                registro[3] = rs.getString("situacion");
                registro[4] = rs.getString("equipo");
                registro[5] = rs.getString("defecto");
                registro[6] = rs.getString("servicio");
                registro[7] = rs.getString("tecnico");
                registro[8] = rs.getString("valor");
                registro[9] = rs.getString("nombrecli");
                totalregistros = totalregistros + 1;
                modelo.addRow(registro);
            }
            return modelo;
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public DefaultTableModel buscarOS(String buscar, String campo) {
        DefaultTableModel modelo;
        String[] titulos = {"ID", "Fecha", "Tipo", "Situacion", "Equipo", "Defecto", "Servicio", "Tecnico", "Valor", "Cliente"};
        String[] registro = new String[10];
        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        sSQL = "SELECT * FROM vistaOS WHERE " + campo + " LIKE '" + buscar + "%' ORDER BY idos DESC";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                registro[0] = rs.getString("idos");
                registro[1] = rs.getString("fecha_os");
                registro[2] = rs.getString("tipo");
                registro[3] = rs.getString("situacion");
                registro[4] = rs.getString("equipo");
                registro[5] = rs.getString("defecto");
                registro[6] = rs.getString("servicio");
                registro[7] = rs.getString("tecnico");
                registro[8] = rs.getString("valor");
                registro[9] = rs.getString("nombrecli");
                totalregistros = totalregistros + 1;
                modelo.addRow(registro);
            }
            return modelo;
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public boolean insertar(LordenServicio dts) {
        sSQL = "INSERT INTO tbos (fecha_os,tipo,situacion, equipo,defecto,servicio,tecnico,valor,idcliente) "
                + "VALUES(?,?,?,?,?,?,?,?,(select idcliente from tbclientes where nombrecli = ? ))";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getFecha_os());
            pst.setString(2, dts.getTipo());
            pst.setString(3, dts.getSituacion());
            pst.setString(4, dts.getEquipo());
            pst.setString(5, dts.getDefecto());
            pst.setString(6, dts.getServicio());
            pst.setString(7, dts.getTecnico());
            pst.setDouble(8, dts.getValor());
            pst.setString(9, dts.getIdcliente());
            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean editar(LordenServicio dts) {
        sSQL = "UPDATE tbos SET fecha_os=?,tipo=?,situacion=?,equipo=?,defecto=?,servicio=?,tecnico=?,valor=?,"
                + "idcliente=(select idcliente from tbclientes where nombrecli = ?) WHERE idos=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getFecha_os());
            pst.setString(2, dts.getTipo());
            pst.setString(3, dts.getSituacion());
            pst.setString(4, dts.getEquipo());
            pst.setString(5, dts.getDefecto());
            pst.setString(6, dts.getServicio());
            pst.setString(7, dts.getTecnico());
            pst.setDouble(8, dts.getValor());
            pst.setString(9, dts.getIdcliente());
            pst.setInt(10, dts.getIdos());

            int n = pst.executeUpdate();

            System.out.println(n);
            if (n != 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean eliminar(LordenServicio dts) {
        sSQL = "DELETE FROM tbos WHERE idos=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdos());
            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

}
