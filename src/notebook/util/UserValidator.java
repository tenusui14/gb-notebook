package notebook.util;

import notebook.model.User;

public class UserValidator {
    public User validate(User user) {

        if(!isValid(user)){
            throw new IllegalArgumentException("Введены некорректные данные");
        }
        user.setFirstName(user.getFirstName().replaceAll(" ", "").trim());
        user.setLastName(user.getLastName().replaceAll(" ", "").trim());
        user.setPhone(user.getPhone().replaceAll(" ", "").trim());
        return user;
    }

    private boolean isValid(User user){
        return !user.getFirstName().isEmpty() || !user.getLastName().isEmpty() || !user.getPhone().isEmpty();
    }

    public String validStr(String s){
        if(!s.isEmpty()) return s;
        else throw new IllegalArgumentException("Введены некорректные данные");
    }



}
