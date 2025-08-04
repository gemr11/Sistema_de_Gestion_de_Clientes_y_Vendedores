import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

public class MantenimientoVendedor implements ActionListener {
    JPanel panel;
    JTextField tfCodigo, tfNombre, tfApellido, tfCargo, tfVentaMensual, tfVentaAnual;
    JComboBox<String> cbDepartamento;
    JButton btnLimpiar, btnBuscar, btnAgregar, btnModificar, btnEliminar, btnListar;
    JTable tabla;
    DefaultTableModel modelo;
    Vendedor vendedor;

    public MantenimientoVendedor(JFrame parent) {
        parent.getContentPane().removeAll();
        
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 800, 600);
        
        vendedor = new Vendedor();
        
        JLabel lblTitulo = new JLabel("Mantenimiento de Vendedores");
        lblTitulo.setBounds(300, 10, 200, 30);
        panel.add(lblTitulo);
        
        JLabel lblCodigo = new JLabel("Codigo:");
        lblCodigo.setBounds(50, 50, 100, 20);
        panel.add(lblCodigo);
        
        tfCodigo = new JTextField();
        tfCodigo.setBounds(150, 50, 150, 20);
        panel.add(tfCodigo);
        
        btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(310, 50, 80, 20);
        btnBuscar.addActionListener(this);
        panel.add(btnBuscar);
        
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(50, 80, 100, 20);
        panel.add(lblNombre);
        
        tfNombre = new JTextField();
        tfNombre.setBounds(150, 80, 200, 20);
        tfNombre.setEnabled(false);
        panel.add(tfNombre);
        
        JLabel lblApellido = new JLabel("Apellido:");
        lblApellido.setBounds(50, 110, 100, 20);
        panel.add(lblApellido);
        
        tfApellido = new JTextField();
        tfApellido.setBounds(150, 110, 200, 20);
        tfApellido.setEnabled(false);
        panel.add(tfApellido);
        
        JLabel lblDepartamento = new JLabel("Departamento:");
        lblDepartamento.setBounds(50, 140, 100, 20);
        panel.add(lblDepartamento);
        
        cbDepartamento = new JComboBox<>();
        vendedor.cargarDepartamentos(cbDepartamento);
        cbDepartamento.setBounds(150, 140, 200, 20);
        cbDepartamento.setEnabled(false);
        panel.add(cbDepartamento);
        
        JLabel lblCargo = new JLabel("Cargo:");
        lblCargo.setBounds(50, 170, 100, 20);
        panel.add(lblCargo);
        
        tfCargo = new JTextField();
        tfCargo.setBounds(150, 170, 200, 20);
        tfCargo.setEnabled(false);
        panel.add(tfCargo);
        
        JLabel lblVentaMensual = new JLabel("Venta Mensual:");
        lblVentaMensual.setBounds(50, 200, 100, 20);
        panel.add(lblVentaMensual);
        
        tfVentaMensual = new JTextField();
        tfVentaMensual.setBounds(150, 200, 100, 20);
        tfVentaMensual.setEnabled(false);
        panel.add(tfVentaMensual);
        
        JLabel lblVentaAnual = new JLabel("Venta Anual:");
        lblVentaAnual.setBounds(50, 230, 100, 20);
        panel.add(lblVentaAnual);
        
        tfVentaAnual = new JTextField();
        tfVentaAnual.setBounds(150, 230, 100, 20);
        tfVentaAnual.setEnabled(false);
        panel.add(tfVentaAnual);
        
        btnAgregar = new JButton("Agregar");
        btnAgregar.setBounds(50, 270, 100, 30);
        btnAgregar.addActionListener(this);
        btnAgregar.setEnabled(false);
        panel.add(btnAgregar);
        
        btnModificar = new JButton("Modificar");
        btnModificar.setBounds(175, 270, 100, 30);
        btnModificar.addActionListener(this);
        btnModificar.setEnabled(false);
        panel.add(btnModificar);
        
        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(265, 270, 100, 30);
        btnEliminar.addActionListener(this);
        btnEliminar.setEnabled(false);
        panel.add(btnEliminar);
        
        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(355, 270, 100, 30);
        btnLimpiar.addActionListener(this);
        panel.add(btnLimpiar);
        
        btnListar = new JButton("Listar");
        btnListar.setBounds(445, 270, 100, 30);
        btnListar.addActionListener(this);
        panel.add(btnListar);
        
