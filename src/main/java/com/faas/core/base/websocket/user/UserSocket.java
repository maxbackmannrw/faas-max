package com.faas.core.base.websocket.user;

import com.faas.core.data.websocket.base.user.request.UserRequestSocketModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserSocket {


    @Autowired
    private SimpMessagingTemplate messageSender;


    @MessageMapping("/sendroommessage2")
    public void sendRoomMessage(@Payload UserRequestSocketModel adminRequestSocketWS) {

    }


}
