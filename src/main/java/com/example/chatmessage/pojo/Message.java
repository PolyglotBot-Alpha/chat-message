package com.example.chatmessage.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private Long messageId;
    private Long chatId;
    private Long userId;
    private String messageContent;
    private String audio;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
