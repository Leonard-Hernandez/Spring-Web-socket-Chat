package com.springboot.backend.chat.spring_boot_backend_chat.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.backend.chat.spring_boot_backend_chat.models.dao.ChatRepository;
import com.springboot.backend.chat.spring_boot_backend_chat.models.documents.Mensaje;

@Service
public class ChatserviceImp implements ChatService {

    @Autowired
    private ChatRepository chatDao;

    @Override
    public List<Mensaje> obtenerUltimos10Mensajes() {
        return chatDao.findFirst10ByOrderByFechaDesc();
    }

    @Override
    public Mensaje guardar(Mensaje mensaje) {
        return chatDao.save(mensaje);
    }

}
