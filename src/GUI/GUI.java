package GUI;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    Container contenedor;

    public JTextField [][] field = new JTextField[9][9];
    public JTextField attempts;
    private JPanel dashBoard, cuadricula, separador;
    private JLabel attemptsLabel;

    public  JButton check;

    public GUI () {
        contenedor = getContentPane();
        setTitle("Sudoku Game");
        setSize(600,600);
        setLocationRelativeTo(null);
        iniciarPaneles();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void iniciarPaneles () {
        Dashboard();
        Cuadricula();
    }

    private void Dashboard() {
        dashBoard = new JPanel();

        //Attempts
        attempts = new JTextField();
        attempts.setEnabled(false);
        attemptsLabel = new JLabel("Attempts");
        attemptsLabel.setBounds(440,460,50,50);
        attemptsLabel.setForeground(Color.white);
        dashBoard.add(attemptsLabel);
        attempts.setBounds(440,500,50,30);
        dashBoard.setLayout(null);


        //Check

        check = new JButton("CHECK!");
        check.setBounds(240,500,100,30);
        check.setBackground(Color.white);
        dashBoard.add(check);

        Color color = new Color(32,25,50);
        dashBoard.setBackground(color);
        dashBoard.add(attempts);
        contenedor.add(dashBoard);
    }


    public void Cuadricula() {

        cuadricula = new JPanel();
        cuadricula.setBounds(90, 75, 400, 400);
        separador = new JPanel();
        
        cuadricula.setBackground(Color.black);
        cuadricula.setLayout(new GridLayout(9, 9, 4, 4));


        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                field[i][j] = new JTextField();
                cuadricula.add(field[i][j]);
            }
        }


        dashBoard.add(cuadricula);
    }



}
