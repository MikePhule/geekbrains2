import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    private static final int SERVER_PORT = 18000;
    private static Boolean isRunning = true;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
            Socket socket = serverSocket.accept();

            Thread input = new Thread(() -> {
                try (DataInputStream inputStream = new DataInputStream(socket.getInputStream())) {
                    while (isRunning) {
                        String msg = inputStream.readUTF();
                        if (msg.equals("/end")) {
                            isRunning = false;
//                            inputStream.close();
                            break;
                        }
                        System.out.println("Got message: " + msg);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            Thread output = new Thread(() -> {
                try {
                    BufferedReader consoleScanner = new BufferedReader(new InputStreamReader(System.in));
                    DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
                    while (isRunning) {
//                        System.out.print("Enter your message: ");
                        String msg = consoleScanner.readLine();
                        outputStream.writeUTF(msg);
                        if (msg.equals("/end")) {
                            isRunning = false;
                        }
                    }
                    outputStream.close();
                    consoleScanner.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            input.start();
            output.start();

            input.join();
            output.join();

            socket.close();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
