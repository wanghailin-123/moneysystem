package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * 资金类
 */
public class Money extends Users{
    //资金的id
    private Integer id;
    //入职时间
    private Integer Time;
    //收入（找零前）
    private Double Income;
    //找零
    private Double Outcome;
    //剩余收入（找零后）
    private Double residue;
    //职员id
    private Integer Uid;
    //账号id
    private String Bid;

}
