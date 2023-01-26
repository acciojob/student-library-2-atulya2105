package com.driver.RequestDto;

import javax.persistence.Column;

public class AuthorRequestDto {
    private String name;

    @Column(unique = true)
    private String email;

    private int age;
    private String country;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public String getCountry() {
        return country;
    }
}
