package com.hao.Blogworld.Entity;

import lombok.Data;

import java.util.Date;
@Data
public class User {
    private Long u_id;
    private String u_name;
    private String gender;
    private Date birthday;
    private String phone;
    private String email;
    private String signal;

    public User(Long u_id, String u_name, String gender, Date birthday, String phone, String email, String signal) {
        this.u_id = u_id;
        this.u_name = u_name;
        this.gender = gender;
        this.birthday = birthday;
        this.phone = phone;
        this.email = email;
        this.signal = signal;
    }

    public User() {
    }


}
