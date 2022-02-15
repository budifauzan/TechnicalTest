/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectx;

import java.util.ArrayList;

/**
 *
 * @author Mbuud
 */
public class MainClass {

    public static void main(String[] args) {
        String stringArr[] = {"A", "B", "C", "D", "A", "A", "B", "C", "B"};
        ArrayList tempA = new ArrayList();
        ArrayList tempB = new ArrayList();
        ArrayList tempC = new ArrayList();
        for (int i = 0; i < stringArr.length; i++) {
            //Apabila huruf belum ada di tempA, maka ditambahkan ke tempA (huruf belum berulang)
            if (!tempA.contains(stringArr[i])) {
                tempA.add(stringArr[i]);
            //Apabila huruf belum ada di tempB, maka ditambahkan ke tempB (huruf sudah berulang 1x)
            } else if (!tempB.contains(stringArr[i])) {
                tempB.add(stringArr[i]);
            //Apabila huruf belum ada di tempC, maka ditambahkan ke tempC (huruf sudah berulang 2x)
            } else if (!tempC.contains(stringArr[i])) {
                tempC.add(stringArr[i]);
            }
        }
        //Print huruf yang pertama berulang 2x
        System.out.println(tempC.get(0));
    }
}
