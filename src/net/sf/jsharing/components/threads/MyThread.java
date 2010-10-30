/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.sf.jsharing.components.threads;

/**
 * This class is to create a group of threads.
 * @author Pratik
 */
public abstract class MyThread extends Thread {
    public MyThread(Runnable target, String name) {
        super(target, name);
    }

    @Override
    public synchronized void start() {
        ThreadManager.add(this);
        super.start();
    }
}
