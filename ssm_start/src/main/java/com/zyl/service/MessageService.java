package com.zyl.service;

import com.zyl.domain.Message;

import java.util.List;

public interface MessageService {
    // 查询所有留言
    public List<Message> findAll();

    // 保存留言信息
    public void saveMessage(Message message);
}
