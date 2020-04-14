package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

public class Astar {

    private Mesh mesh;
    private ArrayList <Point> openList;
    private ArrayList <Point> closedList;

    public Astar(Mesh mesh) {
        this.mesh=mesh;
        openList = new ArrayList<Point>();
        closedList = new ArrayList<Point>();

        mesh.getActualPosition().setCosts(manhattanDistance(mesh.getActualPosition(), mesh.getFinalPosition()));
    }

    public double euclideanDistance(Point start, Point finish){
        return Math.sqrt(Math.pow(start.getX()-start.getY(),2)+Math.pow(finish.getX()-finish.getY(),2));
    }

    public double manhattanDistance(Point start, Point finish){
        return Math.abs(start.getX()-finish.getX())+Math.abs(start.getY()-finish.getY());
    }

    public void linkNeighbours(){
        int loopFirst=mesh.getActualPosition().getX();
        int loopsecount=mesh.getActualPosition().getY();
        boolean flag=true;

        closedList.add(mesh.getActualPosition());
        openList.remove(mesh.getActualPosition());

        for(int i=loopFirst-1; i<=loopFirst+1; i++){
            for(int j=loopsecount-1; j<=loopsecount+1; j++){
                flag=true;
                if(mesh.checkIfNotException(new Point(i, j)) && mesh.getMap()[i][j]!=1) {
                            for(Point point: closedList){
                                if(point.getY()==j && point.getX()==i){
                                    flag=false;
                                }
                            }
                            if(flag)
                                openList.add((new Point(i,j, mesh.getActualPosition(), 0)));
                    }
            }
        }
    }

    public void calc(){
        int lowestCost= (int) manhattanDistance(new Point(0, 0), mesh.getFinalPosition());
        Point lowestPoint = new Point(0,0);
        for(Point pointToCalc: openList) {
            if(manhattanDistance(pointToCalc, mesh.getFinalPosition())<=lowestCost){
                lowestCost = (int) (manhattanDistance(pointToCalc, mesh.getFinalPosition()));
                lowestPoint=pointToCalc;
            }
        }
        mesh.setActualPosition(lowestPoint);
    }


    public void mainloop() throws InterruptedException {
        do{
            linkNeighbours();
            calc();
        }while(mesh.getActualPosition().getY()!=mesh.getFinalPosition().getY() || mesh.getActualPosition().getX()!=mesh.getFinalPosition().getX());
        mesh.drawRoad(closedList);

    }


    public ArrayList<Point> getOpenList() {
        return openList;
    }

    public void setOpenList(ArrayList<Point> openList) {
        this.openList = openList;
    }

    public ArrayList<Point> getClosedList() {
        return closedList;
    }

    public void setClosedList(ArrayList<Point> closedList) {
        this.closedList = closedList;
    }
}
