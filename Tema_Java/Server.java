import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Server {
    private static ArrayList<Human> persons = new ArrayList<Human>();

    public static void main(String args[]) {
        //int port = Integer.parseInt(args[0]);
        int port = 10;
        try {
            ServerSocket server = new ServerSocket(port);
            Socket client = server.accept();
            PrintWriter out =
                    new PrintWriter(client.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(client.getInputStream()));
            BufferedReader stdIn = new BufferedReader(
                    new InputStreamReader(System.in));
            out.println("Server: Conexiune realizata");
            String fromServer=new String();
            String fromUser;
            while ((fromUser = in.readLine()) != null) {
                if(fromUser.equals("quit"))
                    break;
                System.out.println("Client: " + fromUser);

                int response=parseResponse(fromUser);
                switch (response){
                    case 1:
                        fromServer = "Student adaugat cu succes.";
                        break;
                    case 2:
                        fromServer = "Profesor adaugat cu succes.";
                        break;
                    case 3:
                        fromServer = uniteHumans();
                        break;
                    default:
                        fromServer = "Inregistrare gresita. Incearca din nou";
                        break;
                }
                if (fromServer != null)
                    out.println(fromServer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String uniteHumans(){
        String text=new String("");
        for (Human person: persons) {
            text+=person.toString();
            text+="\n";
        }
        text+="\nEnd of list\n";
        return text;
    }
    private static int parseResponse(String text){
        if(text.equals("get")){
            return 3;
        }

        String[] splited = text.split("\\s+");
        if(splited.length != 6)
            return 0;
        if(splited[0].equals("Student")){
            Human student=new Student(splited[1],splited[2],splited[3],Integer.valueOf(splited[4]),Integer.valueOf(splited[5]));
            persons.add((student));
            return 1;
        }
        if(splited[0].equals("Profesor")){
            Human profesor=new Profesor(splited[1],splited[2],splited[3],Integer.valueOf(splited[4]),splited[5]);
            persons.add((profesor));
            return 2;
        }
        return 0;
    }
}