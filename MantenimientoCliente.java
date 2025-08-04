import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

public class MantenimientoCliente implements ActionListener {
    JPanel panel;
    JTextField tfCedula, tfNombre, tfApellido, tfDireccion, tfTelefono, tfCompraAnual;
    JComboBox<String> cbProvincia;
    JButton btnLimpiar, btnBuscar, btnAgregar, btnModificar, btnEliminar, btnListar;
    JTable tabla;
    DefaultTableModel modelo;
    Cliente cliente;

    public MantenimientoCliente(JFrame parent) {
        // Limpiar el contenido anterior
        parent.getContentPane().removeAll();
        
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 800, 600);
        
        cliente = new Cliente();
        
        // Crear componentes
        JLabel lblTitulo = new JLabel("Mantenimiento de Clientes");
        lblTitulo.setBounds(300, 10, 200, 30);
        panel.add(lblTitulo);
        
        JLabel lblCedula = new JLabel("Cedula:");
        lblCedula.setBounds(50, 50, 100, 20);
        panel.add(lblCedula);
        
        tfCedula = new JTextField();
        tfCedula.setBounds(150, 50, 150, 20);
        panel.add(tfCedula);
        
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
        
        JLabel lblDireccion = new JLabel("Direccion:");
        lblDireccion.setBounds(50, 140, 100, 20);
        panel.add(lblDireccion);
        
        tfDireccion = new JTextField();
        tfDireccion.setBounds(150, 140, 300, 20);
        tfDireccion.setEnabled(false);
        panel.add(tfDireccion);
        
        JLabel lblTelefono = new JLabel("Telefono:");
        lblTelefono.setBounds(50, 170, 100, 20);
        panel.add(lblTelefono);
        
        tfTelefono = new JTextField();
        tfTelefono.setBounds(150, 170, 100, 20);
        tfTelefono.setEnabled(false);
        panel.add(tfTelefono);
        
        JLabel lblProvincia = new JLabel("Provincia:");
        lblProvincia.setBounds(50, 200, 100, 20);
        panel.add(lblProvincia);
        
        cbProvincia = new JComboBox<>();
        cliente.cargarProvincias(cbProvincia);
        cbProvincia.setBounds(150, 200, 200, 20);
        cbProvincia.setEnabled(false);
        panel.add(cbProvincia);
        
        JLabel lblCompraAnual = new JLabel("Compra Anual:");
        lblCompraAnual.setBounds(50, 230, 100, 20);
        panel.add(lblCompraAnual);
        
        tfCompraAnual = new JTextField();
        tfCompraAnual.setBounds(150, 230, 100, 20);
        tfCompraAnual.setEnabled(false);
        panel.add(tfCompraAnual);
        
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
        
        // Tabla para listar clientes
        modelo = new DefaultTableModel();
        modelo.addColumn("Cedula");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Telefono");
        modelo.addColumn("Provincia");
        
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
            buscarCliente();
        } else if (e.getSource() == btnAgregar) {
            agregarCliente();
        } else if (e.getSource() == btnModificar) {
            modificarCliente();
        } else if (e.getSource() == btnEliminar) {
            eliminarCliente();
        } else if (e.getSource() == btnLimpiar) {
            limpiarCampos();
        } else if (e.getSource() == btnListar) {
            listarClientes();
        }
    }

    private void buscarCliente() {
        String cedula = tfCedula.getText().trim();

        
        cliente.buscar(cedula);
        
        if (cliente.getNombre() != null) { // Cliente existe
            tfNombre.setText(cliente.getNombre());
            tfApellido.setText(cliente.getApellido());
            tfDireccion.setText(cliente.getDireccion());
            tfTelefono.setText(cliente.getTelefono());
            cbProvincia.setSelectedItem(cliente.getProvincia());
            tfCompraAnual.setText(String.valueOf(cliente.getCompraAnual()));
            
            // Habilitar/deshabilitar botones
            btnAgregar.setEnabled(false);
            btnModificar.setEnabled(true);
            btnEliminar.setEnabled(true);
            
            // Bloquear cédula
            tfCedula.setEnabled(false);
            
            // Habilitar campos
            habilitarCampos(true);
        } else { // Cliente no existe
            btnAgregar.setEnabled(true);
            btnModificar.setEnabled(false);
            btnEliminar.setEnabled(false);
            tfCedula.setEnabled(false);
            habilitarCampos(true);
        }
    }

    private void agregarCliente() {

            cliente.setCedula(tfCedula.getText());
            cliente.setNombre(tfNombre.getText());
            cliente.setApellido(tfApellido.getText());
            cliente.setDireccion(tfDireccion.getText());
            cliente.setTelefono(tfTelefono.getText());
            cliente.setProvincia(cbProvincia.getSelectedItem().toString());
            cliente.setCompraAnual(Integer.parseInt(tfCompraAnual.getText()));
            
            cliente.agregar();
            System.out.println("Cliente agregado");
            limpiarCampos();
            listarClientes();
        
    }

    private void modificarCliente() {
            cliente.setNombre(tfNombre.getText());
            cliente.setApellido(tfApellido.getText());
            cliente.setDireccion(tfDireccion.getText());
            cliente.setTelefono(tfTelefono.getText());
            cliente.setProvincia(cbProvincia.getSelectedItem().toString());
            cliente.setCompraAnual(Integer.parseInt(tfCompraAnual.getText()));
            
            cliente.modificar();
            
            limpiarCampos();
            listarClientes();
    }

    private void eliminarCliente() {

        

            cliente.eliminar(tfCedula.getText());
            limpiarCampos();
            listarClientes();
        
	System.out.println("Cliente eliminado");
    }

    private void limpiarCampos() {
        tfCedula.setText("");
        tfNombre.setText("");
        tfApellido.setText("");
        tfDireccion.setText("");
        tfTelefono.setText("");
        tfCompraAnual.setText("");
        cbProvincia.setSelectedIndex(0);
        
        // Habilitar/deshabilitar controles
        tfCedula.setEnabled(true);
        habilitarCampos(false);
        
        btnAgregar.setEnabled(false);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
    }

    private void listarClientes() {
        cliente.listar(modelo);
    }

    private void habilitarCampos(boolean habilitar) {
        tfNombre.setEnabled(habilitar);
        tfApellido.setEnabled(habilitar);
        tfDireccion.setEnabled(habilitar);
        tfTelefono.setEnabled(habilitar);
        cbProvincia.setEnabled(habilitar);
        tfCompraAnual.setEnabled(habilitar);
    }

    
}