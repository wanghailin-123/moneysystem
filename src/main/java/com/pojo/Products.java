package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * 商品类
 */
public class Products {
    //商品id
    private Integer Id;
    //商品名称
    private String ProductName;
    //商品数量
    private Integer Counts;
    //商品价格
    private Double Prices;
}
