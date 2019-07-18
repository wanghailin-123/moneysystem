package com.pojo;

import java.math.BigDecimal;

public class Money {
//资金变动时间
    private String M_time;
//    收入资金
    private BigDecimal in;
//    找零资金
    private BigDecimal out;
//剩余资金
    private BigDecimal residue;
// 执行操作的员工id
    private int U_id;
//产生资金流动的账单id
    private int B_id;
}
