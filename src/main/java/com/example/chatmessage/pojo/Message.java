package com.example.chatmessage.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private Integer messageId;
    private Integer chatId;
    private Integer userId;
    private String messageContent;
    private String audio;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
