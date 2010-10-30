/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.sf.jsharing.components.threads;

/**
 *
 * @author Pratik
 */
public class InterruptibleThread extends MyThread {
    public InterruptibleThread(Runnable target, String name) {
        super(target, name);
    }
}
