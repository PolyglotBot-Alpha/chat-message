package com.example.chatmessage.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chat {
    private Integer chatId;
    private Integer userId;
    private String chatName;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
