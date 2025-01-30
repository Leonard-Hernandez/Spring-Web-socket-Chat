package com.springboot.backend.chat.spring_boot_backend_chat.models.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springboot.backend.chat.spring_boot_backend_chat.models.documents.Mensaje;

public interface ChatRepository extends MongoRepository<Mensaje, String> {

    public List<Mensaje> findFirst10ByOrderByFechaDesc();

}
