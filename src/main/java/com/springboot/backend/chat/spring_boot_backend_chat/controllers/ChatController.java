package com.springboot.backend.chat.spring_boot_backend_chat.controllers;

import java.util.Date;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.springboot.backend.chat.spring_boot_backend_chat.models.documents.Mensaje;

@Controller
public class ChatController {

    @MessageMapping("/mensaje")
    @SendTo("/chat/mensaje")
    public Mensaje recibirMensaje(Mensaje mensaje) {

        mensaje.setFecha(new Date().getTime());
        mensaje.setTexto("Recibido por el Broker " + mensaje.getTexto());
        
        return mensaje;

    }

}
