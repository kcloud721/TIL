package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;

import org.java_websocket.client.WebSocketClient;

import wstest.EmptyClient;

public class ClientTest {
    public static void main(String[] arg) throws URISyntaxException
    {
    	WebSocketClient client = new EmptyClient(new URI("ws://3.35.240.16:88/chat"));
    	
        Socket socket = null;            //Server와 통신하기 위한 Socket
        BufferedReader in = null;        //Server로부터 데이터를 읽어들이기 위한 입력스트림
        BufferedReader in2 = null;        //키보드로부터 읽어들이기 위한 입력스트림
        PrintWriter out = null;            //서버로 내보내기 위한 출력 스트림
        InetAddress ia = null;
        try {
            ia = InetAddress.getByName("192.168.1.22");    //서버로 접속
            socket = new Socket(ia,4141);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            in2 = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
            
            System.out.println(socket.toString());
        }catch(IOException e) {}
        
        try {
            System.out.print("서버로 보낼 메세제 : ");
            String data = in2.readLine();            //키보드로부터 입력
            out.println(data);                        //서버로 데이터 전송
            out.flush();

            String str2 = in.readLine();            //서버로부터 되돌아오는 데이터 읽어들임
            System.out.println("서버로부터 되돌아온 메세지 : " + str2);
            socket.close();
            
        }catch(IOException e) {}
    }
}