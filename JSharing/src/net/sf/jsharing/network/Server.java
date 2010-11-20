package net.sf.jsharing.network;

import java.io.IOException;
import java.net.ServerSocket;
import pratikabu.threading.AbstractThread;
import pratikabu.threading.implementation.InterruptibleThread;

/**
 *
 * @author Pratik
 */
public class Server {
    private ServerSocket serverSocket;
    private boolean continueListening = true;
    private int portNumber;
    private int state;
    private NetworkActivity na;

    public static final int RUNNING = 1, STOPPED = 2, EXCEPTION_START = 3, EXCEPTION_STOP = 4;

    public Server(NetworkActivity na) {
        if(na != null)
            this.na = na;
        else
            this.na = new DefaultClientActivity();
    }

    /**
     * This method will try to start the server on the specified port number.
     * @return true if server started else false.
     */
    public void startServer() throws IOException {
        na.message("Instantiating Server with port number.");
        serverSocket = new ServerSocket(portNumber);
        na.message("Starting AcceptClient Module.");
        continueListening = true;
        startAcceptingClient();
    }

    /**
     * This method will shutdown the server.
     * Which includes the removing of the ServerSocket from the port number.
     * @return true if server shutdown successfully else false.
     */
    public void shutdownServer() throws IOException {
        continueListening = false;
        serverSocket.close();
    }

    /**
     * This method will iterate and accepts client connections until the server is shutdown.
     */
    private void startAcceptingClient() {
        AbstractThread t = new InterruptibleThread(new Runnable() {
            public void run() {
                while (continueListening) {
                    try {
                        na.message("Waiting for client to connect.");
                        new ClientHandler(serverSocket.accept(), na).startHandling();
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

    public void setState(int state) {
        this.state = state;
    }

    public int getPortNumber() {
        return portNumber;
    }

    public void setPortNumber(int portNumber) {
        this.portNumber = portNumber;
    }
}