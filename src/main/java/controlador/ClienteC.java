package controlador;

import dao.ClienteImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.Cliente;


@Named(value = "ClienteC")
@SessionScoped
public class ClienteC implements Serializable {

    // private static final long serialVersionUID = 1L;


    private Cliente cli;
    private ClienteImpl dao;
    private List<Cliente> listadoClientes;
    public ClienteC(){
        dao=new ClienteImpl();
        listadoClientes=new ArrayList<>();
        cli =new Cliente();
        
    }
    

    
 public void registrar() throws Exception {
        try {
            dao.registrar(cli);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "OK", "Registrado con éxito"));
            limpiar();
            listar();
        } catch (Exception e) {
            System.out.println("Error en registrarC " + e.getMessage());
        }
    }


    public void limpiar() {
        cli = new Cliente();
    }

//    @SuppressWarnings("unchecked")
    public void listar() {
        try {
            listadoClientes = dao.listarTodos();
            for (Cliente listadoCliente : listadoClientes) {
                System.out.println(listadoCliente);
                
            }
        } catch (Exception e) {
            System.out.println("Error en listarC " + e.getMessage());
        }
    }
    @PostConstruct
    public void construir() {
        listar();
    }
    public static void main(String[] args) {
        ClienteC C=new ClienteC();
        C.listar();
    }
    // métodos generados
    public Cliente getCliente() {
        return cli;
    }

    public void setCli(Cliente c) {
        this.cli = c;
    }

    public ClienteImpl getDao() {
        return dao;
    }

    public void setDao(ClienteImpl dao) {
        this.dao = dao;
    }

    public List<Cliente> getListadoCli() {
        return listadoClientes;
    }

    public void setListadoCli(List<Cliente> listaClientes) {
        this.listadoClientes = listaClientes;
    }

}
