import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.*;
import java.util.*;

public class ReporteCliente {
    JPanel panel;
    JRadioButton rbApellido, rbCedula, rbCompraAnual;
    ButtonGroup bgOrden;
    JButton btnGenerar;

    public ReporteCliente(JFrame parent) {
        // Limpiar el contenido anterior
        parent.getContentPane().removeAll();
        
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 800, 600);
        
        JLabel lblTitulo = new JLabel("Reporte de Clientes");
        lblTitulo.setBounds(300, 50, 200, 30);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(lblTitulo);
        
        JLabel lblOrden = new JLabel("Ordenar por:");
        lblOrden.setBounds(100, 100, 100, 20);
        panel.add(lblOrden);
        
        rbApellido = new JRadioButton("Apellido");
        rbApellido.setBounds(100, 130, 100, 20);
        panel.add(rbApellido);
        
        rbCedula = new JRadioButton("Cedula");
        rbCedula.setBounds(100, 160, 100, 20);
        panel.add(rbCedula);
        
        rbCompraAnual = new JRadioButton("Compra Anual");
        rbCompraAnual.setBounds(100, 190, 150, 20);
        panel.add(rbCompraAnual);
        
        bgOrden = new ButtonGroup();
        bgOrden.add(rbApellido);
        bgOrden.add(rbCedula);
        bgOrden.add(rbCompraAnual);
        
        btnGenerar = new JButton("Generar Reporte");
        btnGenerar.setBounds(100, 230, 150, 30);
        btnGenerar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generarReporte();
            }
        });
        panel.add(btnGenerar);
        
        parent.add(panel);
        parent.revalidate();
        parent.repaint();
    }

    private void generarReporte() {
        String orden = "";
        if (rbApellido.isSelected()) {
            orden = "apellido";
        } else if (rbCedula.isSelected()) {
            orden = "cedula";
        } else if (rbCompraAnual.isSelected()) {
            orden = "compra_anual";
        } 
        
        try {
            DB db = new DB();
            db.abrir();
            
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("orden", orden);
            
            JasperPrint jasperPrint = JasperFillManager.fillReport(
                "reporte_clientes.jasper", 
                parametros, 
                db.con());
                
            JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
            jasperViewer.setVisible(true);
            
            db.cerrar();
        } catch (Exception e) {
            System.out.println("Error al generar el reporte de clientes");
        }
    }
}