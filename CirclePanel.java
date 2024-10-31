package shapes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random; // Добавить этот импорт

public class CirclePanel extends JPanel implements ActionListener {
    private final ArrayList<Circle> circles;
    private final Timer timer;

    public CirclePanel(int numCircles) {
        circles = new ArrayList<>();
        for (int i = 0; i < numCircles; i++) {
            int diameter = new Random().nextInt(30) + 20; // Случайный диаметр от 20 до 50
            int x = new Random().nextInt(800 - diameter); // Случайная позиция x
            int y = new Random().nextInt(600 - diameter); // Случайная позиция y
            circles.add(new Circle(x, y, diameter));
        }
        timer = new Timer(30, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Circle circle : circles) {
            circle.draw(g);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (Circle circle : circles) {
            circle.move(getWidth(), getHeight());
        }
        repaint();
    }
}