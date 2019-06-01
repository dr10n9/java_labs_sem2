package com.lab7.task2;

public class Main {
    public static Object Lock1 = new Object();
    public static Object Lock2 = new Object();
    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();

        t1.start();
        t2.start();

    }
    private static class Thread1 extends Thread {
        private Resource resource;
        public Thread1() {
            new Thread(this, "thread1");
        }
        public void run() {
            //deadlock
//            synchronized (Lock1) {
//                System.out.println("Thread 1: Holding lock 1...");
//
//                try { Thread.sleep(10); }
//                catch (InterruptedException e) {}
//                System.out.println("Thread 1: Waiting for lock 2...");
//
//                synchronized (Lock2) {
//                    System.out.println("Thread 1: Holding lock 1 & 2...");
//                }
//            }

            //fix
            synchronized (Lock1) {
                System.out.println("Thread 1: Holding lock 1...");

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {}
                System.out.println("Thread 1: Waiting for lock 2...");

                synchronized (Lock2) {
                    System.out.println("Thread 1: Holding lock 1 & 2...");
                }
            }
        }
    }
    private static class Thread2 extends Thread {
        private Resource resource;
        public Thread2() {
            new Thread(this, "thread1");
        }
        public void run() {
            // deadlock
//            synchronized (Lock2) {
//                System.out.println("Thread 2: Holding lock 2...");
//
//                try { Thread.sleep(10); }
//                catch (InterruptedException e) {}
//                System.out.println("Thread 2: Waiting for lock 1...");
//
//                synchronized (Lock1) {
//                    System.out.println("Thread 2: Holding lock 1 & 2...");
//                }
//            }

            // fix
            synchronized (Lock1) {
                System.out.println("Thread 2: Holding lock 1...");

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {}
                System.out.println("Thread 2: Waiting for lock 2...");

                synchronized (Lock2) {
                    System.out.println("Thread 2: Holding lock 1 & 2...");
                }
            }
        }
    }
}

class Thread1 extends Thread {
    private Resource resource;
    public Thread1(Resource r) {
        resource = r;
        new Thread(this, "thread1");
    }
    public void run() {
        while(true) {

        }
    }
}
class Thread2 extends Thread {
    private Resource resource;
    public Thread2(Resource r) {
        resource = r;
        new Thread(this, "thread1");
    }
    public void run() {
        while(true) {

        }
    }
}

class Resource {}