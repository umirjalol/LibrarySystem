package org.example.server.entity;

import lombok.Getter;
import lombok.Setter;
import org.example.server.Utils.CommonUtils;
import org.example.server.entity.enums.Status;

import java.time.LocalDate;

@Getter
public class Booking {
    {
        id = CommonUtils.generateId();
        endedTime = LocalDate.now().plusDays(3);
        status = Status.NOT_TAKEN;
    }

    private final Long id;
    private final Long bookId;
    private final Long userId;
    private final LocalDate endedTime;
    @Setter
    private Status status;

    public Booking(Long bookId, Long userId) {
        this.bookId = bookId;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return String.format(
                "| %20s | %20s |",
                bookId, endedTime);
    }
}
