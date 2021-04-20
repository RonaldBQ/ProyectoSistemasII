package negocio;

public class Lclientes {
    private int idcliente;
    private String nombrecli;
    private String direccion;
    private String fonocli;
    private String emailcli;

    public Lclientes() {
    }

    public Lclientes(int idcliente, String nombrecli, String direccion, String fonocli, String emailcli) {
        this.idcliente = idcliente;
        this.nombrecli = nombrecli;
        this.direccion = direccion;
        this.fonocli = fonocli;
        this.emailcli = emailcli;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public String getNombrecli() {
        return nombrecli;
    }

    public void setNombrecli(String nombrecli) {
        this.nombrecli = nombrecli;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFonocli() {
        return fonocli;
    }

    public void setFonocli(String fonocli) {
        this.fonocli = fonocli;
    }

    public String getEmailcli() {
        return emailcli;
    }

    public void setEmailcli(String emailcli) {
        this.emailcli = emailcli;
    }
    
    
}
