package notebook.controller;

import notebook.model.User;
import notebook.model.repository.GBRepository;
import notebook.util.UserValidator;


import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class UserController {
    private final GBRepository repository;


    public UserController(GBRepository repository) {
        this.repository = repository;
    }

    public void saveUser(User user) {
        repository.create(user);
    }

    public User createUser() {
        UserValidator validator = new UserValidator();


        String firstName = prompt("Имя: ");
        String lastName = prompt("Фамилия: ");
        String phone = prompt("Номер телефона: ");

        return validator.validate(new User(firstName, lastName, phone));
    }
    public String prompt(String message) {
        UserValidator val = new UserValidator();
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return val.validStr(in.nextLine());
    }

    public User readUser(Long userId) throws Exception {
        List<User> users = repository.findAll();
        for (User user : users) {
            if (Objects.equals(user.getId(), userId)) {
                return user;
            }
        }

        throw new RuntimeException("User not found");
    }
    public List<User> readAll(){
        return repository.findAll();
    }

    public void deleteUser(String userId){
        repository.delete(Long.parseLong(userId));
    }

    public void updateUser(String userId, User update) {
        update.setId(Long.parseLong(userId));
        repository.update(Long.parseLong(userId), update);
    }
}
