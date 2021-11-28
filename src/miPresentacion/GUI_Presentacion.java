package miPresentacion;

import jdk.jfr.Event;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.zip.GZIPOutputStream;

public class GUI_Presentacion extends JFrame {//"extends" es herencia
    //atributos(todo lo grafico)(son privados)
    private JButton miFoto, miHobby, misExpectativas;
    private JPanel panelBotones, panelDatos;
    private Titulos titulo;
    private JLabel labelImagen;
    private JTextArea textoExpectivas,espacioVacio;
    private Escucha escucha;

    //metodos(lo que la ventana puede hacer)
    public GUI_Presentacion(){     //constructor de la clase
        initGUI();
        //Configuracion base de la ventana
        this.setTitle("Mi Presentacion");
        this.setSize(600,540);
        this.setLocationRelativeTo(null);//en relacion al display
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    private void initGUI(){
        //Definir Container y Layout del JFrame
        //Crear objetos Escucha y Control
        escucha =  new Escucha();
        //Configurar JComponents
        titulo  = new Titulos("Hola soy José, oprime los botones...", Color.BLACK);
        this.add(titulo,BorderLayout.NORTH);

        panelDatos = new JPanel();
        panelDatos.setBorder(BorderFactory.createTitledBorder(null,"Un poco mas de mi...",TitledBorder.DEFAULT_JUSTIFICATION,
                            TitledBorder.DEFAULT_POSITION, new Font("Calibri",Font.PLAIN,20),  Color.BLACK));

        this.add(panelDatos,BorderLayout.CENTER);

        miFoto = new JButton("Este soy yo...");
        miFoto.addMouseListener(escucha);
        miHobby = new JButton("Este es mi hobby...");
        miHobby.addMouseListener(escucha);
        misExpectativas = new JButton("Creo que...");
        misExpectativas.addKeyListener(escucha);

        panelBotones = new JPanel();
        panelBotones.add(miFoto);
        panelBotones.add(miHobby);
        panelBotones.add(misExpectativas);

        this.add(panelBotones,BorderLayout.SOUTH);

        labelImagen = new JLabel();
        textoExpectivas  = new JTextArea(1,12);
        espacioVacio  = new JTextArea(1,12);
    }

    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI_Presentacion miGUIPresentacion = new GUI_Presentacion();  //(nombre de la clase)(nombre del objeto) = new (Constructor)
            }
        });
    }

    /*private class Escucha implements ActionListener{
        private ImageIcon image;
        @Override
        public void actionPerformed(ActionEvent e) {
            //JOptionPane.showMessageDialog(null,"Oprimiste boton");
            panelDatos.removeAll();
            if (e.getSource()==miFoto){
                image=  new ImageIcon(getClass().getResource("/recursos/foto.jpg"));
                labelImagen.setIcon(image);
                panelDatos.add(labelImagen);
            }else{
                if (e.getSource()==miHobby){
                    espacioVacio.setText("\n");
                    espacioVacio.setBackground(null);
                    panelDatos.add(espacioVacio);
                    image=  new ImageIcon(getClass().getResource("/recursos/hobby.jpg"));
                    labelImagen.setIcon(image);
                    panelDatos.add(labelImagen);
                }else{
                    textoExpectivas.setText("\nNo he trabajado anteriormente con la \nprogramacion orientada a eventos, \ndeseo a lo largo de este curso realizar \nproyectos interesantes empleando lo \naprendido.");
                    textoExpectivas.setBackground(null);
                    panelDatos.add(textoExpectivas);
                    textoExpectivas.setForeground(Color.BLACK);
                    textoExpectivas.setFont(new Font(Font.DIALOG, Font.BOLD+Font.ITALIC, 20));
                    image =  new ImageIcon(getClass().getResource("/recursos/tabien.jpg"));
                    labelImagen.setIcon(image);
                    panelDatos.add(labelImagen);
                }
            }
            revalidate();
            repaint();

        }
    }*/
    private class Escucha implements MouseListener, KeyListener {
        private ImageIcon image;
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getComponent()==miFoto && e.getClickCount()==1){
                panelDatos.removeAll();
                image=  new ImageIcon(getClass().getResource("/recursos/foto.jpg"));
                labelImagen.setIcon(image);
                panelDatos.add(labelImagen);
            }
            if (e.getComponent()==miHobby && e.getClickCount()==2){
                panelDatos.removeAll();
                espacioVacio.setText("\n");
                espacioVacio.setBackground(null);
                panelDatos.add(espacioVacio);
                image=  new ImageIcon(getClass().getResource("/recursos/hobby.jpg"));
                labelImagen.setIcon(image);
                panelDatos.add(labelImagen);
            }
            revalidate();
            repaint();
        }


        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void keyTyped(KeyEvent e) {
            if(e.getKeyChar()=='M' || e.getKeyChar()=='m'){
                panelDatos.removeAll();
                textoExpectivas.setText("\nNo he trabajado anteriormente con la \nprogramacion orientada a eventos, \ndeseo a lo largo de este curso realizar \nproyectos interesantes empleando lo \naprendido.");
                textoExpectivas.setBackground(null);
                panelDatos.add(textoExpectivas);
                textoExpectivas.setForeground(Color.BLACK);
                textoExpectivas.setFont(new Font(Font.DIALOG, Font.BOLD+Font.ITALIC, 20));
                image =  new ImageIcon(getClass().getResource("/recursos/tabien.jpg"));
                labelImagen.setIcon(image);
                panelDatos.add(labelImagen);
            }
            revalidate();
            repaint();
        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

}
