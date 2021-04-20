package negocio;

public class LordenServicio {
    private int idos;
    
    private String fecha_os;
    private String tipo;
    private String situacion;
    private String equipo;
    private String defecto;
    private String servicio;
    private String tecnico;
    private double valor;
    private String idcliente;

    public LordenServicio() {
        
    }

    public LordenServicio(int idos, String fecha_os, String tipo, String situacion, String equipo, String defecto, String servicio, String tecnico, double valor, String idcliente) {
        this.idos = idos;
        this.fecha_os = fecha_os;
        this.tipo = tipo;
        this.situacion = situacion;
        this.equipo = equipo;
        this.defecto = defecto;
        this.servicio = servicio;
        this.tecnico = tecnico;
        this.valor = valor;
        this.idcliente = idcliente;
    }

    public int getIdos() {
        return idos;
    }

    public void setIdos(int idos) {
        this.idos = idos;
    }

    public String getFecha_os() {
        return fecha_os;
    }

    public void setFecha_os(String fecha_os) {
        this.fecha_os = fecha_os;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSituacion() {
        return situacion;
    }

    public void setSituacion(String situacion) {
        this.situacion = situacion;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getDefecto() {
        return defecto;
    }

    public void setDefecto(String defecto) {
        this.defecto = defecto;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(String idcliente) {
        this.idcliente = idcliente;
    }
    
    
    
    
}
