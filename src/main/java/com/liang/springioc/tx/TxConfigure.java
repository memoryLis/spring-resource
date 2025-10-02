package com.liang.springioc.tx;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionManager;

import javax.sql.DataSource;

/**
 * ClassName: CircularConfigure
 * Package: com.liang.springioc.FinishBeanFactoryInitialization.cicular
 * Description:
 *
 * @Author liang
 * @Create 2025/6/30 20:18
 * @Version jdk17.0
 */
@Configuration
@EnableAspectJAutoProxy
public class TxConfigure {
    @Bean
    //注入数据源
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/spring_study?characterEncoding=utf-8&useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("qazwsxedcrfv123..3");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setInitialSize(5); // 初始连接数
        dataSource.setMinIdle(5);    // 最小空闲连接
        dataSource.setMaxWait(60000); // 获取连接的最大等待时间
        dataSource.setMaxActive(20);  // 最大连接数量
        return dataSource;
    }
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
    //注入事务管理器
    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}
