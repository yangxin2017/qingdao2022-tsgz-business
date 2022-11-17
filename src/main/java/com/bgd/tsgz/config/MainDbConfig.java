package com.bgd.tsgz.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.bgd.tsgz.mapper*", sqlSessionFactoryRef = "mainSqlSessionFactory")
public class MainDbConfig {
    @Primary
    @Bean(name = "mainDataSource")
    @ConfigurationProperties(prefix = "dbconfig.maindb") //获取application.yml里面的配置信息
    public DataSource druidDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "mainTransactionManager")
    public DataSourceTransactionManager masterTransactionManager(@Qualifier(value = "mainDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Primary
    @Bean(name = "mainSqlSessionFactory")
    @ConfigurationPropertiesBinding()
    public SqlSessionFactory sqlSessionFactory(@Qualifier(value = "mainDataSource") DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean factoryBean = new MybatisSqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        return factoryBean.getObject();
    }
}