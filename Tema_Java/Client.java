import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

//out.println(outputLine); -> Trimite mesaj
//stdIn.readLine(); ->Citire linie de la tastatura
//in.readLine() ->Primire mesaj

public class Client {
    public static void main(String[] args) {
        String hostName = "localhost";//args[0];
        int portNumber = 10;//Integer.parseInt(args[1]);
        try {
            Socket me = new Socket(hostName, portNumber);
            PrintWriter out = new PrintWriter(me.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(me.getInputStream()));
            BufferedReader stdIn = new BufferedReader(
                    new InputStreamReader(System.in));
            String fromServer, fromUser;
            while ((fromServer = in.readLine()) != null) {
                if (fromServer != null)
                    System.out.println(fromServer);
                System.out.println("Mesajul tau: ");
                fromUser = stdIn.readLine(); //Trimit mesajul la server
                if(fromUser.equals("quit"))
                    break;
                if (fromUser != null)
                    out.println(fromUser);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}