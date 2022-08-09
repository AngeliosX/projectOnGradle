package com.gradle.gradle.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class DataConfig {
    public static String url;
    private static String userName;
    private static String password;

    @Autowired
    public DataConfig(@Value("${spring.datasource.url}") String url, @Value("${spring.datasource.username}") String userName,
                      @Value("${spring.datasource.password}") String password) {
        DataConfig.url = url;
        DataConfig.userName = userName;
        DataConfig.password = password;
    }


    public static Properties getConnectionProps() {
        Properties props = new Properties();
        props.setProperty("user", userName);
        props.setProperty("password", password);
        return props;
    }
}
