package negocio;

/**
 *
 * @author Ing. Carlos Alberto Guisbert Salazar UTB 2020
 */
public class Lusuarios {
    private int idusuario;
    private String usuario;
    private String fono;
    private String login;
    private String contrasenia;
    private String perfil;

    public Lusuarios() {
    }

    public Lusuarios(int idusuario, String usuario, String fono, String login, String contrasenia, String perfil) {
        this.idusuario = idusuario;
        this.usuario = usuario;
        this.fono = fono;
        this.login = login;
        this.contrasenia = contrasenia;
        this.perfil = perfil;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getFono() {
        return fono;
    }

    public void setFono(String fono) {
        this.fono = fono;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
   
    
}
