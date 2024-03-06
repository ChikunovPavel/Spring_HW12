package com.example.pavel.controllers;

import com.example.pavel.domain.User;
import com.example.pavel.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Контроллер пользователей
 */
@RestController
@RequestMapping("/user")//localhost:8080/user
public class UserController {

    /**
     * Сервис регистрации пользователей
     */
    @Autowired
    private RegistrationService service;

    /**
     * Получение списка всех пользователей
     * @return список пользователей
     */
    @GetMapping
    public List<User> userList() {
        return service.getDataProcessingService().getRepository().getUsers();
    }

    /**
     * Метод создания пользователей из тела http запроса
     * @param requestBody тело http запроса
     * @return Сообщение о создание нового пользователя
     */
    @PostMapping("/body")
    public String userAddFromBody(@RequestBody Map<String, Object> requestBody) {
        String name = (String) requestBody.get("name");
        Integer age = (Integer) requestBody.get("age");
        String email = (String) requestBody.get("email");
        service.processingService(name, age, email);
        return "User added from body!";
    }
}
