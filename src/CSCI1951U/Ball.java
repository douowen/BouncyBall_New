package CSCI1951U;

import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Ball {
    private double startX;
    private double startY;
    private double radius;
    private double vx;
    private double vy;
    private Color color;
    private int id;
    private ArrayList<Ball> list;

    private final double SIZE = .05;

    public Ball(int id, ArrayList<Ball> list) {
        this.startX = Math.random();
        this.startY = Math.random();
        this.vx = randomPos();
        this.vy = .023;
        this.radius = SIZE;
        this.color = randomColor();
        this.id = id;
        this.list = list;
    }

    public int id() {
        return this.id;
    }

    public double getX() {
        return this.startX;
    }

    public double getY() {
        return this.startY;
    }

    public double getVX() {
        return this.vx;
    }

    public double getVY() {
        return this.vy;
    }

    public void setVX(double vx) {
        this.vx = vx;
    }

    public void setVY(double vy) {
        this.vy = vy;
    }

    public double size() {
        return this.radius;
    }

    public Color getColor() {
        return this.color;
    }

    public void setStart(double x, double y) {
        this.startX += x;
        this.startY += y;
    }

    public void updateBall() {
        checkWall(this.vx, this.vy);
        checkCollideMouse();
        checkBallCollision();
    }

    public void checkBallCollision() {
        for (Ball ball : this.list) {
            if (ball.id() != this.id) {
                double xx = Math.abs(this.startX - ball.getX());
                double yy = Math.abs(this.startY - ball.getY());
                double xy = Math.sqrt(xx * xx + yy * yy);
                if (xy <= size() + ball.size()) {
                    this.vx = -this.vx;
                    ball.setVX(-ball.getVX());
                    setStart(this.vx, this.vy);
                    ball.setStart(ball.getVX(), ball.getVY());
                }
            }
        }
    }

    public void checkCollideMouse() {
        double xx = Math.abs(this.startX - StdDraw.mouseX());
        double yy = Math.abs(this.startY - StdDraw.mouseY());
        double xy = Math.sqrt(xx * xx + yy * yy);

        if (xy <= size() + 0.08) {
            this.vx = -this.vx;
            this.vy = -this.vy;
            setStart(this.vx, this.vy);
            setColor(randomColor());
        }
    }

    public void checkWall(double vx, double vy) {
        if (this.startX - this.radius + vx < -1.0 || this.startX + this.radius + vx > 1.0) {
            this.vx = -vx;
        }

        if (this.startY - this.radius + vy < -1.0 || this.startY + this.radius + vy > 1.0) {
            this.vy = -vy;
        }

        setStart(this.vx, this.vy);
    }

    public void setSize(double size) {
        this.radius = size;
    }

    public void setColor(Color color) {
        if (this.color.equals(color)) {
            setColor(randomColor());
        } else {
            this.color = color;
        }
    }

    private static Color randomColor() {
        Color[] colors = {
                StdDraw.BOOK_LIGHT_BLUE,
                StdDraw.PRINCETON_ORANGE,
                StdDraw.YELLOW,
                StdDraw.PINK
        };

        int r = ThreadLocalRandom.current().nextInt(0, colors.length);
        return colors[r];
    }

    private double randomPos() {
        return ThreadLocalRandom.current().nextDouble(0, .05);
    }
}
