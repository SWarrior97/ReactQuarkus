package org.acme;

import org.acme.model.Database;
import org.acme.model.Encriptacao;
import org.acme.model.User;

import javax.enterprise.context.ApplicationScoped;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

@ApplicationScoped
public class LogInService {
    private Database database = new Database();

    public String greeting(String name) {
        return "hello " + name;
    }

    public Set<User> verifyLogIn(String email, String password) {
        Set<User> users = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));
        User user = database.verifyUserExist(email);
        String hashPassword = Encriptacao.sha256(password);

        if(user != null){
            if(user.getPassword().equals(hashPassword)){
                User userReturn = new User(user.getName(),user.getEmail(),user.getRole());
                userReturn.setShoppingLists(user.getShoppingLists());
                users.add(userReturn);
            }
        }

        return users;
    }

    public Set<User> createUser(String name, String email, String password, String role) {
        Set<User> users = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));
        String hashPassword = Encriptacao.sha256(password);


        User user = database.createUser(name,email,hashPassword,role);

        users.add(user);

        return users;
    }
}
