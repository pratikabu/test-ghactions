/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.sf.jsharing.components.threads;

import java.util.ArrayList;

/**
 *
 * @author Pratik
 */
public class ThreadManager {
    private static ArrayList<MyThread> threads = new ArrayList<MyThread>();

    public static void add(MyThread mt) {
        threads.add(mt);
    }

    public static ArrayList<MyThread> getAllThreads() {
        return threads;
    }

    public static ArrayList<MyThread> getAllRunningThreads() {
        ArrayList<MyThread> ts = new ArrayList<MyThread>();

        for(MyThread mt : threads)
            if(mt.isAlive())
                ts.add(mt);
        return ts;
    }

    public static ArrayList<MyThread> getAllRunningUninterruptibleThreads() {
        ArrayList<MyThread> ts = new ArrayList<MyThread>();

        for(MyThread mt : threads)
            if((mt instanceof UninterruptibleThread) && mt.isAlive())
                ts.add(mt);
        return ts;
    }

    public static ArrayList<MyThread> getAllRunningInterruptibleThreads() {
        ArrayList<MyThread> ts = new ArrayList<MyThread>();

        for(MyThread mt : threads)
            if((mt instanceof InterruptibleThread) && mt.isAlive())
                ts.add(mt);
        return ts;
    }
}
