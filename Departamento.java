import java.sql.*;
import javax.swing.*;



public class Departamento {
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
            sql = "SELECT * FROM departamento ORDER BY descripcion";
            ResultSet rs = db.executeQuery(sql);
            
            while (rs.next()) {
                combo.addItem(rs.getString("descripcion"));
            }
            db.cerrar();
        } catch (Exception e) {
            System.out.println("Error al cargar departamentos: " + e.toString());
        }
    }

    public String buscarCodigo(String descripcion) {
        DB db = new DB();
        String codigo = "";
        
        try {
            sql = "SELECT codigo FROM departamento WHERE descripcion = '" + descripcion + "'";
            ResultSet rs = db.executeQuery(sql);
            
            if (rs.next()) {
                codigo = rs.getString("codigo");
            }
            db.cerrar();
        } catch (Exception e) {
            System.out.println("Error al buscar código de departamento: " + e.toString());
        }
        
        return codigo;
    }
}