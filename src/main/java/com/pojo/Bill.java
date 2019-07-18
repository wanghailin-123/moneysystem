package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * 账单类
 */
public class Bill extends Products{
    //账单id
    private Integer Id;
    //资金账单id
    private Integer Bid;
    //售出商品id
    private Integer Pid;
    //商品售出数量
    private Integer ProductCount;
}
