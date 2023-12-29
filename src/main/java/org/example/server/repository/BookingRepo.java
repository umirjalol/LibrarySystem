package org.example.server.repository;

import org.example.server.database.DataBase;
import org.example.server.entity.Booking;
import org.example.server.entity.User;
import org.example.server.entity.enums.Status;

import java.time.LocalDate;
import java.util.List;

public class BookingRepo {
    public static List<Booking> findExpiredBookings(User currentUser) {
        return DataBase.bookings.
                stream().
                filter(b ->
                        b.getUserId().equals(currentUser.getId()) &&
                                b.getEndedTime().isBefore(LocalDate.now()))
                .toList();
    }

    public static void save(Booking booking) {
        DataBase.bookings.add(booking);
    }

    public static List<Booking> findNonExpiredBookings(User currentUser) {
        return DataBase.bookings.
                stream().
                filter(b ->
                        b.getUserId().equals(currentUser.getId()) &&
                                b.getEndedTime().isAfter(LocalDate.now()))
                .toList();
    }

    public static List<Booking> findByStatus(Status status) {
        return DataBase.
                bookings.
                stream().
                filter(b -> b.getStatus().
                        equals(status)).
                toList();
    }

    public static boolean changeStatus(long id, Status status) {
        for (Booking booking : DataBase.bookings) {
            if (booking.getId().equals(id)) {
                booking.setStatus(status);
                return true;
            }
        }
        return false;
    }
}
