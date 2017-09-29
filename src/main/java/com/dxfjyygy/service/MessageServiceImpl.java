package com.dxfjyygy.service;

import com.dxfjyygy.dao.MessageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by longjinwen on 28/09/2017.
 */
@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageDao messageDao;
    public int save(Object o) {
        return messageDao.save(o);
    }
}
