import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.*;
import java.util.*;

public class ReporteVendedor {
    JPanel panel;
    JRadioButton rbApellido, rbCodigo, rbDepartamento;
    ButtonGroup bgOrden;
    JButton btnGenerar;

    public ReporteVendedor(JFrame parent) {
        // Limpiar el contenido anterior
        parent.getContentPane().removeAll();
        
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 800, 600);
        
        JLabel lblTitulo = new JLabel("Reporte de Vendedores");
        lblTitulo.setBounds(300, 50, 200, 30);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(lblTitulo);
        
        JLabel lblOrden = new JLabel("Ordenar por:");
        lblOrden.setBounds(100, 100, 100, 20);
        panel.add(lblOrden);
        
        rbApellido = new JRadioButton("Apellido");
        rbApellido.setBounds(100, 130, 100, 20);
        panel.add(rbApellido);
        
        rbCodigo = new JRadioButton("Codigo");
        rbCodigo.setBounds(100, 160, 100, 20);
        panel.add(rbCodigo);
        
        rbDepartamento = new JRadioButton("Departamento");
        rbDepartamento.setBounds(100, 190, 150, 20);
        panel.add(rbDepartamento);
        
        bgOrden = new ButtonGroup();
        bgOrden.add(rbApellido);
        bgOrden.add(rbCodigo);
        bgOrden.add(rbDepartamento);
        
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
        } else if (rbCodigo.isSelected()) {
            orden = "codigo";
        } else if (rbDepartamento.isSelected()) {
            orden = "departamento";
        } 
        
        try {
            DB db = new DB();
            db.abrir();
            
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("orden", orden);
            
            JasperPrint jasperPrint = JasperFillManager.fillReport(
                "reporte_vendedores.jasper", 
                parametros, 
                db.con());
                
            JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
            jasperViewer.setVisible(true);
            
            db.cerrar();
        } catch (Exception e) {
	    System.out.println("Error al generar reporte de vendedores");
        }
    }
}