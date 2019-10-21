package com.netease.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Order(Ordered.HIGHEST_PRECEDENCE)// 数越小，对应加载顺序优先级越高。
@Configuration  // 等同于spring的XML配置文件；使用Java代码可以检查 类型安全。
@EnableTransactionManagement(proxyTargetClass = true)
@EnableJpaRepositories(basePackages = "com.netease.dao") // 扫描dao层，Repository
@EntityScan(basePackages = "com.netease.domain") // 扫描pojo层，实体类
public class JpaConfiguration {/* JPA 配置类 */
    /* 类似SSM架构下，spring需要配置Java POJO类包路径以及DAO层接口路径，以自动扫描相关注解，这里同样需要配置这两项，不同的是Spring采取的是xml配置方式，这里用Java代码+注解方式配置。*/
    @Bean
    PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor() {
        return new PersistenceExceptionTranslationPostProcessor();
    }
}
