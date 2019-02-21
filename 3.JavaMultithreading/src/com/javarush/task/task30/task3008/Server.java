package com.javarush.task.task30.task3008;

import com.javarush.task.task30.task3008.client.Client;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();
    public static void main(String ... args){
        try(ServerSocket serverSocket = new ServerSocket(ConsoleHelper.readInt())) {

            ConsoleHelper.writeMessage("Server started");
            while (true){
                Socket socket = serverSocket.accept();
                Handler handler = new Handler(socket);
                handler.start();
            }
        }
        catch (Exception e){
            ConsoleHelper.writeMessage(e.getMessage());
        }
    }
    private static class Handler extends Thread{
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }
        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException{
            Message respond;
            Message message = new Message(MessageType.NAME_REQUEST);
            while(true) {
                connection.send(message);
                respond = connection.receive();
                if (respond.getType() == MessageType.USER_NAME  && respond.getData().length()>0 && !connectionMap.containsKey(respond.getData())){
                    connectionMap.put(respond.getData(),connection);
                    connection.send(new Message(MessageType.NAME_ACCEPTED));
                    break;
                }
            }
            return respond.getData();
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException{
            for(Map.Entry<String,Connection> entry : connectionMap.entrySet()){
                if(entry.getKey().equals(userName))continue;
                Message message = new Message(MessageType.USER_ADDED,entry.getKey());
                connection.send(message);
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException{
            Message message;
            while(true){
                message = connection.receive();
                if(message.getType() == MessageType.TEXT){
                    sendBroadcastMessage(new Message(MessageType.TEXT,userName + ": " + message.getData()));
                }
                else{
                    ConsoleHelper.writeMessage("Error. Wrong message type");
                }
            }
        }

        @Override
        public void run() {
            ConsoleHelper.writeMessage("New connection " + socket.getRemoteSocketAddress());
            String userName ="";
            try {
                Connection connection = new Connection(socket);
                userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED,userName));
                sendListOfUsers(connection,userName);
                serverMainLoop(connection,userName);
            }
            catch (IOException e){
                ConsoleHelper.writeMessage(e.getMessage());
            }
            catch (ClassNotFoundException e){
                ConsoleHelper.writeMessage(e.getMessage());
            }
            if(connectionMap.containsKey(userName)){
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED,userName));
                connectionMap.remove(userName);
            }
        }
    }



    public static void sendBroadcastMessage(Message message){
        for(Map.Entry<String,Connection> entry : connectionMap.entrySet()){
            try {
                entry.getValue().send(message);
            }
            catch (IOException e){
                ConsoleHelper.writeMessage("cant send message to " + entry.getKey());
            }
        }
    }
}
