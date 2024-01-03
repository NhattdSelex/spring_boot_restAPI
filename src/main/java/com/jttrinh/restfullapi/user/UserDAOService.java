package com.jttrinh.restfullapi.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDAOService {
    private static List<User> users = new ArrayList<>();
    private static int userCount = 0;

    static {
        users.add(new User(++userCount, "jt_trinh", LocalDate.now().minusYears(20)));
        users.add(new User(++userCount, "Trinh Nhat", LocalDate.now().minusYears(20)));
        users.add(new User(++userCount, "Nhat Trinh", LocalDate.now().minusYears(20)));
        users.add(new User(++userCount, "Trinh Duong Nhat", LocalDate.now().minusYears(20)));
    }

    public List<User> finalAll(){
        return users;
    }

    public User getOne(int id) {
        Predicate<? super User> predicate = user -> user.getId() == id;
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public User save(User user) {
        user.setId(++userCount);
        users.add(user);
        return user;
    }
}
