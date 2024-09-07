package com.chrispatrick.threebodysimulation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SimulationPanel extends JPanel implements ActionListener {
    private final int WIDTH = 160;
    private final int HEIGHT = 160;
    private final double SCALE = 1e9;
    private Timer timer;
    private Body[] bodies;
    private Random random;

    public SimulationPanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        timer = new Timer(16, this);
        random = new Random();
        initializeBodies();
        timer.start();
    }

    private void initializeBodies() {
        bodies = new Body[3];

        for (int i = 0; i < bodies.length; i++) {
            double x = (random.nextDouble() * WIDTH - WIDTH / 2) * SCALE;
            double y = (random.nextDouble() * HEIGHT - HEIGHT / 2) * SCALE;
            double vx = (random.nextDouble() * 2 - 1) * 1e3;
            double vy = (random.nextDouble() * 2 - 1) * 1e3;
            double mass = (random.nextDouble() * 4e30 + 1e30);

            bodies[i] = new Body(x, y, vx, vy, mass);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        updateSimulation();
        repaint();
    }

    private void updateSimulation() {
        double dt = 1e4; 

        for (Body body : bodies) {
            body.resetForce();
            for (Body other : bodies) {
                if (body != other && other.isActive) {
                    body.addForce(other);
                }
            }
        }

        for (Body body : bodies) {
            if (body.isActive) {
                updatePosition(body, dt);
            }
        }

        handleCollisions();
    }

    private void updatePosition(Body body, double dt) {
        body.vx += body.fx / body.mass * dt;
        body.vy += body.fy / body.mass * dt;

        body.x += body.vx * dt;
        body.y += body.vy * dt;
    }

    private void handleCollisions() {
        for (int i = 0; i < bodies.length; i++) {
            for (int j = i + 1; j < bodies.length; j++) {
                if (bodies[i].isActive && bodies[j].isActive && checkCollision(bodies[i], bodies[j])) {
                    mergeBodies(bodies[i], bodies[j]);
                    spawnNewStar();  
                }
            }
        }
    }

    private boolean checkCollision(Body b1, Body b2) {
        double distance = Math.sqrt(Math.pow(b2.x - b1.x, 2) + Math.pow(b2.y - b1.y, 2));
        double combinedRadius = getRadius(b1) + getRadius(b2);
        return distance <= combinedRadius; 
    }

    private void mergeBodies(Body b1, Body b2) {
        double totalMass = b1.mass + b2.mass;

        b1.x = (b1.x * b1.mass + b2.x * b2.mass) / totalMass;
        b1.y = (b1.y * b1.mass + b2.y * b2.mass) / totalMass;

        b1.vx = (b1.vx * b1.mass + b2.vx * b2.mass) / totalMass;
        b1.vy = (b1.vy * b1.mass + b2.vy * b2.mass) / totalMass;

        b1.mass = totalMass;

        b2.isActive = false;
    }

    private void spawnNewStar() {
        for (int i = 0; i < bodies.length; i++) {
            if (!bodies[i].isActive) {
                double x = (random.nextDouble() * WIDTH - WIDTH / 2) * SCALE;
                double y = (random.nextDouble() * HEIGHT - HEIGHT / 2) * SCALE;
                double vx = (random.nextDouble() * 2 - 1) * 1e3;
                double vy = (random.nextDouble() * 2 - 1) * 1e3;
                double mass = (random.nextDouble() * 4e30 + 1e30);

                bodies[i] = new Body(x, y, vx, vy, mass);
                bodies[i].isActive = true;
                break;
            }
        }
    }

    private int getRadius(Body body) {
        return (int) Math.cbrt(body.mass / 1e30) * 10;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        g.setColor(Color.WHITE);
        for (Body body : bodies) {
            if (body.isActive) {
                int x = (int) (WIDTH / 2 + body.x / SCALE);
                int y = (int) (HEIGHT / 2 - body.y / SCALE);
                int size = getRadius(body);
                g.fillOval(x - size / 2, y - size / 2, size, size);
            }
        }
    }
}
