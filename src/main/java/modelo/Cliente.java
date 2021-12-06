package modelo;

public class Cliente {
    
    private Integer cod;
    private String dni;
    private String nombre;
    private String celular;
    private String apellidos;
    private String direccion;
    private Ubigeo ubigeo =new Ubigeo();

    public Cliente(Integer cod, String dni, String nombre, String celular, String apellidos, String direccion,Ubigeo ubigeo) {
        this.cod = cod;
        this.dni = dni;
        this.nombre = nombre;
        this.celular = celular;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.ubigeo=ubigeo;
    }

    public Cliente() {
    }


    

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Ubigeo getUbigeo() {
        return ubigeo;
    }

    public void setUbigeo(Ubigeo ubigeo) {
        this.ubigeo = ubigeo;
    }

    

    
    

}