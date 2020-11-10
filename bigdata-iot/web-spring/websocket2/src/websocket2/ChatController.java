package websocket2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
 
@Controller
public class ChatController {
    
    private static final Logger logger = LoggerFactory.getLogger(ChatController.class);
    
 
    @RequestMapping(value = "/chatting.gom", method = RequestMethod.GET)
    public String chat() {
        
        return "chat/chat";
    }
    
    
    
}
 