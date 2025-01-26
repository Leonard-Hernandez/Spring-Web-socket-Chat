package com.springboot.backend.chat.spring_boot_backend_chat.models.documents;

import java.io.Serializable;

public class Mensaje implements Serializable {

    private String text;

    private Long fecha;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getFecha() {
        return fecha;
    }

    public void setFecha(Long fecha) {
        this.fecha = fecha;
    }

    private static final long serialVersionUID = -3777582564067492550L;

}
