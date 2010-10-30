/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.sf.jsharing.components.threads;

/**
 *
 * @author Pratik
 */
public class UninterruptibleThread extends MyThread {
    public UninterruptibleThread(Runnable target, String name) {
        super(target, name);
    }
}
