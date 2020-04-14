package com.company;

import java.util.ArrayList;

public class Main {



    public static void main(String[] args) throws InterruptedException {
    ArrayList<String> arrayList = new ArrayList<>();
    arrayList.add("1,3");
    arrayList.add("2,3");
    arrayList.add("3,3");
    arrayList.add("4,3");
    arrayList.add("5,3");
    arrayList.add("6,3");
    arrayList.add("7,3");
    arrayList.add("8,3");
    arrayList.add("9,3");
    arrayList.add("8,5");
    arrayList.add("7,5");
    arrayList.add("6,5");
    arrayList.add("5,5");
    arrayList.add("4,5");
    arrayList.add("3,5");
    arrayList.add("2,5");
    arrayList.add("1,5");


    Mesh mesh = new Mesh(10,10, arrayList, new Point(9,9), new Point(5,1));
        System.out.println("Before: ");
    mesh.printMap();
        System.out.println("After: ");
    Astar astar=new Astar(mesh);

    astar.mainloop();

    }
}
