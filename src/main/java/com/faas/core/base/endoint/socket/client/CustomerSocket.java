package com.faas.core.base.endoint.socket.client;

import com.faas.core.base.model.socket.operation.request.OperationRequestWSocket;
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
    public void sendRoomMessage(@Payload OperationRequestWSocket adminRequestSocketWS) {

    }


}
