package com.example.pavel.services;

import com.example.pavel.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Сервис регистрации новых пользователей
 */
@Service
public class RegistrationService {
    /**
     * Сервис для создания пользователя
     */
    @Autowired
    UserService userService;
    /**
     * Сервис отправки в консоль сообщений
     */
    @Autowired
    NotificationService notificationService;

    /**
     * Сервис работы с хранилищем пользователей
     */
    @Autowired
    private DataProcessingService dataProcessingService;



    /**
     * Получить сервис работы с хранилищем пользователей
     * @return сервис
     */
    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    /**
     * Метод сохранения пользователя в БД
     * @param name имя пользователя
     * @param age возраст пользователя
     * @param email почта пользователя
     */
    public void processingService(String name, int age, String email) {
        User newUser = userService.createUser(name, age, email);
        dataProcessingService.addUserToList(newUser);
        notificationService.sendNotification("Пользователь сохранен в БД.");
    }
}
