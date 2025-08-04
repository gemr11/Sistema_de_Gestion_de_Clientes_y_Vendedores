import java.sql.*;

public class DB {
    String URL, user, pass, sql;
    Connection con;
    Statement stmt;
    ResultSet rs;

    DB() {
        URL = "jdbc:mysql://127.0.0.1/proyecto_3";
        user = "root";
        pass = "root";
    }

    public void abrir() {
        try {
            con = DriverManager.getConnection(URL, user, pass);
            stmt = con.createStatement();
        } catch (Exception e) {
            System.out.println("error abrir " + e.toString());
        }
    }

    public ResultSet executeQuery(String sql) {
        try {
            abrir();
            rs = stmt.executeQuery(sql);
        } catch (Exception e) {
            System.out.println("error queryBD " + e.toString());
        }
        return rs;
    }

    public void executeUpdate(String sql) {
        try {
            abrir();
            stmt.executeUpdate(sql);
            cerrar();
        } catch (Exception e) {
            System.out.println("error update " + e.toString());
        }
    }

    public void cerrar() {
        try {
            if (rs != null)
                rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println("error cerrar " + e.toString());
        }
    }

    public Connection con() {
        return con;
    }
}