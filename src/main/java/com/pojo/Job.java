package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * 职位表
 */
public class Job {
    //职位编号
    private Integer Id;
    //职位名称
    private String Jname;
}
