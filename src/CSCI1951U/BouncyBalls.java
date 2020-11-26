package CSCI1951U;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

public class BouncyBalls {
    private static final int WINDOW_SIZE = 960;
    private static final double SCALE = 1.0;
    private static ArrayList<Ball> balls = new ArrayList<>();

    public static void initialize() {
        StdDraw.setCanvasSize(WINDOW_SIZE,WINDOW_SIZE);
        StdDraw.setXscale(-SCALE, SCALE);
        StdDraw.setYscale(-SCALE, SCALE);
        Ball ball1 = new Ball(balls.size(), balls);
        Ball ball2 = new Ball(balls.size(), balls);
        balls.add(ball1);
        balls.add(ball2);
        StdDraw.setPenRadius();
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.text(0, 0, "Press s to start");
        StdDraw.text(0, -.1, "Shift + a to add balls");
        while (!StdDraw.hasNextKeyTyped()) {
            // Wait for keypress
        }
        char c = StdDraw.nextKeyTyped();
        if (c == 's') {
            Game game = new Game(balls);
            Thread thread = new Thread(game);
            thread.start();
        }
    }

    public static void main(String[] args) {
        initialize();
    }
}
