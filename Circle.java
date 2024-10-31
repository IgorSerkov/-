package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Circle {
    private int x, y, diameter;
    private int dx, dy;
    private Color color;

    public Circle(int x, int y, int diameter) {
        this.x = x;
        this.y = y;
        this.diameter = diameter;
        this.dx = new Random().nextInt(5) + 1; // Случайная скорость по горизонтали
        this.dy = new Random().nextInt(5) + 1; // Случайная скорость по вертикали
        this.color = getRandomColor();
    }

    public void move(int width, int height) {
        // Двигать окружность
        x += dx;
        y += dy;

        // Проверить столкновение с краями окна
        if (x < 0 || x > width - diameter) {
            dx = -dx; // Меняем направление по горизонтали
            color = getRandomColor(); // Меняем цвет
        }
        if (y < 0 || y > height - diameter) {
            dy = -dy; // Меняем направление по вертикали
            color = getRandomColor(); // Меняем цвет
        }
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, diameter, diameter);
    }

    private Color getRandomColor() {
        Random random = new Random();
        return new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }
}
