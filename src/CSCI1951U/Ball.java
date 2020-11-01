package CSCI1951U;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class Ball {
    private double startX;
    private double startY;
    private double radius;
    private double vx;
    private double vy;
    private Color color;
    private int id;

    private final double SIZE = .05;

    public Ball(int id) {
        this.startX = Math.random();
        this.startY = Math.random();
//        this.vx = Math.random() * .01;
//        this.vy = Math.random() * .01;
//        this.startX = randomPos();
//        this.startY = .95;
        this.vx = randomPos();
        this.vy = .023;
        this.radius = SIZE;
        this.color = randomColor();
        this.id = id;
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

    public static void checkCollide(Ball p, Ball q) {
        double psize = p.size();
        double qsize = q.size();
        if ((Math.abs((p.getX() + psize/2) - (q.getX() + qsize/2)) <= psize) && (Math.abs((p.getY() + psize/2) - (q.getY() + qsize/2)) <= psize)) {

            p.setVX(-p.getVX());
//            p.setVY(-p.getVY());
            q.setVX(-q.getVX());
//            q.setVY(-q.getVY());
            p.setStart(p.getVX(), p.getVY());
            q.setStart(q.getVX(), q.getVY());
        }
    }

    public void checkCollideMouse() {
        if ((Math.abs((this.startX + this.radius/2) - (StdDraw.mouseX() + .08/2)) <= .08)
                && (Math.abs((this.startY + this.radius/2) - (StdDraw.mouseY() + .08/2)) <= .08)) {
            this.vx = -this.vx;
            this.vy = -this.vy;
            setStart(this.vx, this.vy);
        }
    }

    public void checkWall(double vx, double vy) {
        // Change directions when collide the walls
        if (this.startX - this.radius + vx < -1.0 || this.startX + this.radius + vx > 1.0) {
            this.vx = -vx;
        }

        if (this.startY - this.radius + vy < -1.0 || this.startY + this.radius + vy > 1.0) {
            this.vy = -vy;
        }

        setStart(this.vx, this.vy);

        // Change direction when collide with the player
//        if (this.startX + this.radius + vx == StdDraw.mouseX() - .08 || this.startX - this.radius + vx == StdDraw.mouseX() + .08 ) {
//            vx = -vx;
//        }
//        boolean touchTop = vy < this.startY - this.radius && this.startY - this.radius + vy < StdDraw.mouseY() + .01;
//        boolean touchBottom = vy > this.startY + this.radius && this.startY + this.radius + vy > StdDraw.mouseY() - .01;
//
//        boolean touchInRange = this.startX + this.radius + vx > StdDraw.mouseX() - .08
//                && this.startX + this.radius + vx < StdDraw.mouseX() + .08 ||
//                this.startX - this.radius + vx < StdDraw.mouseX() + .08
//                && this.startX - this.radius + vx > StdDraw.mouseX() - .08;
//
//        if ((touchTop || touchBottom) && touchInRange) {
//            vy = -vy;
//        }

    }

    public void setSize(double size) {
        this.radius = size;
    }

    public void setColor(int r, int g, int b) {
        this.color = new Color(r, g, b);
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

    public static void draw(Ball ball) {
        StdDraw.setPenColor(ball.getColor());
        StdDraw.filledCircle(ball.getX(), ball.getY(), ball.size());
    }
}
