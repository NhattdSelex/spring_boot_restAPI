package com.jttrinh.restfullapi.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDAOService {
    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(0, "jt_trinh", LocalDate.now().minusYears(20)));
        users.add(new User(1, "Trinh Nhat", LocalDate.now().minusYears(20)));
        users.add(new User(2, "Nhat Trinh", LocalDate.now().minusYears(20)));
        users.add(new User(3, "Trinh Duong Nhat", LocalDate.now().minusYears(20)));
    }

    public List<User> finalAll(){
        return users;
    }

    public User getOne(int id) {
        Predicate<? super User> predicate = user -> user.getId() == id;
        return users.stream().filter(predicate).findFirst().get();
    }
}
