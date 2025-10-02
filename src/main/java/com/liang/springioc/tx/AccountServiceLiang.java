package com.liang.springioc.tx;

import com.liang.springioc.tx.mapper.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * ClassName: AccountServiceLiang
 * Package: com.liang.springioc.tx
 * Description:
 *
 * @Author liang
 * @Create 2025/7/2 11:16
 * @Version jdk17.0
 */
@Service
public class AccountServiceLiang {
    @Autowired
    PlatformTransactionManager platformTransactionManager ;
    @Autowired
    AccountDao accountDao ;

    public void transfer(String out, String in, Double money) {
        DefaultTransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();
        TransactionStatus transactionStatus = platformTransactionManager.getTransaction(defaultTransactionDefinition);
        try {
            accountDao.update(out, money*-1);
            accountDao.update(in, money);
        }catch (Exception e){
            platformTransactionManager.rollback(transactionStatus);
        }
        platformTransactionManager.commit(transactionStatus);
    }
}
