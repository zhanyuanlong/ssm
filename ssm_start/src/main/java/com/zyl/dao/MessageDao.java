package com.zyl.dao;

import com.zyl.domain.Message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageDao {
    // 查询所有留言
    @Select("select * from message")
    public List<Message> findAll();

    // 保存留言信息
    @Insert("insert into message (username, msg, time) values (#{username},#{msg},#{time})")
    public void saveMessage(Message message);
}
