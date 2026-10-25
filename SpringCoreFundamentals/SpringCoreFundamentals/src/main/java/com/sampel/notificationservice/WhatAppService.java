package com.sampel.notificationservice;

import org.springframework.stereotype.Component;

@Component
public class WhatAppService implements NotificationService {
    @Override
    public void sendMsg(String msg) {
        System.out.println("WhatsApp Service"+msg);
    }
}
