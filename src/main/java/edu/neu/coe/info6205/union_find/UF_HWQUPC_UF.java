/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.coe.info6205.union_find;


import java.util.Random;
import java.util.Scanner;
import edu.neu.coe.info6205.union_find.UF_HWQUPC;

/**
 *
 * @author Air
 */
public class UF_HWQUPC_UF {
    public static int count(int n) {
        Random random = new Random();
        int l, r;
        UF_HWQUPC entity = new UF_HWQUPC(n, true);
        int count = 0;
        while (entity.components() > 1) {
            l = random.nextInt(n);
            r = l;
            while (r == l) {
                r = random.nextInt(n);
            }
            if (!entity.isConnected(l, r)) {
                entity.connect(l, r);
            }
            count++;
        }
        return count;
    }
    
    public static void main(String[] args) {
        //System.out.println("Please enter n: ");
        //Scanner scan = new Scanner(System.in);
        //int n = scan.nextInt();
        int n = 100;
        for (int i = 0; i < 5; i++) {
            System.out.println(n + " Sites Total Connections: " + count(n));
            n *= 10;
        }
        
    }
}
