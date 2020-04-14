package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

public class Mesh {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";

    private int sizeX, sizeY;
    private ArrayList wallArray;
    private Point actualPosition;
    private Point finalPosition;
    private int[][] map;

    public Mesh(int sizeX, int sizeY, ArrayList wallArray, Point finalPoint, Point startingPoint) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.wallArray=wallArray;
        map=new int[sizeX][sizeY];
        createWallsAndStuff(finalPoint, startingPoint);
        finalPosition = finalPoint;
        actualPosition = startingPoint;
    }

    private void createWallsAndStuff(Point finalPoint, Point startingPoint){
        String toConcatenate;
        for(int i=0; i<sizeX; i++){
            for(int j=0; j<sizeY; j++) {
                toConcatenate=String.valueOf(i)+","+String.valueOf(j);
                if(wallArray.contains(toConcatenate)){
                    map[i][j]=1;
                }
            }
        }
        map[finalPoint.getX()][finalPoint.getY()]=2;
        map[startingPoint.getX()][startingPoint.getY()]=3;
    }

    public boolean checkIfNotException(Point currentState){
        boolean inBoundsX = (currentState.getX() >= 0) && (currentState.getX() < sizeX);
        boolean inBoundsY = (currentState.getY() >= 0) && (currentState.getY() < sizeY);

        return inBoundsX && inBoundsY ? true : false;
    }

    public void printMap(){
        for(int i=0; i<sizeX; i++){
            for(int j=0; j<sizeY; j++){
                if(map[i][j]==1)
                    System.out.print("["+ANSI_RED+"X"+ANSI_RESET+"]");
                else if (i==actualPosition.getX() && j==actualPosition.getY() || map[i][j]==2)
                    System.out.print("["+ANSI_GREEN+"O"+ANSI_RESET+"]");
                else if (map[i][j]==0)
                    System.out.print("["+ANSI_RESET+"_"+ANSI_RESET+"]");
            }
            System.out.println();
        }
    }

    public void drawRoad(ArrayList<Point> road){
        int[][] mapDraw = new int[sizeX][sizeY];

        for(Point point: road){
            mapDraw[point.getX()][point.getY()]=5;
        }

        for(int i=0; i<sizeX; i++){
            for(int j=0; j<sizeY; j++){
                if(mapDraw[i][j]==5)
                    System.out.print("["+ANSI_YELLOW+"O"+ANSI_RESET+"]");
                else if(map[i][j]==1)
                    System.out.print("["+ANSI_RED+"X"+ANSI_RESET+"]");
                else if (mapDraw[i][j]==0)
                    System.out.print("["+ANSI_RESET+"_"+ANSI_RESET+"]");
            }
            System.out.println();
        }
    }


    public Point getFinalPosition() {
        return finalPosition;
    }

    public void setFinalPosition(Point finalPosition) {
        this.finalPosition = finalPosition;
    }

    public Point getActualPosition() {
        return actualPosition;
    }

    public void setActualPosition(Point actualPosition) {
        this.map[this.actualPosition.getX()][this.actualPosition.getY()]=0;
        this.actualPosition = actualPosition;
    }

    public int[][] getMap() {
        return map;
    }

    public void setMap(int[][] map) {
        this.map = map;
    }

    public int getSizeX() {
        return sizeX;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    public ArrayList getWallArray() {
        return wallArray;
    }

    public void setWallArray(ArrayList wallArray) {
        this.wallArray = wallArray;
    }
}
