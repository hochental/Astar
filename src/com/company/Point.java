package com.company;

public class Point {
    private int x;
    private int y;

    private double costs;
    private int combinedCosts;

    private Point parentalPoint;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        parentalPoint=null;
        costs=0;
    }

    public Point(int x, int y, Point parentalPoint, int combinedCosts) {
        this.x = x;
        this.y = y;
        this.parentalPoint=parentalPoint;
        this.combinedCosts=combinedCosts;
    }

    public double getCosts() {
        return costs;
    }

    public void setCosts(double costs) {
        this.costs = costs;
    }

    public Point getParentalPoint() {
        return parentalPoint;
    }

    public void setParentalPoint(Point parentalPoint) {
        this.parentalPoint = parentalPoint;
    }

    public int getCombinedCosts() {
        return combinedCosts;
    }

    public void setCombinedCosts(int combinedCosts) {
        this.combinedCosts = combinedCosts;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                ", costs=" + costs +
                ", combinedCosts=" + combinedCosts +
                ", parentalPoint=" + parentalPoint +
                '}';
    }
}
