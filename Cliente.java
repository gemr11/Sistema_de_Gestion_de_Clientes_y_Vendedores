import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;

public class Cliente extends Persona {
    private String cedula;
    private String direccion;
    private String telefono;
    private String provincia;
    private int compraAnual;
    private String sql;

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCedula() {
        return cedula;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setCompraAnual(int compraAnual) {
        this.compraAnual = compraAnual;
    }

    public int getCompraAnual() {
        return compraAnual;
    }

public void buscar(String cedula) {
    DB db = new DB();

    try {
        // Usar = en lugar de LIKE para comparación exacta
        sql = "SELECT c.*, p.descripcion as provincia_desc FROM cliente c " +
              "LEFT JOIN provincia p ON c.provincia = p.codigo " +
              "WHERE c.cedula = '" + cedula + "'";
        
        ResultSet rs = db.executeQuery(sql);
        if (rs.next()) {
            this.cedula = rs.getString("cedula");
            this.nombre = rs.getString("nombre");
            this.apellido = rs.getString("apellido");
            this.direccion = rs.getString("direccion");
            this.telefono = rs.getString("telefono");
            this.provincia = rs.getString("provincia_desc");
            this.compraAnual = rs.getInt("compra_anual");
        } else {
            // Limpiar los campos si no se encuentra el cliente
            //this.cedula = null;
            this.nombre = null;
            this.apellido = null;
            this.direccion = null;
            this.telefono = null;
            this.provincia = null;
            this.compraAnual = 0;
        }
        db.cerrar();
    } catch (Exception e) {
        System.out.println("Error al buscar cliente: " + e.toString());
    }
}

    public void agregar() {
        DB db = new DB();
        Provincia p = new Provincia();
        
        sql = "INSERT INTO cliente (cedula, nombre, apellido, direccion, telefono, provincia, compra_anual) " +
              "VALUES ('" + cedula + "', '" + nombre + "', '" + apellido + "', '" + direccion + "', " +
              "'" + telefono + "', '" + p.buscarCodigo(provincia) + "', " + compraAnual + ")";
        
        db.executeUpdate(sql);
    }

    public void modificar() {
        DB db = new DB();
        Provincia p = new Provincia();
        
        sql = "UPDATE cliente SET " +
              "nombre = '" + nombre + "', " +
              "apellido = '" + apellido + "', " +
              "direccion = '" + direccion + "', " +
              "telefono = '" + telefono + "', " +
              "provincia = '" + p.buscarCodigo(provincia) + "', " +
              "compra_anual = " + compraAnual + " " +
              "WHERE cedula = '" + cedula + "'";
        
        db.executeUpdate(sql);
    }

    public void eliminar(String cedula) {
        DB db = new DB();
        sql = "DELETE FROM cliente WHERE cedula = '" + cedula + "'";
        db.executeUpdate(sql);
	db.cerrar();


    }

    public void listar(DefaultTableModel modelo) {
        DB db = new DB();
        modelo.setRowCount(0); // Limpiar la tabla
        
        try {
            sql = "SELECT c.cedula, c.nombre, c.apellido, c.telefono, p.descripcion as provincia " +
                  "FROM cliente c LEFT JOIN provincia p ON c.provincia = p.codigo " +
                  "ORDER BY c.apellido, c.nombre";
            
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                Object[] fila = {
                    rs.getString("cedula"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("telefono"),
                    rs.getString("provincia")
                };
                modelo.addRow(fila);
            }
            db.cerrar();
        } catch (Exception e) {
            System.out.println("Error al listar clientes: " + e.toString());
        }
    }

    public void cargarProvincias(JComboBox<String> combo) {
        Provincia p = new Provincia();
        p.cargar(combo);
    }
}