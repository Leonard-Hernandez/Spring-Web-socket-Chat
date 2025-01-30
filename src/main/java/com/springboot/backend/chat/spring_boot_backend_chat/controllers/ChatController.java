package com.springboot.backend.chat.spring_boot_backend_chat.controllers;

import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.springboot.backend.chat.spring_boot_backend_chat.models.documents.Mensaje;
import com.springboot.backend.chat.spring_boot_backend_chat.models.documents.TypeMessage;
import com.springboot.backend.chat.spring_boot_backend_chat.models.services.ChatService;

@Controller
public class ChatController {

    @Autowired
    private ChatService chatService;

    @MessageMapping("/mensaje")
    @SendTo("/chat/mensaje")
    public Mensaje recibirMensaje(Mensaje mensaje) {

        String[] colors = {
            "red", "blue", "green", "yellow", "black", "orange", "purple"
        };

        mensaje.setFecha(new Date().getTime());
        if(mensaje.getType().equals(TypeMessage.NEW_USER)){
            mensaje.setText("Bienvenido ");
            mensaje.setColor(colors[new Random().nextInt(colors.length)]);
        }else{
            chatService.guardar(mensaje);
        }

        System.out.println(mensaje.getText() + " " + mensaje.getFecha().toString());
        
        return mensaje;

    }

    @MessageMapping("/escribiendo")
    @SendTo("/chat/escribiendo")
    public String escribiendo(String username) {
        return username + " esta escribiendo...";
    }

}
