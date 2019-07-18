package com.pojo;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class User {
//    员工账号，可以用作员工登录系统的账号
    private int U_id;
//    员工的职位id，可根据该id知道该员工的职位
    private  int J_id;
//    员工的姓名
    private String UserName;
//    员工的系统登录密码
    private String Password;
//    员工的入职时间
    private String Time;
}
