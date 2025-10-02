package com.liang.springioc.FinishBeanFactoryInitialization;

import com.liang.springioc.bean.L629;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * ClassName: MyFactoryBean
 * Package: com.liang.springioc.FinishBeanFactoryInitialization
 * Description:
 *
 * @Author liang
 * @Create 2025/6/29 17:31
 * @Version jdk17.0
 */

public class MyFactoryBean implements FactoryBean<L629> {

    /**
     * 这个情况下 L629bean的名字为工厂bean的名字小写  myFactoryBean
     * @return
     * @throws Exception
     */
    @Override
    public L629 getObject() throws Exception {
        return new L629();
    }

    @Override
    public Class<?> getObjectType() {
        return L629.class;
    }
}
