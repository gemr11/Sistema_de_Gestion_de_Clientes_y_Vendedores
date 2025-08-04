import java.sql.*;
import javax.swing.*;

public class Provincia {
    private String codigo;
    private String descripcion;
    private String sql;

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void cargar(JComboBox<String> combo) {
        DB db = new DB();
        combo.removeAllItems();
        combo.addItem("-- Seleccionar --");
        
        try {
            sql = "SELECT * FROM provincia ORDER BY descripcion";
            ResultSet rs = db.executeQuery(sql);
            
            while (rs.next()) {
                combo.addItem(rs.getString("descripcion"));
            }
            db.cerrar();
        } catch (Exception e) {
            System.out.println("Error al cargar provincias: " + e.toString());
        }
    }

    public String buscarCodigo(String descripcion) {
        DB db = new DB();
        String codigo = "";
        
        try {
            sql = "SELECT codigo FROM provincia WHERE descripcion = '" + descripcion + "'";
            ResultSet rs = db.executeQuery(sql);
            
            if (rs.next()) {
                codigo = rs.getString("codigo");
            }
            db.cerrar();
        } catch (Exception e) {
            System.out.println("Error al buscar código de provincia: " + e.toString());
        }
        
        return codigo;
    }
}