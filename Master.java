import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Master {
    public static void main(String[] args)throws IOException {
        //hardcode port number
        args = new String[]{"30121"};
        if (args.length != 1) {
            System.err.println("Usage: java Server<port number>");
            System.exit(1);
        }
        int portNumber = Integer.parseInt(args[0]);

        //create socket connection between slave and server
        try (
                ServerSocket serverSocket = new ServerSocket(portNumber);
                Socket slaveA = serverSocket.accept();
                Socket slaveB = serverSocket.accept();
                PrintWriter writeToSlaveA = new PrintWriter(slaveA.getOutputStream(), true);
                PrintWriter writeToSlaveB = new PrintWriter(slaveB.getOutputStream(), true);
                BufferedReader readFromSlaveA = new BufferedReader(new InputStreamReader(slaveA.getInputStream()));
                BufferedReader readFromSlaveB = new BufferedReader(new InputStreamReader(slaveB.getInputStream()));
        ) {

        }

        catch (IOException e){
            System.out.println("Exception caught when trying to listen on port " + portNumber
                    + " or listening for a connection.");
            System.out.println(e.getMessage());
        }
    }
}
