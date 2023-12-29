package org.example.server.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.server.Utils.CommonUtils;
import org.example.server.entity.enums.Role;

@Getter
@NoArgsConstructor
public class User {
    {
        id = CommonUtils.generateId();
        role = Role.USER;
    }

    private final Long id;
    @Setter
    private String name;
    @Setter
    private String email;
    @Setter
    private String password;
    @Setter
    private Role role;

    public String toString() {
        return String.format("| %20s | %20s | %20s | %10s |",
                id, name, email, role);
    }
}
