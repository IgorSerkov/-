package shapes;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Moving Circles");
        CirclePanel circlePanel = new CirclePanel(10); // Создаем 10 окружностей
        frame.add(circlePanel);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}