package org.example.server.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class SignUpDTO {
    private String name;
    private String email;
    private String password;
    private String rePassword;

}