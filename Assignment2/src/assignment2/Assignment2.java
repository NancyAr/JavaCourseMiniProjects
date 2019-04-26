/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

/**
 *
 * @author NancyAlarabawy
 */
import java.util.Scanner;

public class Assignment2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter first matrix's row size: ");
        int r1 = input.nextInt();
        System.out.print("Enter first matrix's column size: ");
        int c1 = input.nextInt();

        System.out.print("Enter second matrix's row size: ");
        int r2 = input.nextInt();
        System.out.print("Enter second matrix's column size: ");
        int c2 = input.nextInt();

        System.out.println("Matrix A is " + r1 + "x" + c1);
        System.out.println("and Matrix B is " + r2 + "x" + c2);

        int[][] A = new int[r1][c1];
        int[][] B = new int[r2][c2];

        System.out.println("Enter Matrix A Data: ");

        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c1; j++) {
                A[i][j] = input.nextInt();
            }
        }

        System.out.println("Enter Matrix B Data: ");

        for (int i = 0; i < r2; i++) {
            for (int j = 0; j < c2; j++) {
                B[i][j] = input.nextInt();
            }
        }

        int[][] C = new int[r1][c2];
        Thread t1 = new Thread(new Multiply(A, B, C, r1, r2, c1, c2));
        t1.setName("1");
        Thread t2 = new Thread(new Multiply(A, B, C, r1, r2, c1, c2));
        t2.setName("2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Product of two matrices is: ");
        for (int[] row : C) {
            for (int column : row) {
                System.out.print(column + "    ");
            }
            System.out.println();
        }
    }

}
