/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.projecty;

import java.util.ArrayList;

/**
 *
 * @author Mbuud
 */

class Point {

    public double x, y;

    public Point() {

    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;

    }
}

public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         ArrayList<Point> points = new ArrayList();
        Point pointA = new Point(2, 3);
        System.out.println(pointA.x);
    }
    
}
