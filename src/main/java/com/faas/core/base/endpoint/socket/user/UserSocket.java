package com.faas.core.base.endpoint.socket.user;

import com.faas.core.base.model.socket.user.request.UserRequestWSocket;
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
    public void sendRoomMessage(@Payload UserRequestWSocket adminRequestSocketWS) {

    }


}
