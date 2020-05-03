package com.ibm.spring;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource(value = {"classpath:common.properties","classpath:oracle.properties"})
public class JLCConfig {

    @Autowired
    private Environment env;

    @Value("${ibm.pw}")
    private String password;

    @Value("${ibm.min}")
    private int min;

    @Value("${ibm.max}")
    private int max;

    @Value("${ibm.timeout}")
    private int timeout;


    @Bean(name="oracleDS")

    public DataSource oracleDataSource(@Value("${oracle.ds}") String driverClass, @Value("${oracle.url}") String url,
                                       @Value("${oracle.un}") String username)
    {
        DataSource ds = new DataSource();
        ds.setDriverClass(driverClass);
        ds.setUrl(url);
        ds.setMax(max);
        ds.setMin(min);
        ds.setPassword(password);
        ds.setTimeout(timeout);
        return ds;
    }


    @Bean

    public TestBean test()
    {
        return new TestBean();
    }


    @Bean

    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer()
    {
        return  new PropertySourcesPlaceholderConfigurer();
    }


}
