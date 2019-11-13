package com.wx.retry.service.impl;

import com.wx.retry.service.NotifyService;
import org.springframework.stereotype.Service;

@Service
public class NotifyServiceImpl implements NotifyService {
    @Override
    public void sendNotify() {
        System.out.println("send message");
    }
}
