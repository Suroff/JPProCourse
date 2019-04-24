package JPHomeWork6;

import java.io.IOException;
import java.net.Socket;


public class ChEchoClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost",7777)){
            ChSocket chSocket = new ChSocket(socket);
            chSocket.ChStart();
            chSocket.ChJoin();
        } catch (IOException e) {

            e.printStackTrace();
        }

    }
}
