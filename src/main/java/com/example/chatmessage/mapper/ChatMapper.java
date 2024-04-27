package com.example.chatmessage.mapper;

import com.example.chatmessage.pojo.Chat;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ChatMapper {
    @Select("select * from chats")
    List<Chat> list();

    @Delete("delete from chats where chat_id = #{id}")
    void delete(Integer id);

    @Insert("insert into chats(user_id, chat_name, create_time, update_time) values (#{userId}, #{chatName}, #{createTime}, #{updateTime})")
    void insert(Chat chat);

    @Update("update chats set chat_name = #{chatName}, update_time = #{updateTime} where chat_id = #{chatId}")
    void update(Chat chat);
}
