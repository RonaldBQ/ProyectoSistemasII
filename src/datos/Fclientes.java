package datos;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import negocio.Lclientes;

public class Fclientes {

    //Atributos de la clase
    private Conexion objBaseDatos = new Conexion();
    private Connection cn = objBaseDatos.conectar();
    private String sSQL = "";
    
    public Integer totalregistros;

    //Metodos de la clase
    public DefaultTableModel mostrar() {
        totalregistros = 0;
        DefaultTableModel modelo;
        String[] titulos = {"ID", "Nombre Cliente", "Direccion", "Telefono", "Email"};
        String[] registro = new String[5];
        modelo = new DefaultTableModel(null, titulos);
        sSQL = "SELECT * FROM tbclientes ORDER BY idcliente DESC";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                registro[0] = rs.getString("idcliente");
                registro[1] = rs.getString("nombrecli");
                registro[2] = rs.getString("direccion");
                registro[3] = rs.getString("fonocli");
                registro[4] = rs.getString("emailcli");
                totalregistros = totalregistros + 1;
                modelo.addRow(registro);
            }
            return modelo;
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public DefaultTableModel buscar(String buscar, String campo) {
        DefaultTableModel modelo;
        String[] titulos = {"ID", "Nombre Cliente", "Direccion", "Telefono", "Email"};
        String[] registro = new String[5];
        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        sSQL = "SELECT * FROM tbclientes WHERE " + campo + " LIKE '" + buscar + "%' ORDER BY idcliente DESC";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                registro[0] = rs.getString("idcliente");
                registro[1] = rs.getString("nombrecli");
                registro[2] = rs.getString("direccion");
                registro[3] = rs.getString("fonocli");
                registro[4] = rs.getString("emailcli");
                totalregistros = totalregistros + 1;
                modelo.addRow(registro);
            }
            return modelo;
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public boolean insertar(Lclientes dts) {
        sSQL = "INSERT INTO tbclientes (nombrecli,direccion,fonocli,emailcli) VALUES(?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNombrecli());
            pst.setString(2, dts.getDireccion());
            pst.setString(3, dts.getFonocli());
            pst.setString(4, dts.getEmailcli());
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
    
    public boolean editar(Lclientes dts) {
        sSQL = "UPDATE tbclientes SET nombrecli=?,direccion=?,fonocli=?,emailcli=? WHERE idcliente=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNombrecli());
            pst.setString(2, dts.getDireccion());
            pst.setString(3, dts.getFonocli());
            pst.setString(4, dts.getEmailcli());
            pst.setInt(5, dts.getIdcliente());

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
    
    public boolean eliminar(Lclientes dts) {
        sSQL = "DELETE FROM tbclientes WHERE idcliente=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdcliente());

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
