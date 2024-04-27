package com.example.chatmessage.controller;

import com.example.chatmessage.pojo.Chat;
import com.example.chatmessage.pojo.Result;
import com.example.chatmessage.service.ChatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/chats")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @GetMapping
    public Result list() {
        log.info("list all chats");
        List<Chat> chatList = chatService.list();
        return Result.success(chatList);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("delete chat with id {}", id);
        chatService.delete(id);
        return Result.success();
    }

    @PostMapping
    public Result add(@RequestBody Chat chat) {
        log.info("add chat {}", chat);
        chatService.add(chat);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody Chat chat) {
        log.info("update chat {}", chat);
        chatService.update(chat);
        return Result.success();
    }
}
