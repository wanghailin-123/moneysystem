package com.pojo;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * 职员类
 */
public class Users extends  Job{
//    员工账号，可以用作员工登录系统的账号
    private Integer id;
//    员工的职位id，可根据该id知道该员工的职位
    private  Integer Jid;
//    员工的姓名
    private String UserName;
//    员工的系统登录密码
    private String Password;
//    员工的入职时间
    private String Time;
    //检测用户是否已经登录  0代表未登录 1代表登录
    private Integer IsLog;
    //检测用户是否在值，0代表离职 1代表在职
    private Integer Status;


}
