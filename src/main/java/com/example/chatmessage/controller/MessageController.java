package com.example.chatmessage.controller;

import com.example.chatmessage.pojo.Message;
import com.example.chatmessage.pojo.Result;
import com.example.chatmessage.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/{chatId}")
    public Result getMessage(@PathVariable Integer chatId) {
        log.info("getMessage chatId={}", chatId);
        List<Message> messages = messageService.getMessages(chatId);
        return Result.success(messages);
    }

    @DeleteMapping("/{messageId}")
    public Result deleteMessage(@PathVariable Integer messageId) {
        log.info("deleteMessage messageId={}", messageId);
        messageService.deleteMessage(messageId);
        return Result.success();
    }

    @PostMapping
    public Result addMessage(@RequestBody Message message) {
        log.info("addMessage message={}", message);
        messageService.addMessage(message);
        return Result.success();
    }

    @PutMapping
    public Result updateMessage(@RequestBody Message message) {
        log.info("updateMessage message={}", message);
        messageService.updateMessage(message);
        return Result.success();
    }
}
