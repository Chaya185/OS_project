import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Slave {
    public static void main(String[] args) throws IOException {
        //hardcode host name and port number
        args = new String[] {"127.0.0.1", "30121"};
        if (args.length != 2){
            System.err.println("Usage: java Client <host name> <port number>");
            System.exit(1);
        }

        String hostName = args[0];
        int portNumber = Integer.parseInt(args[1]);

        //create socket connection between slave and master
        try (
                Socket slaveSocket = new Socket(hostName, portNumber);
                PrintWriter writerToMaster = new PrintWriter(slaveSocket.getOutputStream(), true);
                BufferedReader readFromMaster = new BufferedReader(new InputStreamReader(slaveSocket.getInputStream()));
                //BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        ){

        }

        //catch exceptions
        catch (UnknownHostException e){
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        }
        catch (IOException e){
            System.err.println("Couldn't get I/O for the connection to " + hostName);
            System.exit(1);
        }
    }
}
