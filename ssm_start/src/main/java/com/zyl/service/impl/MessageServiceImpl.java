package com.zyl.service.impl;

import com.zyl.dao.MessageDao;
import com.zyl.domain.Message;
import com.zyl.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("messageServiceImpl")
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageDao messageDao;
    @Override
    public List<Message> findAll() {
        System.out.println("messageServiceImpl:find");
        return messageDao.findAll();
    }

    @Override
    public void saveMessage(Message message) {
        System.out.println("messageServiceImpl:saveMessage");
        messageDao.saveMessage(message);
    }
}
