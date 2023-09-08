package GUI;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    Container contenedor;

    public JButton [][] button = new JButton[9][9];
    private JPanel dashBoard, cuadricula;

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
        dashBoard.setLayout(null);
        //dashBoard.setBounds(0, 0, 250, 100);
        Color color = new Color(32,25,50);
        dashBoard.setBackground(color);
        contenedor.add(dashBoard);
    }


    public void Cuadricula() {

        cuadricula = new JPanel();
        cuadricula.setBounds(90, 75, 400, 400);
        cuadricula.setBackground(Color.black);
        cuadricula.setLayout(new GridLayout(9, 9, 4, 4));
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                button[i][j] = new JButton();
                cuadricula.add(button[i][j]);
            }
        }
        dashBoard.add(cuadricula);
    }



}
