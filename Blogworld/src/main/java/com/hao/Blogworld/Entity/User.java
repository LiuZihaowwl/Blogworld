package com.hao.Blogworld.Entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
@Data
@ApiModel(description = "用户实体")
public class User implements Serializable {
    private static final long serialVersionUID = -1L;
    @ApiModelProperty("用户编号")
    private Long u_id;
    @ApiModelProperty("用户名")
    private String u_name;
    @ApiModelProperty("用户性别")
    private String gender;
    @ApiModelProperty("用户出生日期")
    private Date birthday;
    @ApiModelProperty("用户手机号")
    private String phone;
    @Email
    @ApiModelProperty("用户邮箱")
    private String email;
    @ApiModelProperty("用户个性签名")
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
    @Override
    public String toString(){
        return "User{"+u_id
                +"User_name="+u_name;
    }


}
