package com.example.chatmessage.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chat {
    private Long chatId;
    private Long userId;
    private String chatName;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
