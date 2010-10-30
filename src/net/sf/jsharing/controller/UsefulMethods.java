/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.sf.jsharing.controller;

import net.sf.jsharing.components.TransferrableObject;

/**
 *
 * @author Pratik
 */
public class UsefulMethods {
    public static int DOWNLOAD_FILES = 1, PROCESS_TRANSFERRABLE_OBJECT = 2;


    /**
     * This method will return the byte array of the <b>IP Address</b><br/>
     * given in String form.
     * @param ipAddress
     * @return
     */
    public static byte[] getConvertedBytes(String ipAddress){
        return getConvertedBytes(getConvertedIntegers(ipAddress));
    }

    /**
     * This method will return the byte array of the<br/>
     * IP Address given in the integer array form.
     * @param intAddress
     * @return
     */
    public static byte[] getConvertedBytes(int[] intAddress){
        byte[] convertedAddress=null;

        for(int i=0;i<intAddress.length;i++)
            convertedAddress[i]=(byte)intAddress[i];

        return convertedAddress;
    }

    /**
     * This method will return the integer array of the <b>IP Address</b><br/>
     * given in String form.
     * @param ipAddress This parameter will contain data in the form "127.0.0.1"
     * @return
     */
    public static int[] getConvertedIntegers(String ipAddress){
        int[] convertedAddress=null;

        java.util.Scanner stringScanner=new java.util.Scanner(ipAddress);
        stringScanner.useDelimiter("\\.");

        if(isCorrectAddress()){
            int i=0;
            convertedAddress=new int[4];
            while(stringScanner.hasNextInt())
                convertedAddress[i++]=stringScanner.nextInt();
        }

        return convertedAddress;
    }

    /**
     * This method will return the integer array of the<br/>
     * IP Address given in the byte array form.
     * @param intAddress
     * @return
     */
    public static int[] getConvertedIntegers(byte[] byteAddress){
        int[] convertedIntegers=null;

        for(int i=0;i<4;i++)//convert the byte address to int address by masking it with 255
            convertedIntegers[i]=byteAddress[i] & 255;

        return convertedIntegers;
    }

    public static boolean isCorrectAddress(){

        return true;
    }
}
