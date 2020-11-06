package websocket;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocket")
public class WebsocketBasic {
	@OnOpen
	public void handleOpen() {
		System.out.println("client is now connected...");
	}
	
	// WebSocket으로 메시지가 오면 요청되는 함수
	@OnMessage
	public String handleMessage(String message) {
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
}
