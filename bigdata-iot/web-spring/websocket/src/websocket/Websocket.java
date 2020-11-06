package websocket;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@ServerEndpoint("/websocket")
@ServerEndpoint(value="/websocket/{userId}")
public class Websocket {
	
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    static HashMap<String, Session> messageUserList = new HashMap<String, Session>();

	@OnOpen
	public void handleOpen(Session session, @PathParam("userId") String userId) {
		System.out.println("client is now connected...");
		// @PathParam 은 웹소켓에서 사용하는 @PathVariables
		// 1. userId 가 중복되는지 확인
		if (messageUserList.get(userId) != null) {
			logger.info("중복 발생");
			//userId = "";
			sendMsg(session, "사용중인 아이디 입니다.");
		} else {// 중복이 아닐 경우
			logger.info("중복 아님");

			messageUserList.put(userId, session);
			System.out.println(userId + "else USERID");

			/*
			 * String memberEmail = (String)httpSession.getAttribute("email");
			 */ broadCast(userId + "님이 입장 하셨습니다." /* 현재 접속자 수 : +userList.size() */ + "\n");
		}
	}
	
	// WebSocket으로 메시지가 오면 요청되는 함수
	@OnMessage
	public String handleMessage(String message) {
        broadCast(message);
		
		// 메시지 내용을 콘솔에 출력한다.
		System.out.println("receive from client : " + message);
		// 에코 메시지를 작성한다.
		String replymessage = "echo " + message;
		// 에코 메시지를 콘솔에 출력한다.
		System.out.println("send to client : " + replymessage);
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
	
	//메시지 전체 전송
    private void broadCast(String text){
        logger.info("전달 대상 : "+messageUserList.size());
        Set<String>keys =  messageUserList.keySet();
        try {            
            for(String key : keys) {
                logger.info("key : "+key);
                Session session = messageUserList.get(key);    
                session.getBasicRemote().sendText(text);
                System.out.println(session.getId() + "ID!!!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
  //한명에게 메시지 전달
    private void sendMsg(Session session, String msg) {
        try {
            session.getBasicRemote().sendText(msg);
        } catch (IOException e) {    
            e.printStackTrace();
        }
    }
}
