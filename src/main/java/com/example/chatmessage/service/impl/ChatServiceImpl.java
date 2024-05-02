package com.example.chatmessage.service.impl;

import com.example.chatmessage.mapper.ChatMapper;
import com.example.chatmessage.pojo.Chat;
import com.example.chatmessage.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    private ChatMapper chatMapper;

    @Override
    public List<Chat> list(Long userId) {
        return chatMapper.list(userId);
    }

    @Override
    public void delete(Long id) {
        chatMapper.delete(id);
    }

    @Override
    public void add(Chat chat) {
        chat.setCreateTime(LocalDateTime.now());
        chat.setUpdateTime(LocalDateTime.now());

        chatMapper.insert(chat);
    }

    @Override
    public void update(Chat chat) {
        chat.setUpdateTime(LocalDateTime.now());
        chatMapper.update(chat);
    }
}
