package org.example.server.service;

import org.example.server.Utils.Checks;
import org.example.server.database.DataBase;
import org.example.server.entity.enums.Role;
import org.example.server.payload.Result;
import org.example.server.repository.UserRepo;

public class AdminService {
    public static Result assignAs(Role role, long id) {
        if (UserRepo.changeRole(id, role)) {
            return new Result("ok", null, true);
        }
        return new Result("user not found", null, false);
    }

    public static void addAFloor() {
        DataBase.library.addOneFloor();
    }

    public static void deleteAFloor() {
        DataBase.library.deleteOneFloor();
    }

    public static Result addACupboard(int floor) {
        if (Checks.validFloor(floor)) {
            return new Result("floor not found", null, false);
        }
        DataBase.library.getFloor(floor - 1).addOneCupboard();
        return new Result("successfully added", null, false);
    }

    public static Result deleteACupboard(int floor) {
        if (Checks.validFloor(floor)) {
            return new Result("floor not found", null, false);
        }
        DataBase.library.getFloor(floor - 1).deleteOneCupboard();
        return new Result("successfully added", null, false);
    }
}
