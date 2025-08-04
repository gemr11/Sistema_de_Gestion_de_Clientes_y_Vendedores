import javax.swing.*;
import java.awt.*;

public class Presentacion
{
    JFrame ventana;
    JLabel lbl_titulo, lbl_universidad, lbl_facultad, lbl_carrera, lbl_materia, lbl_profesor, lbl_estudiante, lbl_cedula, lbl_grupo, lbl_fecha;
    Font fnt_titulo;

    Presentacion(JFrame v)
    {
        ventana = v;
        ventana.getContentPane().removeAll();
        ventana.revalidate();

        fnt_titulo = new Font("Arial",Font.BOLD+Font.ITALIC,35);

        lbl_titulo = new JLabel("Proyecto No. 3 - Base de Datos");
        lbl_titulo.setBounds(450,20,1000,40);
        lbl_titulo.setFont(fnt_titulo);
        ventana.add(lbl_titulo);

        lbl_universidad = new JLabel("Universidad Tecnologica de Panama");
        lbl_universidad.setBounds(450, 75, 500, 20);
        ventana.add(lbl_universidad);
        lbl_facultad = new JLabel("Facultad de Ingenieria en Sistemas Computacionales");
        lbl_facultad.setBounds(450, 100, 500, 20);
        ventana.add(lbl_facultad);
        lbl_carrera = new JLabel("Lic. Gestion y Desarrollo de Software");
        lbl_carrera.setBounds(450, 125, 500, 20);
        ventana.add(lbl_carrera);
        lbl_materia = new JLabel("Desarrollo de Software III (Java 2)");
        lbl_materia.setBounds(450, 150, 500, 20);
        ventana.add(lbl_materia);
        lbl_profesor = new JLabel("Prof. Ricardo Chan");
        lbl_profesor.setBounds(450, 175, 500, 20);
        ventana.add(lbl_profesor);
        lbl_estudiante = new JLabel("Estudiante: Gloria");
        lbl_estudiante.setBounds(450, 200, 500, 20);
        ventana.add(lbl_estudiante);
        lbl_cedula = new JLabel("Cedula:");
        lbl_cedula.setBounds(450, 225, 500, 20);
        ventana.add(lbl_cedula);
        lbl_grupo = new JLabel("Grupo: 1GS221");
        lbl_grupo.setBounds(450, 250, 500, 20);
        ventana.add(lbl_grupo);
        lbl_fecha = new JLabel("Fecha de entrega:  3 de agosto de 2025");
        lbl_fecha.setBounds(450, 275, 500, 20);
        ventana.add(lbl_fecha);



        ventana.repaint();
    }
}