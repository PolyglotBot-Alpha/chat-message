package com.example.chatmessage.service.impl;

import com.example.chatmessage.mapper.MessageMapper;
import com.example.chatmessage.pojo.Message;
import com.example.chatmessage.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageMapper messageMapper;

    @Override
    public List<Message> getMessages(Long chatId) {
        return messageMapper.list(chatId);
    }

    @Override
    public void deleteMessage(Long messageId) {
        messageMapper.deleteMessage(messageId);
    }

    @Override
    public void addMessage(Message message) {
        message.setCreateTime(LocalDateTime.now());
        message.setUpdateTime(LocalDateTime.now());

        messageMapper.addMessage(message);
    }

    @Override
    public void updateMessage(Message message) {
        message.setUpdateTime(LocalDateTime.now());

        messageMapper.updateMessage(message);
    }
}
