package com.example.pavel.services;

import com.example.pavel.domain.User;
import com.example.pavel.repository.UserRepository;
import com.example.pavel.services.impl.FileGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Сервис работы с хранилищем пользователей
 */
@Service
@RequiredArgsConstructor
public class DataProcessingService {

    /**
     * Пользовательский репозиторий
     */
    private final UserRepository repository;

    private final FileGateway fileGateway;

    /**
     * Метод получения репозитория пользователя
     * @return репозиторий
     */
    public UserRepository getRepository() {
        return repository;
    }


    /**
     * Метод сортировки всех пользователей
     * @param users список всех пользователей
     * @return сортированый список пользователей
     */
    public List<User> sortUsersByAge(List<User> users) {
        return users.stream()
                .sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toList());
    }

    /**
     * Метод фильтрации пользователей по возрасту
     * @param users список пользователей
     * @param age возраст для фильтрации
     * @return список отфильтрованных по возрасту пользователей
     */
    public List<User> filterUsersByAge(List<User> users, int age) {
        return users.stream()
                .filter(user -> user.getAge() > age)
                .collect(Collectors.toList());
    }

    /**
     * Метод выявления среднего возраста пользователей
     * @param users список всех пользователей
     * @return средний возраст пользователей
     */
    public double calculateAverageAge(List<User> users) {
        return users.stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0);
    }

    /**
     * Метод добавления пользователя в БД
     * @param user пользователь
     */
    public void addUserToList(User user) {
        repository.getUsers().add(user);
        fileGateway.writeToFile("users.txt", user.toString());
    }
}
