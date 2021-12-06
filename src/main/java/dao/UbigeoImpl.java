/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Ubigeo;

/**
 *
 * @author PRO
 */
public class UbigeoImpl extends Conexion{
    public  List<Ubigeo> listar() throws Exception {
        String sql = "SELECT CODUBI,DEPUBI,PROUBI,DISUBI FROM UBIGEO";
        List<Ubigeo> lstubi = null;
        try {
            PreparedStatement ps = conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            lstubi = new ArrayList<>();
            while (rs.next()) {
                Ubigeo ubi = new Ubigeo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
                lstubi.add(ubi);

            }
            rs.close();
            ps.close();
            
        } catch (Exception e) {
            e.printStackTrace();
            
        }finally{
            cerrar();
        }
        
        return lstubi;
    }

}
