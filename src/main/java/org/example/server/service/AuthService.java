package org.example.server.service;

import static org.example.server.Utils.Checks.*;

import org.example.server.Utils.CommonUtils;
import org.example.server.entity.User;
import org.example.server.payload.Result;
import org.example.server.payload.SignInDTO;
import org.example.server.payload.SignUpDTO;
import org.example.server.repository.UserRepo;

public class AuthService {
    public static Result register(SignUpDTO user) {
        if (isValidStr(user.getName())) {
            return new Result("name is not valid", null, false);
        } else if (validEmail(user.getEmail())) {
            return new Result("email is not valid", null, false);
        } else if (validPassword(user.getPassword())) {
            return new Result("password is not valid", null, false);
        } else if (UserRepo.isExistsByEmail(user.getEmail())) {
            return new Result("this email busy", null, false);
        }
        if (!user.getPassword().equals(user.getRePassword())) {
            return new Result("Passwords don't match", null, false);
        }
        User newUser = SignUpDTOToUser(user);
        UserRepo.saveUser(newUser);
        return new Result("success fully registration", null, true);
    }


    public static Result login(SignInDTO user) {
        if (validEmail(user.getEmail())) {
            return new Result("email is not valid", null, false);
        } else if (validPassword(user.getPassword())) {
            return new Result("password is not valid", null, false);
        }
        User user1 = UserRepo.findByEmail(user.getEmail());
        if ((user1 != null) && user.getPassword().equals(user1.getPassword())) {
            CommonUtils.setCurrentUser(user1);
            return new Result("welcome " + user1.getName(), user1.getRole(), true);
        }
        return new Result("user don't exists", null, false);
    }

    private static User SignUpDTOToUser(SignUpDTO user) {
        User user1 = new User();
        user1.setEmail(user.getEmail());
        user1.setName(user.getName());
        user1.setPassword(user.getPassword());
        return user1;
    }
}
