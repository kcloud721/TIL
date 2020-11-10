package websocket;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ServerEndpoint("/websocket")
public class WebsocketBasic {
//    private Logger logger = LoggerFactory.getLogger(this.getClass());
//    static HashMap<String, Session> messageUserList = new HashMap<String, Session>();
	
	@OnOpen
	public void handleOpen() {
		System.out.println("client is now connected...");
	}
	
	// WebSocket으로 메시지가 오면 요청되는 함수
	@OnMessage
	public String handleMessage(String message) {
		// 메시지 내용을 콘솔에 출력한다.
		System.out.println("보내는 메시지 : " + message);
		// 에코 메시지를 작성한다.
		String replymessage = "RETURN: " + message;
		// 에코 메시지를 콘솔에 출력한다.
		System.out.println("받은 메시지 : " + replymessage);
		// 에코 메시지를 브라우저에 보낸다.
		return replymessage;
		}
	
	@OnClose
	public void handleClose() {
		System.out.println("client is now disconnected...");
	}
	
	@OnError
	public void handleError(Throwable t) {
		t.printStackTrace();
	}
	
	
//	private void broadCast(String text){
//        logger.info("전달 대상 : "+messageUserList.size());
//        Set<String>keys =  messageUserList.keySet();
//        try {            
//            for(String key : keys) {
//                logger.info("key : "+key);
//                Session session = messageUserList.get(key);    
//                session.getBasicRemote().sendText(text);
//                System.out.println(session.getId() + "ID!!!");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
