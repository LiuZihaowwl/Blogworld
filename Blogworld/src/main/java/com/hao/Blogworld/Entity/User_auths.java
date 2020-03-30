package com.hao.Blogworld.Entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "用户认证实体")
public class User_auths {
    @ApiModelProperty("用户认证ID")
    private Long uu_id;
    @ApiModelProperty("用户ID")
    private Long u_id;
    @ApiModelProperty("用户密码")
    private String credential;
    @ApiModelProperty("用户状态")
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
