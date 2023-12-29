package org.example.server.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.server.Utils.CommonUtils;


@NoArgsConstructor
@Getter
public class Book {
    {
        id = CommonUtils.generateId();
    }

    public Book(String author, String name, Integer count) {
        this.author = author;
        this.name = name;
        this.count = count;
    }

    private final Long id;
    private String author;
    private String name;
    @Setter
    private Integer count;

    @Override
    public String toString() {
        return String.format("| %20s | %20s | %20s | %5s |",
                id, author, name, count);
    }
}
