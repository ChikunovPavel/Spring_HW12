package com.example.pavel.services;

import com.example.pavel.domain.User;
import org.springframework.stereotype.Service;

/**
 * Сервис для создания пользователя
 */
@Service
public class UserService {

    /**
     * Сервис консольных сообщений
     */
    // @Autowired
    private final NotificationService notificationService;

    /**
     * Конструктор класса
     * @param notificationService сервис консольных сообщений
     */
    // Внедрение зависимости через конструктор
    public UserService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    /**
     * Метод Создание пользователя
     * @param name имя
     * @param age возраст
     * @param email почта
     * @return нового пользователя
     */
    public User createUser(String name, int age, String email) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);

        // Отправляем уведомление о создании нового пользователя
        notificationService.notifyUser(user);
        return user;
    }
}
