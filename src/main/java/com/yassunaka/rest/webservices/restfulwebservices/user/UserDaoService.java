package com.yassunaka.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();

    private static int usersCount = 3;

    static {
        users.add(new User(1, "Adam", new Date()));
        users.add(new User(2, "Eve", new Date()));
        users.add(new User(3, "Jack", new Date()));
    }

    public List<User> findAll(){
        return users;
    }

    public User save(User user){
        if (user.getId() == null)
            user.setId(++usersCount);

        users.add(user);
        return user;
    }

    public User findOne(int id){
        Stream<User> userStream = users.stream().filter(c -> c.getId() == id);

        if (userStream != null && userStream.count() > 0)
            return users.get(0);

        return null;
    }

    public User deleteById(int id){
        User one = findOne(id);
        if (one != null)
            users.remove(one);

        return one;
    }
}