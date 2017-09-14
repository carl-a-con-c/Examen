/*
14/09/2017
Gómez García Carla Denise
5IM8
*/
package examen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class Conversor extends JFrame 
{
    //Variables declaradas
    private static final long serialVersionUID = 1583724102189855698L;
    JTextField pantalla;
    double resultado;
    String operacion;
    JPanel panelNumeros, panelOperaciones;
    boolean nuevaOperacion = true;

    //Método Constructor
    public Conversor() 
    {
        super();
        setBounds(800, 200, 400, 400);
        setTitle("Conversor");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel panel = (JPanel) this.getContentPane();
        panel.setLayout(new BorderLayout());

        pantalla = new JTextField("0", 20);
        pantalla.setBorder(new EmptyBorder(4, 4, 4, 4));
        pantalla.setEditable(false);
        pantalla.setBackground(Color.WHITE);
        panel.add("North", pantalla);

        panelNumeros = new JPanel();
        panelNumeros.setLayout(new GridLayout(4, 5));
        panelNumeros.setBorder(new EmptyBorder(4, 4, 4, 4));

        for (int n = 9; n >= 0; n--) 
        {
            nuevoBotonNumerico("" + n);
        }

        nuevoBotonNumerico(".");

        panel.add("Center", panelNumeros);

        panelOperaciones = new JPanel();
        panelOperaciones.setLayout(new GridLayout(2, 1));
        panelOperaciones.setBorder(new EmptyBorder(4, 4, 4, 4));

        nuevoBotonOperacion("Convertir");
        nuevoBotonOperacion("Limpiar");

        panel.add("East", panelOperaciones);

        validate();
    }

    //Método que crea los botones
    private void nuevoBotonNumerico(String digito) 
    {
        JButton btn = new JButton();
        btn.setText(digito);
        btn.setBackground(Color.LIGHT_GRAY);
        btn.addMouseListener(new MouseAdapter() 
        {

            @Override
            public void mouseReleased(MouseEvent evt) 
            {
                JButton btn = (JButton) evt.getSource();
                numeroPulsado(btn.getText());
            }
        }
        );

        panelNumeros.add(btn);
    }

    private void nuevoBotonOperacion(String operacion) 
    {
        JButton btn = new JButton(operacion);

        btn.addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mouseReleased(MouseEvent evt) 
            {
                JButton btn = (JButton) evt.getSource();
                operacionPulsado(btn.getText());
            }
        });

            panelOperaciones.add(btn);
    }

    
    private void numeroPulsado(String digito) 
    {
        if (pantalla.getText().equals("0") || nuevaOperacion) 
        {
            pantalla.setText(digito);
        } 
        else 
        {
            pantalla.setText(pantalla.getText() + digito);
        }
        nuevaOperacion = false;
    }

    //Método conversor de pesos
    private void operacionPulsado(String tecla) 
    {

        if (tecla.equals("Limpiar")) 
        {
            resultado = 0;
            pantalla.setText("");
            nuevaOperacion = true;
        }
        else
        {
            if(tecla.equals("Convertir")) 
            {
                resultado = new Double(pantalla.getText());
                pantalla.setText("" + resultado/17 + " " +" dolares");
                nuevaOperacion = true;
            }
            nuevaOperacion = true;
        }
    }
}
