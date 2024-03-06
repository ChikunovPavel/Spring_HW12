package com.example.pavel.controllers;

import com.example.pavel.domain.User;
import com.example.pavel.facade.ProcessingFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


/**
 * Контроллер задач
 */
@RestController
@RequestMapping("/tasks")
public class TaskController {

    /**
     * Сервис работы с хранилищем пользователей
     */
    @Autowired
    private ProcessingFacade service;
//    private DataProcessingService service;

    /**
     * Метод получение всех задач
     * @return список задач
     */
    @GetMapping
    public List<String> getAllTasks() {
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return tasks;
    }

    /**
     * Метод сортировки списка пользователей
     * @return сортированный список пользователей
     */
    @GetMapping("/sort")//localhost:8080/tasks/sort
    public List<User> sortUsersByAge() {
        return service.sortUsersByAge(service.getRepository().getUsers());
    }

    /**
     * Метод фильтрации списка пользователей по возрасту
     * @param age возраст
     * @return отфильтрованный список пользователей
     */
    @GetMapping("/filter/{age}")
    public List<User> filterUsersByAge(@PathVariable("age") int age) {
        return service.filterUsersByAge(service.getRepository().getUsers(), age);
    }

    /**
     * Метод вычесления среднего возраста всех пользователей
     * @return средний возраст
     */
    @GetMapping("/calc")
    public Double calculateAverageAge() {
        return service.calculateAverageAge(service.getRepository().getUsers());
    }
}
