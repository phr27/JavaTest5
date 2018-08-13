package com.hand.infra.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.hand.infra.util.PageResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.sql.DataSource;
import java.util.List;

@Configuration
@EnableConfigurationProperties
public class WebConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private DataSourceProperties dataSourceProperties;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        super.addArgumentResolvers(argumentResolvers);
        argumentResolvers.add(new PageResolver());
    }

    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername(System.getenv("USERNAME"));
        dataSource.setPassword(System.getenv("PASSWORD"));
        dataSource.setDriverClassName(dataSourceProperties.getDriverClassName());
        dataSource.setUrl(String.format(dataSourceProperties.getUrl(), System.getenv("MYSQL_IP"), System.getenv("MYSQL_PORT")));

        return dataSource;
    }
}
