package com.example.chatmessage.service;

import com.example.chatmessage.pojo.Chat;

import java.util.List;

public interface ChatService {
    List<Chat> list(String userId);

    void delete(Long id);

    void add(Chat chat);

    void update(Chat chat);
}
