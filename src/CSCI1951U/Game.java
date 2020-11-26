package CSCI1951U;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.*;

public class Game implements Runnable {
    private Color bgColor = new Color(100, 100, 100);
    private ArrayList<Ball> balls;

    public Game(ArrayList<Ball> balls) {
        this.balls = balls;
    }

    public void run() {
        boolean hasAdded = false;
        StdDraw.enableDoubleBuffering();
        while (true) {
            try {
                repaint();
                StdDraw.show();
                if (StdDraw.isKeyPressed(KeyEvent.VK_SHIFT) && StdDraw.isKeyPressed(KeyEvent.VK_A) && !hasAdded) {
                    balls.add(new Ball(balls.size(), balls));
                    hasAdded = true;
                } else {
                    hasAdded = false;
                }
                Thread.sleep(10);
            } catch (InterruptedException err) {
                err.printStackTrace();
            }
        }
    }

    private void setBackground(Color color) {
        StdDraw.setPenColor(color);
        StdDraw.filledSquare(0.0, 0.0, 1.0);
    }

    private void drawPlayer() {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledCircle(StdDraw.mouseX(), StdDraw.mouseY(), .08);
    }

    private void drawBall(Ball ball) {
        StdDraw.setPenColor(ball.getColor());
        StdDraw.filledCircle(ball.getX(), ball.getY(), ball.size());
    }

    private void repaint() {
        setBackground(bgColor);
        drawPlayer();
        for (Ball ball : this.balls) {
            ball.updateBall();
            drawBall(ball);
        }
    }
}
