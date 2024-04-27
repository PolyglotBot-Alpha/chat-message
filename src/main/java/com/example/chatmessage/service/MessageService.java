package com.example.chatmessage.service;

import com.example.chatmessage.pojo.Message;

import java.util.List;

public interface MessageService {
    List<Message> getMessages(Integer chatId);

    void deleteMessage(Integer messageId);

    void addMessage(Message message);

    void updateMessage(Message message);
}
