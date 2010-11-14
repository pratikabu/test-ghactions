/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.sf.jsharing.network;

/**
 *
 * @author Pratik
 */
public interface NetworkActivity {
    void message(String msg);
    void processingFile(String fileName);
}
