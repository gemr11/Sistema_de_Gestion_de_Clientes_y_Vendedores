import javax.swing.*;
import java.awt.event.*;

public class ProyFinal implements ActionListener {
    JFrame ventana;
    JMenuBar menuBar;
    JMenu mnu_inicio, mnu_mantenimiento, mnu_reporte;
    JMenuItem mni_presentacion, mni_salir;
    JMenuItem mni_cliente, mni_vendedor;
    JMenuItem mni_reporte_cliente, mni_reporte_vendedor;

    public static void main(String[] args) {
        new ProyFinal();
    }

    ProyFinal() {
        ventana = new JFrame("Proyecto No. 3 - Base de Datos (Gloria)");
        ventana.setSize(1000, 600);
        ventana.setLocation(50, 100);
        ventana.setLayout(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Crear la barra de menú
        menuBar = new JMenuBar();

        // Menú Inicio
        mnu_inicio = new JMenu("Inicio");
        
        mni_presentacion = new JMenuItem("Presentacion");
        mni_presentacion.addActionListener(this);
        
        mni_salir = new JMenuItem("Salir");
        mni_salir.addActionListener(this);
        
        mnu_inicio.add(mni_presentacion);
        mnu_inicio.addSeparator();
        mnu_inicio.add(mni_salir);
        menuBar.add(mnu_inicio);

        // Menú Mantenimiento
        mnu_mantenimiento = new JMenu("Mantenimiento");
        
        mni_cliente = new JMenuItem("Cliente");
        mni_cliente.addActionListener(this);
        
        mni_vendedor = new JMenuItem("Vendedor");
        mni_vendedor.addActionListener(this);
        
        mnu_mantenimiento.add(mni_cliente);
        mnu_mantenimiento.addSeparator();
        mnu_mantenimiento.add(mni_vendedor);
        menuBar.add(mnu_mantenimiento);

        // Menú Reporte
        mnu_reporte = new JMenu("Reporte");
        
        mni_reporte_cliente = new JMenuItem("Reporte Clientes");
        mni_reporte_cliente.addActionListener(this);
        
        mni_reporte_vendedor = new JMenuItem("Reporte Vendedores");
        mni_reporte_vendedor.addActionListener(this);
        
        mnu_reporte.add(mni_reporte_cliente);
        mnu_reporte.addSeparator();
        mnu_reporte.add(mni_reporte_vendedor);
        menuBar.add(mnu_reporte);

        ventana.setJMenuBar(menuBar);

        new Presentacion(ventana);
        ventana.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mni_salir) {
            System.exit(0);
        }
        
        if (e.getSource() == mni_presentacion) {
            new Presentacion(ventana);
        }
        
        if (e.getSource() == mni_cliente) {
            new MantenimientoCliente(ventana);
        }
        
        if (e.getSource() == mni_vendedor) {
            new MantenimientoVendedor(ventana);
        }
        
        if (e.getSource() == mni_reporte_cliente) {
            new ReporteCliente(ventana);
        }
        
        if (e.getSource() == mni_reporte_vendedor) {
            new ReporteVendedor(ventana);
        }
    }
}