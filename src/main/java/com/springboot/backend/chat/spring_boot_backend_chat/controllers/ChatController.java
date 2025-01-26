package com.springboot.backend.chat.spring_boot_backend_chat.controllers;

import java.util.Date;
import java.util.Random;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.springboot.backend.chat.spring_boot_backend_chat.models.documents.Mensaje;
import com.springboot.backend.chat.spring_boot_backend_chat.models.documents.TypeMessage;

@Controller
public class ChatController {

    @MessageMapping("/mensaje")
    @SendTo("/chat/mensaje")
    public Mensaje recibirMensaje(Mensaje mensaje) {

        String[] colors = {
            "red", "blue", "green", "yellow", "black", "orange", "purple"
        };

        mensaje.setFecha(new Date().getTime());
        if(mensaje.getType().equals(TypeMessage.NEW_USER)){
            mensaje.setText("Bienvenido " + mensaje.getUsername());
            mensaje.setColor(colors[new Random().nextInt(colors.length)]);
        }

        System.out.println(mensaje.getText() + " " + mensaje.getFecha().toString());
        
        return mensaje;

    }

}
