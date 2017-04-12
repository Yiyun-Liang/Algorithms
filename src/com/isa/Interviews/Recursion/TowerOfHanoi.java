package com.isa.Interviews.Recursion;

/**
 * Created by isa on 2017-04-12.
 */
public class TowerOfHanoi {
    public static void main(String[] args) {
        int nDisks = 3;
        doTowers(nDisks, 'A', 'B', 'C');
    }
    public static void doTowers(int n, char from, char inter, char to) {
        if (n == 1) {
            System.out.println("Disk 1 from " + from + " to " + to);
        } else {
            doTowers(n - 1, from, to, inter);  // placing n-1 disks on inter in order
            System.out.println("Disk " + n + " from " + from + " to " + to); // move nth disk to dest
            doTowers(n - 1, inter, from, to);  // move those n-1 disks on top of nth disk on dest
        }
    }
}
