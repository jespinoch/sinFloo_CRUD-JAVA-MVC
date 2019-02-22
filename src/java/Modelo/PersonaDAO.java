package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO {

    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion c = new Conexion();

    public List listar() {
        List<Persona> lista = new ArrayList<>();
        String sql = "select * from persona";
        try {
            con = c.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Persona p = new Persona();
                p.setId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setDni(rs.getString(3));
                lista.add(p);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    public Persona listarId(int id) {
        String sql = "select * from persona where Id=" + id;
        Persona pe = new Persona();
        try {
            con = c.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                pe.setId(rs.getInt(1));
                pe.setNom(rs.getString(2));
                pe.setDni(rs.getString(3));
            }
        } catch (Exception e) {
        }
        return pe;
    }

    public void agregar(Persona p) {
        String sql = "insert into persona(Nombres, Dni)values(?,?)";
        try {
            con = c.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNom());
            ps.setString(2, p.getDni());
            ps.executeUpdate();
        } catch (Exception e) {
        }

    }
    public void update(Persona p) {
        String sql = "update persona set Nombres=?,Dni=? where Id=?";
        try {
            con = c.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNom());
            ps.setString(2, p.getDni());
            ps.setInt(3, p.getId());
            ps.executeUpdate();
        } catch (Exception e) {
        }

    }

    public void delete(int id) {
        String sql = "delete from persona where Id=" + id;
        try {
            con = c.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }

    }
}
