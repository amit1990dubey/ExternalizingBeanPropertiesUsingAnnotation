package com.ibm.spring;

import javax.annotation.Resource;

public class TestBean {

    @Resource(name = "oracleDS")
    DataSource oracleDataSource;

    public void show()
    {
        System.out.println(oracleDataSource);
    }
}
