import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;

public class Vendedor extends Persona {
    private String codigo;
    private String departamento;
    private String cargo;
    private int ventaMensual;
    private int ventaAnual;
    private String sql;

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setVentaMensual(int ventaMensual) {
        this.ventaMensual = ventaMensual;
    }

    public int getVentaMensual() {
        return ventaMensual;
    }

    public void setVentaAnual(int ventaAnual) {
        this.ventaAnual = ventaAnual;
    }

    public int getVentaAnual() {
        return ventaAnual;
    }

    public void buscar(String codigo) {
        DB db = new DB();
        try {
            sql = "SELECT v.*, d.descripcion as departamento_desc FROM vendedor v " +
                  "LEFT JOIN departamento d ON v.departamento = d.codigo " +
                  "WHERE v.codigo = '" + codigo + "'";
            
            ResultSet rs = db.executeQuery(sql);
            if (rs.next()) {
                this.codigo = rs.getString("codigo");
                this.nombre = rs.getString("nombre");
                this.apellido = rs.getString("apellido");
                this.departamento = rs.getString("departamento_desc");
                this.cargo = rs.getString("cargo");
                this.ventaMensual = rs.getInt("venta_mensual");
                this.ventaAnual = rs.getInt("venta_anual");
            }
            db.cerrar();
        } catch (Exception e) {
            System.out.println("Error al buscar vendedor: " + e.toString());
        }
    }

    public void agregar() {
        DB db = new DB();
        Departamento d = new Departamento();
        
        sql = "INSERT INTO vendedor (codigo, nombre, apellido, departamento, cargo, venta_mensual, venta_anual) " +
              "VALUES ('" + codigo + "', '" + nombre + "', '" + apellido + "', " +
              "'" + d.buscarCodigo(departamento) + "', '" + cargo + "', " + ventaMensual + ", " + ventaAnual + ")";
        
        db.executeUpdate(sql);
    }

    public void modificar() {
        DB db = new DB();
        Departamento d = new Departamento();
        
        sql = "UPDATE vendedor SET " +
              "nombre = '" + nombre + "', " +
              "apellido = '" + apellido + "', " +
              "departamento = '" + d.buscarCodigo(departamento) + "', " +
              "cargo = '" + cargo + "', " +
              "venta_mensual = " + ventaMensual + ", " +
              "venta_anual = " + ventaAnual + " " +
              "WHERE codigo = '" + codigo + "'";
        
        db.executeUpdate(sql);
    }

    public void eliminar(String codigo) {
        DB db = new DB();
        sql = "DELETE FROM vendedor WHERE codigo = '" + codigo + "'";
        db.executeUpdate(sql);
    }

    public void listar(DefaultTableModel modelo) {
        DB db = new DB();
        modelo.setRowCount(0); // Limpiar la tabla
        
        try {
            sql = "SELECT v.codigo, v.nombre, v.apellido, d.descripcion as departamento, v.cargo " +
                  "FROM vendedor v LEFT JOIN departamento d ON v.departamento = d.codigo " +
                  "ORDER BY v.apellido, v.nombre";
            
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                Object[] fila = {
                    rs.getString("codigo"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("departamento"),
                    rs.getString("cargo")
                };
                modelo.addRow(fila);
            }
            db.cerrar();
        } catch (Exception e) {
            System.out.println("Error al listar vendedores: " + e.toString());
        }
    }

    public void cargarDepartamentos(JComboBox<String> combo) {
        Departamento d = new Departamento();
        d.cargar(combo);
    }
}