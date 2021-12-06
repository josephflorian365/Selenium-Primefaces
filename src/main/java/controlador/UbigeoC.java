package controlador;

import dao.UbigeoImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.Ubigeo;

@Named(value = "UbigeoC")
@SessionScoped
public class UbigeoC implements Serializable {

    // private static final long serialVersionUID = 1L;


    private Ubigeo ubi;
    private UbigeoImpl dao;
    private List<Ubigeo> listadoUbi;
    
    public UbigeoC(){
        dao=new UbigeoImpl();
        listadoUbi=new ArrayList<>();
        ubi =new Ubigeo();
    }
    
    public void listadoUbi() {
        try {
            listadoUbi = dao.listar();
        
                
            
        } catch (Exception e) {
            System.out.println("Error en listarC " + e.getMessage());
        }
    }
    @PostConstruct
    public void construir() {
        listadoUbi();
    }

    public Ubigeo getUbi() {
        return ubi;
    }

    public void setUbi(Ubigeo ubi) {
        this.ubi = ubi;
    }

    public UbigeoImpl getDao() {
        return dao;
    }

    public void setDao(UbigeoImpl dao) {
        this.dao = dao;
    }

    public List<Ubigeo> getListadoUbigeo() {
        return listadoUbi;
    }

    public void setListadoUbigeo(List<Ubigeo> listadoUbigeo) {
        this.listadoUbi = listadoUbigeo;
    }

   
  
    
}