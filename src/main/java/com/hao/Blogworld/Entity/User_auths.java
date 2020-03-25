package com.hao.Blogworld.Entity;


import lombok.Data;

@Data
public class User_auths {
    private Long uu_id;
    private Long u_id;
    private String credential;
    private String  ifverified;

    public User_auths(Long uu_id, Long u_id, String credential, String ifverified) {
        this.uu_id = uu_id;
        this.u_id = u_id;
        this.credential = credential;
        this.ifverified = ifverified;
    }

    public User_auths() {
    }
}
