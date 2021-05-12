import javax.management.JMRuntimeException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.FileSystemNotFoundException;

public class Ventana extends JFrame implements ActionListener{
    /*
    
    */
    int clicks = 0;

    boolean confirmA = false;
    boolean confirmB = false;

    String  mensajeC = "Consideracion";

    private static final long serialVersionUID = 1L;
    JPanel  labelA;
    JPanel  labelB;
    JPanel  labelC;
    JPanel  botones;

    JButton botonA;
    JButton botonB;
    JButton botonC;

    JFrame central;

    public Ventana(){
        super("Seleccion de botones");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        agregarComponentes();

        this.pack();
        this.setResizable(false);
        this.setVisible(true);

    }
    private void agregarComponentes(){

        botones = new JPanel(new BorderLayout());
        
        botones.setLayout(new GridLayout(3,1));
        botonA = new JButton("Boton A");
        botonA.addActionListener(this);
        botones.add(botonA);

        botonB = new JButton("Boton B");
        botonB.addActionListener(this);
        botones.add(botonB);

        botonC = new JButton("Boton C");
        botonC.addActionListener(this);
        botones.add(botonC);

        this.add(botones, BorderLayout.CENTER);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource().equals(botonA)){
            if (confirmB){
                confirmB = false;
                throw new NullPointerException("Orden de botones equivocado");
            }else{
                confirmA = true;
            }
        }
        else if ((e.getSource().equals(botonB))){
            if(confirmA){
            confirmB = true;
            }else{
                confirmA = false;
                confirmB = false;
                throw new ArithmeticException("El orden de los botones es: A, B, C");
            }
        }
        else if((e.getSource().equals(botonC))){
            if(confirmB){
            confirmA = false;
            confirmB = false;
            JOptionPane.showMessageDialog(this, "Logro finalizar :D", "Final", JOptionPane.INFORMATION_MESSAGE);
            }else{
                confirmA = false;
                confirmB = false;
                throw new FileSystemNotFoundException("Presione los botones en este orden: A, B, C");
            }
        }else{
            confirmA = false;
            confirmB = false;
            throw new JMRuntimeException("Debe presionar los botones en este orden: A, B, C");
        
        }
    }
}