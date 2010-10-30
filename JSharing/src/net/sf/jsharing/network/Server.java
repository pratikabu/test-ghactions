package net.sf.jsharing.network;

import java.io.IOException;
import java.net.ServerSocket;
import net.sf.jsharing.components.threads.InterruptibleThread;
import net.sf.jsharing.components.threads.MyThread;

/**
 *
 * @author Pratik
 */
public class Server {
    private ServerSocket serverSocket;
    private boolean continueListening = true;
    private int portNumber;
    private int state;

    public static final int RUNNING = 1, STOPPED = 2, EXCEPTION_START = 3, EXCEPTION_STOP = 4;

    /**
     * This method will try to start the server on the specified port number.
     * @return true if server started else false.
     */
    public void startServer() {
        try {
            serverSocket = new ServerSocket(portNumber);
            startAcceptingClient();
            state = RUNNING;
        } catch (IOException e) {
            System.out.println("Error starting the Server.\n"
                    + "Could not listen on port: " + portNumber);
            System.out.println("Error Message: " + e.getMessage());
            state = EXCEPTION_START;
        }
    }

    /**
     * This method will shutdown the server.
     * Which includes the removing of the ServerSocket from the port number.
     * @return true if server shutdown successfully else false.
     */
    public void shutdownServer() {
        try{
            continueListening = false;
            serverSocket.close();
            state = STOPPED;
        } catch(IOException e) {
            System.out.println("Error shutting down the Server.");
            System.out.println("Error Message: " + e.getMessage());
            state = EXCEPTION_STOP;
        }
    }

    /**
     * This method will iterate and accepts client connections until the server is shutdown.
     */
    private void startAcceptingClient() {
        MyThread t = new InterruptibleThread(new Runnable() {
            public void run() {
                while (continueListening) {
                    try {
                        new ClientHandler(serverSocket.accept()).startHandling();
                    } catch (IOException e) {
                        System.out.println("Error connecting with client.");
                        System.out.println("Error Message: " + e.getMessage());
                    }
                }
            }
        }, "Client Listening Thread");

        t.start();
    }

    public boolean isRunning() {
        return state == RUNNING;
    }

    public boolean isStopped() {
        return state == STOPPED;
    }

    public int getState() {
        return state;
    }

    public int getPortNumber() {
        return portNumber;
    }

    public void setPortNumber(int portNumber) {
        this.portNumber = portNumber;
    }
}