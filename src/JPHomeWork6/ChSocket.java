package JPHomeWork6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ChSocket {

    private final Socket socket;
    private Thread sendT;
    private Thread readT;

    public ChSocket(Socket socket){
        this.socket = socket;
    }

    public void ChStart(){
        sendT = new Thread(new Runnable() {
            @Override
            public void run() {
                try (Scanner sc = new Scanner(System.in);
                     DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream())) {
                    do {
                        System.out.print("Введите сообщение: ");
                        String msg = sc.nextLine();
                        outputStream.writeUTF(msg);
                    } while (true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        readT = new Thread(new Runnable() {
            @Override
            public void run() {
                try (DataInputStream inputStream = new DataInputStream(socket.getInputStream())){
                    while (true){
                        System.out.printf("%nНовое сообщение - %s%n",inputStream.readUTF());
                        System.out.print("Введите сообщение: ");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        sendT.start();
        readT.start();

    }

    public void ChJoin(){
        try {
            sendT.join();
            readT.join();
        } catch (InterruptedException ex){
            ex.printStackTrace();
        }
    }
}
