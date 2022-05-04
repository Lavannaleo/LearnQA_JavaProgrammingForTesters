package ru.stqa.pft.sandbox;

public class Point {
  public double x;
  public double y;

  public Point( double x, double y){
    this.x = x;
    this.y = y;
  }
  public double getX(){
    return this.x;
  }
  public double getY(){
    return this.y;
  }

  public double distance(Point p){
    return Math.sqrt(Math.pow((this.getX() - p.getX()), 2) + Math.pow((this.getY() - p.getY()), 2));
  }

}
