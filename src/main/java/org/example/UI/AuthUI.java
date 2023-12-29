package org.example.UI;

import org.example.server.service.AuthService;
import org.example.server.entity.enums.Role;
import org.example.server.payload.Result;
import org.example.server.payload.SignInDTO;
import org.example.server.payload.SignUpDTO;

import static org.example.UI.Constants.*;

public class AuthUI {
    public static void signIn() {
        System.out.println("Enter email");
        String email = SCANNER.nextLine();

        System.out.println("Enter password");
        String password = SCANNER.nextLine();

        SignInDTO user = new SignInDTO(email, password);

        Result result = AuthService.login(user);
        if (result.isSuccess()) {
            System.out.println(MainUI.paintGreen(result.getMessage()));
            UserUI.cabinet((Role) result.getObject());
        } else {
            System.out.println(MainUI.paintRed(result.getMessage()));

        }
    }

    public static void signUp() {
        System.out.println("Enter name");
        String name = SCANNER.nextLine();

        System.out.println("Enter email ");
        String email = SCANNER.nextLine();

        System.out.println("Enter password");
        String password = SCANNER.nextLine();

        System.out.println("Enter password again");
        String confirmPassword = SCANNER.nextLine();

        SignUpDTO user = new SignUpDTO(name, email, password, confirmPassword);

        Result result = AuthService.register(user);
        if (result.isSuccess()) {
            System.out.println(MainUI.paintGreen(result.getMessage()));
        } else {
            System.out.println(MainUI.paintRed(result.getMessage()));
        }
    }
}
