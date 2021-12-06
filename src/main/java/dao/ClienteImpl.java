package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.List;
import modelo.Cliente;
import modelo.Ubigeo;
import sun.net.www.content.text.Generic;

public class ClienteImpl extends Conexion implements ICRUD<Cliente> {

    // dni_cli nom_cli cel_cli ape_cli dir_cli _per
    @Override
    public List listarTodos() throws Exception {
        String sql = "select c.CODCLI,c.DNICLI,c.NOMCLI,c.CELCLI,c.APECLI,c.DIRCLI,u.CODUBI,u.DEPUBI,u.DISUBI,u.PROUBI"
                + " from Cliente c INNER JOIN Ubigeo u ON c.CODUBI=u.CODUBI";
        Cliente cli;
        List<Cliente> listado = new ArrayList();
        try (Statement st = this.conectar().createStatement();
                ResultSet rs = st.executeQuery(sql);) {
            while (rs.next()) {
                cli = new Cliente();
                cli.setCod(rs.getInt("CODCLI"));
                cli.setDni(rs.getString("DNICLI"));
                cli.setNombre(rs.getString("NOMCLI"));
                cli.setCelular(rs.getString("CELCLI"));
                cli.setApellidos(rs.getString("APECLI"));
                cli.setDireccion(rs.getString("DIRCLI"));
                Ubigeo ubi = new Ubigeo();
                ubi.setIdubi(rs.getString("CODUBI"));
                ubi.setDepubi(rs.getString("DEPUBI"));
                ubi.setDisubi(rs.getString("DISUBI"));
                ubi.setProubi(rs.getString("PROUBI"));
                cli.setUbigeo(ubi);
                listado.add(cli);
            }
            rs.close();
            st.close();

        } catch (Exception e) {
            System.out.println("Error en listarTodosD: " + e.getMessage());
        }
        return listado;
    }

    @Override
    public void registrar(Cliente cli) throws Exception {
        // dni_per | nom_per | cel_cli | ape_cli | dir_cli | cod_ubi | (6 campos)
        String sql = "insert into cliente (CODCLI ,NOMCLI,CELCLI,APECLI,DNICLI,DIRCLI,CODUBI,ESTCLI) values (?,?,?,?,?,?,?,'A')";
        try (PreparedStatement ps = this.conectar().prepareStatement(sql);) {
            ps.setInt(1, cli.getCod());
            ps.setString(2, cli.getNombre());
            ps.setString(3, cli.getCelular());
            ps.setString(4, cli.getApellidos());
            ps.setString(5, cli.getDni());
            ps.setString(6, cli.getDireccion());
            ps.setString(7, cli.getUbigeo().getIdubi());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al Ingresar Cliente: " + e.getMessage());
        }
    }

}
