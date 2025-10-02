package com.liang.springioc.tx.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * ClassName: AccountDao
 * Package: com.liang.springioc.tx.mapper
 * Description:
 *
 * @Author liang
 * @Create 2025/7/2 11:09
 * @Version jdk17.0
 */
@Repository
public class AccountDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public void update(String name, Double money){
        jdbcTemplate.update("update l_account set balance = balance - ? where name = ?",money,name);
    }

}
