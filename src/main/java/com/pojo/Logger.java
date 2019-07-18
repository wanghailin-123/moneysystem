package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * 日志表
 */
public class Logger extends Users{
    //日志编号
    private Integer Id;
    //职员编号
    private Integer Uid;
    //添加时间
    private  String Time;
    //用户行为
    private String Play;
}
