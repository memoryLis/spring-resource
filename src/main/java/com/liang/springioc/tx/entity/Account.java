package com.liang.springioc.tx.entity;

import java.math.BigDecimal;
import lombok.Data;

/**
 * @TableName l_account
 */

@Data
public class Account {
    private Integer id;

    private BigDecimal balance;

    private String name;
}