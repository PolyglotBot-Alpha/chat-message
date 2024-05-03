package com.example.chatmessage.controller;

import com.example.chatmessage.pojo.Chat;
import com.example.chatmessage.pojo.Result;
import com.example.chatmessage.service.ChatService;
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
@RequestMapping("/chats")
@Tag(name = "Chat Management", description = "Manage chat interactions")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @GetMapping("/{userId}")
    @Operation(summary = "List all chats", description = "Return all chats for a specific user")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved chat list",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Result.class)))
    @ApiResponse(responseCode = "404", description = "User not found")
    @Parameter(name = "userId", description = "User ID for whom to retrieve chats", required = true)
    public Result list(@PathVariable String userId) {
        log.info("list all chats");
        List<Chat> chatList = chatService.list(userId);
        return Result.success(chatList);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete chat", description = "Deletes a chat by its ID")
    @ApiResponse(responseCode = "200", description = "Chat successfully deleted")
    @ApiResponse(responseCode = "404", description = "Chat not found")
    @Parameter(name = "id", description = "Chat ID to be deleted", required = true)
    public Result delete(@PathVariable Long id) {
        log.info("delete chat with id {}", id);
        chatService.delete(id);
        return Result.success();
    }

    @PostMapping
    @Operation(summary = "Add chat", description = "Adds a new chat")
    @ApiResponse(responseCode = "201", description = "Chat added successfully")
    @ApiResponse(responseCode = "400", description = "Invalid data for chat")
    public Result add(@RequestBody Chat chat) {
        log.info("add chat {}", chat);
        chatService.add(chat);
        return Result.success();
    }

    @PutMapping
    @Operation(summary = "Update chat", description = "Updates an existing chat")
    @ApiResponse(responseCode = "200", description = "Chat updated successfully")
    @ApiResponse(responseCode = "404", description = "Chat not found")
    public Result update(@RequestBody Chat chat) {
        log.info("update chat {}", chat);
        chatService.update(chat);
        return Result.success();
    }
}
