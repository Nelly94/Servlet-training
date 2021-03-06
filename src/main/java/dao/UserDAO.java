package dao;

import model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDAO {
    Map<String, User> users = new HashMap<String, User>() {
        {
            put("Jack", new User("Jack", "Smith", 2000));
            put("Bob", new User("Bob", "Dilan", 3000));
            put("Alicia", new User("Alicia", "Keys", 4000));
        }
    };

    public User findUser(String id) {
        return users.get(id);
    }

    public List<User> getUsers(){
        List<User> usersList = new ArrayList<>();
        for(String key : users.keySet()){
            usersList.add(users.get(key));
        }
        return usersList;
    }

    public void addUser(User user){
        users.put(user.getFirstname(), user);
    }
}
