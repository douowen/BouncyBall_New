package CSCI1951U;

import java.awt.Color;
import java.util.Random;

public class BouncyBalls {

    public static void main(String[] args) {
        Game.start();
    }
    //        StdDraw.setCanvasSize(960,960);
//        StdDraw.setXscale(-1.0, +1.0);
//        StdDraw.setYscale(-1.0, +1.0);
//
//        Color c = new Color(100, 100, 100);

        // x and y movement positions of the ball
//        double rx = .480, ry = .860; // the ball is centered at (rx, ry)
//        double vx = .015, vy = .023;
//
//        double rx2 = .480, ry2 = .860;
//        double vx2 = -.015, vy2 = -.023;

        //Ball ball = new Ball(.480, .860, .015, .023);

        // size of the ball
//        double size = .05;

//        while (true) {
//            // Setting the color of the pen
//            StdDraw.setPenColor(c);
//
//            // Create the square
//            StdDraw.filledSquare(0.0, 0.0, 1.0);
//
//            ball.setDirection(ball.getEndX(), ball.getEndY());
//
//            // Walls collision
////            vx = checkWallCollision(rx, vx, size);
////            vy = checkWallCollision(ry, vy, size);
////            vx2 = checkWallCollision(rx2, vx2, size);
////            vy2 = checkWallCollision(ry2, vy2, size);
//
//
////            if ((Math.abs((rx + size/2) - (rx2 + size/2)) <= size) && (Math.abs((ry + size/2) - (ry2 + size/2)) <= size)) {
////                vx = -vx;
////                vx2 = -vx2;
////                c = randomColor();
////            }
//
//            ball.setStart(ball.getEndX(), ball.getEndY());
////            rx = rx + vx;
////            ry = ry + vy;
////            rx2 = rx2 + vx2;
////            ry2 = ry2 + vy2;
//            Ball.draw(ball);
//
////            StdDraw.setPenColor(StdDraw.BLACK);
////            StdDraw.filledCircle(rx,  ry,  size);
////            StdDraw.filledCircle(rx2,  ry2,  size);
//
//            StdDraw.show(20);
//        }
//    }

//    private static double checkWallCollision(double center, double dir, double size) {
//        if (center - size + dir < -1.0 || center + size + dir > 1.0) dir = -dir;
//        return dir;
//    }
//
//
//    private static Color randomColor() {
//        Random rand = new Random();
//        int r = rand.nextInt(256);
//        int g = rand.nextInt(256);
//        int b = rand.nextInt(256);
//
//        return new Color(r, g, b);
//    }

}
