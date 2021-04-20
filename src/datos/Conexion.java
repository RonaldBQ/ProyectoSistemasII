package datos;

import java.sql.*;
import javax.swing.JOptionPane;

public class Conexion {
    private String db="dbempresa"; //Nombre de la base de datos
    private String url="jdbc:mysql://127.0.0.1:3306/"+db;
    //jdbc es el protocolo, mysql identifica al driver de la BD, el resto indica el nombre y en donde se encuentra la BD
    private String usuario="root";//usuario de la BD
    private String pass="";//contraseña de la BD

    public Conexion() {
    }
    
    public Connection conectar(){
        Connection enlace=null;
        try {
            Class.forName("org.gjt.mm.mysql.Driver");//Carga y registra el driver JDBC
            //Class.forName(com.mysql.jdbc.Driver); //Obsoleto
            enlace=DriverManager.getConnection(this.url,this.usuario,this.pass);//obtener la conexion
            System.out.println("Conexion exitosa");
            
        } catch (ClassNotFoundException |  SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
        }
        return enlace;//retorna el enlace de conexion
    }
    
}
