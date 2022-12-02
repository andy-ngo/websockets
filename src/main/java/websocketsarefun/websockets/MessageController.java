package websocketsarefun.websockets;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController
{
    @MessageMapping("/chat.send")
    @SendTo("topic/public")
    public ChatMessage sendMessage(@Payload final ChatMessage chatMessage)
    {
        return chatMessage;
    }
}
