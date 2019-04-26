/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

//import java.util.ArrayList;
/**
 *
 * @author NancyAlarabawy
 */
public class Multiply implements Runnable {

    private int[][] _A;
    private int[][] _B;
    private int[][] _C;
    private int r1, r2, c1, c2;

    Multiply(int[][] A, int[][] B, int[][] C, int R1, int R2, int C1, int C2) {
        this._A = A;
        this._B = B;
        this._C = C;
        this.r1 = R1;
        this.r2 = R2;
        this.c1 = C1;
        this.c2 = C2;
    }

    public void run() {

        if (Thread.currentThread().getName().equals("1")) {
            System.out.println("Hello I am thread 1");
            do_work1();
        } else {
            System.out.println("Hello I am thread 2");
            do_work2();
        }

    }

    void do_work1() {
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < java.lang.Math.ceil(c2 / 2); j++) {
                for (int k = 0; k < c1; k++) {
                    _C[i][j] += _A[i][k] * _B[k][j];
                }
                System.out.println("from thread 1 " + _C[i][j]);
            }
        }
    }

    void do_work2() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {

            System.out.println("thread 2 is awaken");
        }
        for (int i = 0; i < r1; i++) {
            for (int j = (c2 / 2); j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    _C[i][j] += _A[i][k] * _B[k][j];

                }
                System.out.println("from thread 2 " + _C[i][j]);
            }
        }
    }

}
