/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.sf.jsharing.components;

/**
 *
 * @author Pratik
 */
public class SavedIPInfo {
    private String ip, name;
    private int port;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