        modelo = new DefaultTableModel();
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Departamento");
        modelo.addColumn("Cargo");
        
        tabla = new JTable(modelo);
        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setBounds(50, 320, 700, 200);
        panel.add(scrollPane);
        
        parent.add(panel);
        parent.revalidate();
        parent.repaint();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBuscar) {
            buscarVendedor();
        } else if (e.getSource() == btnAgregar) {
            agregarVendedor();
        } else if (e.getSource() == btnModificar) {
            modificarVendedor();
        } else if (e.getSource() == btnEliminar) {
            eliminarVendedor();
        } else if (e.getSource() == btnLimpiar) {
            limpiarCampos();
        } else if (e.getSource() == btnListar) {
            listarVendedores();
        }
    }

    private void buscarVendedor() {
        String codigo = tfCodigo.getText().trim();
        if (codigo.isEmpty()) {
            System.out.println("Error: Ingrese un Codigo para buscar");
            return;
        }
        
        vendedor.buscar(codigo);
        
        if (vendedor.getNombre() != null) {
            tfNombre.setText(vendedor.getNombre());
            tfApellido.setText(vendedor.getApellido());
            cbDepartamento.setSelectedItem(vendedor.getDepartamento());
            tfCargo.setText(vendedor.getCargo());
            tfVentaMensual.setText(String.valueOf(vendedor.getVentaMensual()));
            tfVentaAnual.setText(String.valueOf(vendedor.getVentaAnual()));
            
            btnAgregar.setEnabled(false);
            btnModificar.setEnabled(true);
            btnEliminar.setEnabled(true);
            tfCodigo.setEnabled(false);
            habilitarCampos(true);
        } else {
            System.out.println("Vendedor no encontrado, puede agregar uno nuevo");
            btnAgregar.setEnabled(true);
            btnModificar.setEnabled(false);
            btnEliminar.setEnabled(false);
            tfCodigo.setEnabled(false);
            habilitarCampos(true);
        }
    }

    private void agregarVendedor() {
        vendedor.setCodigo(tfCodigo.getText());
        vendedor.setNombre(tfNombre.getText());
        vendedor.setApellido(tfApellido.getText());
        vendedor.setDepartamento(cbDepartamento.getSelectedItem().toString());
        vendedor.setCargo(tfCargo.getText());
        vendedor.setVentaMensual(Integer.parseInt(tfVentaMensual.getText()));
        vendedor.setVentaAnual(Integer.parseInt(tfVentaAnual.getText()));
        
        vendedor.agregar();
        System.out.println("Vendedor agregado correctamente");
        limpiarCampos();
        listarVendedores();
    }

    private void modificarVendedor() {
        vendedor.setNombre(tfNombre.getText());
        vendedor.setApellido(tfApellido.getText());
        vendedor.setDepartamento(cbDepartamento.getSelectedItem().toString());
        vendedor.setCargo(tfCargo.getText());
        vendedor.setVentaMensual(Integer.parseInt(tfVentaMensual.getText()));
        vendedor.setVentaAnual(Integer.parseInt(tfVentaAnual.getText()));
        
        vendedor.modificar();
        System.out.println("Vendedor modificado correctamente");
        limpiarCampos();
        listarVendedores();
    }

    private void eliminarVendedor() {
        vendedor.eliminar(tfCodigo.getText());
        System.out.println("Vendedor eliminado correctamente");
        limpiarCampos();
	modelo.setRowCount(0);
        listarVendedores();
    }

    private void limpiarCampos() {
        tfCodigo.setText("");
        tfNombre.setText("");
        tfApellido.setText("");
        tfCargo.setText("");
        tfVentaMensual.setText("");
        tfVentaAnual.setText("");
        cbDepartamento.setSelectedIndex(0);
        
        tfCodigo.setEnabled(true);
        habilitarCampos(false);
        
        btnAgregar.setEnabled(false);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
    }

    private void listarVendedores() {
        vendedor.listar(modelo);
    }

    private void habilitarCampos(boolean habilitar) {
        tfNombre.setEnabled(habilitar);
        tfApellido.setEnabled(habilitar);
        cbDepartamento.setEnabled(habilitar);
        tfCargo.setEnabled(habilitar);
        tfVentaMensual.setEnabled(habilitar);
        tfVentaAnual.setEnabled(habilitar);
    }
}