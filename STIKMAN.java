import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class StikmanGame extends JPanel implements ActionListener, KeyListener 

    private Timer timer;
    private int stikmanX, stikmanY, stikmanWidth, stikmanHeight;
    private ArrayList<Rectangle> obstacles;
    private int obstacleWidth, obstacleHeight;
    private int score;
    private boolean gameOver;

    public StikmanGame() {
        // Set initial position and size for stikman
        stikmanWidth = 40;
        stikmanHeight = 60;
        stikmanX = 200;
        stikmanY = 300;

        // Obstacle settings
        obstacles = new ArrayList<>();
        obstacleWidth = 50;
        obstacleHeight = 30;

        // Game settings
        score = 0;
        gameOver = false;

        // Timer for game loop
        timer = new Timer(1000 / 60, this); // 60 FPS
        timer.start();

        // Key listener for movement control
        this.setFocusable(true);
        this.addKeyListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameOver) {
            moveObstacles();
            checkCollisions();
            repaint();
        }
    }

    private void moveObstacles() {
        Random rand = new Random();

        // Add new obstacles every 60 frames
        if (rand.nextInt(100) < 3) {
            int xPosition = rand.nextInt(getWidth() - obstacleWidth);
            obstacles.add(new Rectangle(xPosition, 0, obstacleWidth, obstacleHeight));
        }

        // Move existing obstacles down
        ArrayList<Rectangle> toRemove = new ArrayList<>();
        for (Rectangle obstacle : obstacles) {
            obstacle.y += 5; // Move down
            if (obstacle.y > getHeight()) {
                toRemove.add(obstacle);
                score++; // Increase score if obstacle passed
            }
        }

        // Remove obstacles that have moved off-screen
        obstacles.removeAll(toRemove);
    }

    private void checkCollisions() {
        Rectangle stikmanRect = new Rectangle(stikmanX, stikmanY, stikmanWidth, stikmanHeight);

        // Check for collisions with obstacles
        for (Rectangle obstacle : obstacles) {
            if (stikmanRect.intersects(obstacle)) {
                gameOver = true;
                timer.stop(); // Stop the game timer
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the background
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, getWidth(), getHeight());

        // Draw the stikman
        g.setColor(Color.RED);
        g.fillRect(stikmanX, stikmanY, stikmanWidth, stikmanHeight);

        // Draw obstacles
        g.setColor(Color.BLACK);
        for (Rectangle obstacle : obstacles) {
            g.fillRect(obstacle.x, obstacle.y, obstacle.width, obstacle.height);
        }

        // Draw score
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Score: " + score, 10, 30);

        // Draw game over message
        if (gameOver) {
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.drawString("Game Over!", getWidth() / 2 - 90, getHeight() / 2);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) 
        if (gameOver) return;

        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_LEFT && stikmanX > 0) {
            stikmanX -= 10; // Move left
        } else if (keyCode == KeyEvent.VK_RIGHT && sti)
