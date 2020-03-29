package com.hao.Blogworld.Entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Blog implements Serializable {
    private static final long serialVersionUID = -1L;
    private long b_id;
    private String b_title;
    private long u_id;
    private String b_body;
    private long watch;
    private long nice;

    public Blog(long b_id, String b_title, long u_id, String b_body, long watch, long nice) {
        this.b_id = b_id;
        this.b_title = b_title;
        this.u_id = u_id;
        this.b_body = b_body;
        this.watch = watch;
        this.nice = nice;
    }

    public Blog() {
    }
    @Override
    public String toString(){
        return "Blog{"+
                "id=" + b_id +
                ", title=" + b_title;
    }
}
