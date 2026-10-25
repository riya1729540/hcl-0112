package com.sampel.notificationservice;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student {
    private NotificationService notificationService;
    @Autowired
    public Student(NotificationService notificationService){
        this.notificationService=notificationService;
    }

    public void notifyStudent(){
        notificationService.sendMsg("Your assessment is scheduled");
    }

@PostConstruct
    public void init(){
    System.out.println("Object created");
}

@PreDestroy
    public void destroy(){
    System.out.println("Object destroyed");
}


}
