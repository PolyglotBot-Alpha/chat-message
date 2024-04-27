package com.example.chatmessage.mapper;

import com.example.chatmessage.pojo.Message;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MessageMapper {
    @Select("select * from messages where chat_id = #{chatId}")
    List<Message> list(Integer chatId);

    @Delete("delete from messages where message_id = #{messageId}")
    void deleteMessage(Integer messageId);

    @Insert("insert into messages (chat_id, user_id, message_content, audio, create_time, update_time) values (#{chatId}, #{userId}, #{messageContent}, #{audio}, #{createTime}, #{updateTime})")
    void addMessage(Message message);

    @Update("update messages set message_content = #{messageContent}, audio = #{audio}, update_time = #{updateTime} where message_id = #{messageId}")
    void updateMessage(Message message);
}
