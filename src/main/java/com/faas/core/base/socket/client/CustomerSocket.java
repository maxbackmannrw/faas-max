package com.faas.core.base.socket.client;

import com.faas.core.data.socket.base.customer.request.CustomerRequestSocketModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class CustomerSocket {


    @Autowired
    private SimpMessagingTemplate messageSender;


    @MessageMapping("/sendroommessage")
    public void sendRoomMessage(@Payload CustomerRequestSocketModel adminRequestSocketWS) {

    }


}
