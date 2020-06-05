package dao;

import model.Login;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoginDAO {
    Map<String, Login> logins = new HashMap<String, Login>() {
        {
            put("jack@gmail.com", new Login("jack@gmail.com", "jackpass"));
            put("alicia@gmail.com", new Login("alicia@gmail.com", "jackpass"));
            put("bob@gmail.com", new Login("bob@gmail.com", "jackpass"));
        }
    };

    public Login findLogin(String name) {
        return logins.get(name);
    }

    public List<Login> getLogins(){
        List<Login> loginsList = new ArrayList<>();
        for(String key : logins.keySet()){
            loginsList.add(logins.get(key));
        }
        return loginsList;
    }

    public void addLogin(Login login){
        logins.put(login.getEmail(), login);
    }

    public void removeLogin(Login login){
        logins.remove(login.getEmail());
    }
}
