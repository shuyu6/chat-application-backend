package com.shuyu.chat.application.websocket.config;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Slf4j
@AllArgsConstructor
public class WebSocketEventListener {

    private SimpMessagingTemplate messagingTemplate;

    @EventListener
    private void handleSessionConnected(SessionConnectEvent event) {
        log.debug("WebSocketEventListener", event.toString());
    }

    @EventListener
    private void handleSessionDisconnect(SessionDisconnectEvent event) {
        log.debug("WebSocketEventListener", event.toString());
    }
}