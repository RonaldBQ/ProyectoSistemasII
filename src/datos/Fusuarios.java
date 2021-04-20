package datos;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import negocio.Lusuarios;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Ing. Carlos Alberto Guisbert Salazar UTB 2020
 */
public class Fusuarios {

    //Atributos de la clase
    private Conexion objBaseDatos = new Conexion();
    private Connection cn = objBaseDatos.conectar();
    private String sSQL = "";
    public Integer totalregistros;

    //Metodos de la clase
    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;
        String[] titulos = {"ID", "Usuario", "Telefono", "Login", "Contraseña", "Perfil"};
        String[] registro = new String[6];
        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        sSQL = "SELECT * FROM tbusuarios WHERE usuario LIKE '" + buscar + "%' ORDER BY idusuario DESC";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                registro[0] = rs.getString("idusuario");
                registro[1] = rs.getString("usuario");
                registro[2] = rs.getString("fono");
                registro[3] = rs.getString("login");
                registro[4] = rs.getString("contrasenia");
                registro[5] = rs.getString("perfil");
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
        String[] titulos = {"ID", "Usuario", "Telefono", "Login", "Contraseña", "Perfil"};
        String[] registro = new String[6];
        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        sSQL = "SELECT * FROM tbusuarios WHERE " + campo + " LIKE '" + buscar + "%' ORDER BY idusuario DESC";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                registro[0] = rs.getString("idusuario");
                registro[1] = rs.getString("usuario");
                registro[2] = rs.getString("fono");
                registro[3] = rs.getString("login");
                registro[4] = rs.getString("contrasenia");
                registro[5] = rs.getString("perfil");
                totalregistros = totalregistros + 1;
                modelo.addRow(registro);
            }
            return modelo;
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public boolean insertar(Lusuarios dts) {
        sSQL = "INSERT INTO tbusuarios (usuario,fono, login,contrasenia,perfil) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getUsuario());
            pst.setString(2, dts.getFono());
            pst.setString(3, dts.getLogin());
            pst.setString(4, dts.getContrasenia());
            pst.setString(5, dts.getPerfil());

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
    
    public boolean editar(Lusuarios dts) {
        sSQL = "UPDATE tbusuarios SET usuario=?,fono=?,login=?,contrasenia=?,perfil=? WHERE idusuario=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getUsuario());
            pst.setString(2, dts.getFono());
            pst.setString(3, dts.getLogin());
            pst.setString(4, dts.getContrasenia());
            pst.setString(5, dts.getPerfil());
            pst.setInt(6, dts.getIdusuario());

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
    
    public boolean eliminar(Lusuarios dts) {
        sSQL = "DELETE FROM tbusuarios WHERE idusuario=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdusuario());

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
    
    public String[] logueando(String login, String password){
        String passwordencriptado= DigestUtils.md5Hex(password);
        String[] registro=new String[5];
        totalregistros=0;
        sSQL="SELECT idusuario,usuario,login,contrasenia,perfil FROM tbusuarios WHERE login='"+login+"' AND contrasenia='"+passwordencriptado+"'";
        try {
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sSQL);
            while(rs.next()){
                registro[0]=rs.getString("idusuario");
                registro[1]=rs.getString("usuario");
                registro[2]=rs.getString("login");
                registro[3]=rs.getString("contrasenia");
                registro[4]=rs.getString("perfil");
                totalregistros=totalregistros+1;
            }
            return registro;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

}
