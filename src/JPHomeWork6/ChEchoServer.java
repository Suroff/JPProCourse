package JPHomeWork6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChEchoServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(7777)){
            while (true){
                System.out.println("Сервер ожидает подключения");
                Socket socket = serverSocket.accept();
                System.out.println("Подключился клиент");
                ChSocket chSocket = new ChSocket(socket);
                chSocket.ChStart();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
