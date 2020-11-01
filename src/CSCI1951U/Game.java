package CSCI1951U;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.*;

public class Game {
    private static final int WINDOW_SIZE = 960;
    private static final double SCALE = 1.0;
    private static Color bgColor = new Color(100, 100, 100);
    private static Set<Ball> balls = new HashSet<Ball>();
    private Game() {
    }

    public static void start() {
        StdDraw.setCanvasSize(WINDOW_SIZE,WINDOW_SIZE);
        StdDraw.setXscale(-SCALE, SCALE);
        StdDraw.setYscale(-SCALE, SCALE);
        balls.add(new Ball(balls.size()));
        balls.add(new Ball(balls.size()));
        boolean hasAdded = false;
//        StdDraw.enableDoubleBuffering();
        while (true) {
            ballCollide();
            if (StdDraw.isKeyPressed(KeyEvent.VK_SHIFT) && StdDraw.isKeyPressed(KeyEvent.VK_A) && !hasAdded) {
                balls.add(new Ball(balls.size()));
                hasAdded = true;
            } else {
                hasAdded = false;
            }

            repaint();
        }
    }

    private static void setBackground(Color color) {
        StdDraw.setPenColor(color);
        StdDraw.filledSquare(0.0, 0.0, 1.0);
    }

    private static void updateBallDirections() {
        for (Ball ball : balls) {
            ball.checkWall(ball.getVX(), ball.getVY());
            ball.checkCollideMouse();
        }

        ballCollide();
    }

    private static void ballCollide() {
        for (Ball p : balls) {
            for (Ball q : balls) {
                if (p.id() != q.id()) {
                    Ball.checkCollide(p, q);
                }
            }
        }
    }

    private static void updateBallStarters() {
        for (Ball ball: balls) {
//            ball.setStart(ball.getVX(), ball.getVY());
            Ball.draw(ball);
        }
    }

    private static void drawPlayer() {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledCircle(StdDraw.mouseX(), StdDraw.mouseY(), .08);
//        StdDraw.filledRectangle(StdDraw.mouseX(), StdDraw.mouseY(), .08, .01);
    }

    private static void repaint() {
//        StdDraw.clear(bgColor);
        setBackground(bgColor);
        drawPlayer();
        updateBallDirections();
        updateBallStarters();
        StdDraw.show(20);
//        StdDraw.pause(speed);
    }
}
