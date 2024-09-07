package com.chrispatrick.threebodysimulation;

public class Body {
    public double x, y;
    public double vx, vy;
    public double mass;
    public double fx, fy;
    public boolean isActive;

    public Body(double x, double y, double vx, double vy, double mass) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.mass = mass;
        this.isActive = true;
    }

    public void resetForce() {
        fx = 0.0;
        fy = 0.0;
    }

    public void addForce(Body other) {
        double G = 6.67430e-11;
        double dx = other.x - this.x;
        double dy = other.y - this.y;
        double distSquared = dx * dx + dy * dy;
        double dist = Math.sqrt(distSquared);

        if (distSquared == 0) return;

        double force = (G * this.mass * other.mass) / distSquared;
        this.fx += force * dx / dist;
        this.fy += force * dy / dist;
    }
}
