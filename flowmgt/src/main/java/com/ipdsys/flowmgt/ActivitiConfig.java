package com.ipdsys.flowmgt;

import net.sf.jsqlparser.util.validation.feature.DatabaseType;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import javax.sql.DataSource;

@Configuration
public class ActivitiConfig {

//    @Autowired
//    private DataSource dataSource;
    @Autowired
    private ApplicationContext applicationContext;

    @Bean
    public UserDetailsService getUserDetailsService(){
        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
        return userDetailsManager;
    }

//    @Bean
//    public StandaloneProcessEngineConfiguration processEngineConfiguration() throws Exception {
//        StandaloneProcessEngineConfiguration config = new StandaloneProcessEngineConfiguration();
//        DataSource dataSource = applicationContext.getBean(DataSource.class);
//        config.setDataSource(dataSource);
//        config.setDatabaseType(DatabaseType.MYSQL.getName());
//        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//        sessionFactory.setDataSource(dataSource);
//        config.setSqlSessionFactory(sessionFactory.getObject());
//        config.setDatabaseTablePrefix("act_");
//        return config;
//    }

//    @Bean
//    public ProcessEngine processEngine() throws Exception {
//        StandaloneProcessEngineConfiguration config = new StandaloneProcessEngineConfiguration();
//        DataSource dataSource = applicationContext.getBean(DataSource.class);
//        config.setDataSource(dataSource);
//        config.setDatabaseType(DatabaseType.MYSQL.getName());
//        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//        sessionFactory.setDataSource(dataSource);
//        config.setSqlSessionFactory(sessionFactory.getObject());
//        config.setDatabaseTablePrefix("act_");
//        ProcessEngine processEngine = config.buildProcessEngine();
//        return processEngine;
//    }
}
