package com.example.pavel.services;

import com.example.pavel.domain.User;
import org.springframework.stereotype.Service;

/**
 * Сервис консольных сообщений
 */
@Service
public class NotificationService {

    /**
     * Метод отправки в консоль сообщения о создании нового пользователя
     * @param user пользователь
     */
    public void notifyUser(User user) {
        System.out.println("A new user has been created: " + user.getName());
    }

    /**
     * Метод отправки в консоль сообщения
     * @param s сообщение
     */
    public void sendNotification(String s) {
        System.out.println(s);
    }
}
