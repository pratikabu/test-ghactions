package net.sf.jsharing.poc;

import java.io.IOException;
import java.net.ServerSocket;

/**
 *
 * @author Pratik
 */
public class Server {
    private ServerSocket serverSocket;

    private boolean continueListening = true;

    private int portNumber;

    public Server(int portNumber){
        this.portNumber = portNumber;
    }

    /**
     * This method will try to start the server on the specified port number.
     * @return true if server started else false.
     */
    public boolean startServer() {
        try {
            serverSocket = new ServerSocket(portNumber);
            startAcceptingClient();
            return true;
        } catch (IOException e) {
            System.out.println("Error starting the Server.\n"
                    + "Could not listen on port: " + portNumber);
            System.out.println("Error Message: " + e.getMessage());
            return false;
        }
    }

    /**
     * This method will iterate and accepts client connections until the server is shutdown.
     */
    private void startAcceptingClient() {
        Thread t = new Thread(new Runnable() {
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
        });

        t.start();
    }

    /**
     * This method will shutdown the server.
     * Which includes the removing of the ServerSocket from the port number.
     * @return true if server shutdown successfully else false.
     */
    public boolean shutdownServer() {
        try{
            continueListening = false;
            serverSocket.close();
            return true;
        } catch(IOException e) {
            System.out.println("Error shutting down the Server.");
            System.out.println("Error Message: " + e.getMessage());
            return false;
        }
    }
}