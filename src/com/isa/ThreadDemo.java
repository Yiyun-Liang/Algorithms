package com.isa;

/**
 * Created by isa on 2017-06-10.
 */
public class Thread {
    public static void main(String[] args) {
        Demo A = new Demo("A");
        Demo B = new Demo("B");

        B.start();
        A.start();
    }
}

class Demo implements Runnable {
    private Thread t;
    private String threadName;

    Demo (String name) {
        threadName = name;
    }

    public void run() {
        while (true) {
            System.out.println(threadName);
        }
    }

    public void start() {
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
}