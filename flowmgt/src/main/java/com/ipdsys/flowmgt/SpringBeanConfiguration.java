package com.ipdsys.flowmgt;


import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;
import org.springframework.cloud.loadbalancer.core.ReactorLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.*;

@Configuration
@LoadBalancerClients(defaultConfiguration = {SpringBeanConfiguration.class})
public class SpringBeanConfiguration {

    Logger logger = LoggerFactory.getLogger(SpringBeanConfiguration.class);

    @Value("${LocalThreadPool.corePoolSize:4}")
    private int corePoolSize;
    @Value("${LocalThreadPool.maximumPoolSize:8}")
    private int maximumPoolSize;
    @Value("${LocalThreadPool.keepAliveTime:120}")
    private long keepAliveTime;

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    ReactorLoadBalancer<ServiceInstance> randomLoadBalancer(Environment environment,
                                                            LoadBalancerClientFactory loadBalancerClientFactory) {
        String name = environment.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);

        return new NacosSameClusterWeightedRule(loadBalancerClientFactory
                .getLazyProvider(name, ServiceInstanceListSupplier.class),
                name);
    }

    @Bean
    public ExecutorService ThreadExecutor(){
        ThreadFactory factory = new ThreadFactoryBuilder()
                .setNameFormat("LocalThreadPool-Thread-%d")
                .setUncaughtExceptionHandler((t, e) -> logger.error("%s execute fail!", t.getName(), e))
                .build();
        return new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(100),
                factory,
                new ThreadPoolExecutor.CallerRunsPolicy());
    }

}
