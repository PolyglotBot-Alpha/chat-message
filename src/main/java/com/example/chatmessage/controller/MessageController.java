package com.example.chatmessage.controller;

import com.example.chatmessage.pojo.Message;
import com.example.chatmessage.pojo.Result;
import com.example.chatmessage.service.MessageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/messages")
@Tag(name = "Message Management", description = "Manage message interactions")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/{chatId}")
    @Operation(summary = "Get messages by chat ID", description = "Retrieve all messages for a specific chat")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved messages",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Result.class)))
    @ApiResponse(responseCode = "404", description = "Chat not found")
    @Parameter(name = "chatId", description = "Chat ID to retrieve messages from", required = true)
    public Result getMessage(@PathVariable Long chatId) {
        log.info("getMessage chatId={}", chatId);
        List<Message> messages = messageService.getMessages(chatId);
        return Result.success(messages);
    }

    @DeleteMapping("/{messageId}")
    @Operation(summary = "Delete a message", description = "Delete a message by its ID")
    @ApiResponse(responseCode = "200", description = "Message deleted successfully")
    @ApiResponse(responseCode = "404", description = "Message not found")
    @Parameter(name = "messageId", description = "Message ID to be deleted", required = true)
    public Result deleteMessage(@PathVariable Long messageId) {
        log.info("deleteMessage messageId={}", messageId);
        messageService.deleteMessage(messageId);
        return Result.success();
    }

    @PostMapping
    @Operation(summary = "Add a message", description = "Add a new message to a chat")
    @ApiResponse(responseCode = "201", description = "Message added successfully")
    @ApiResponse(responseCode = "400", description = "Invalid data for message")
    public Result addMessage(@RequestBody Message message) {
        log.info("addMessage message={}", message);
        messageService.addMessage(message);
        return Result.success();
    }

    @PutMapping
    @Operation(summary = "Update a message", description = "Update an existing message")
    @ApiResponse(responseCode = "200", description = "Message updated successfully")
    @ApiResponse(responseCode = "404", description = "Message not found")
    public Result updateMessage(@RequestBody Message message) {
        log.info("updateMessage message={}", message);
        messageService.updateMessage(message);
        return Result.success();
    }
}
