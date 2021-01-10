package org.atech.dbi.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.*;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 多租户,动态表名
 * 分页,乐观锁
 * sql性能规范,防止全表更新与删除
 */

@Configuration
@MapperScan("org.atech.dbi.mapper")
public class MybatisPlusConfig {

    /**
     * 自动分页: PaginationInnerInterceptor
     * 多租户: TenantLineInnerInterceptor
     * 动态表名: DynamicTableNameInnerInterceptor
     * 乐观锁: OptimisticLockerInnerInterceptor
     * sql性能规范: IllegalSQLInnerInterceptor
     * 防止全表更新与删除: BlockAttackInnerInterceptor
     *
     * 新的分页插件,一缓和二缓遵循mybatis的规则,需要设置 MybatisConfiguration#useDeprecatedExecutor = false 避免缓存出现问题
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
//        interceptor.addInnerInterceptor(new TenantLineInnerInterceptor());
//        interceptor.addInnerInterceptor(new DynamicTableNameInnerInterceptor());
        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
//        interceptor.addInnerInterceptor(new IllegalSQLInnerInterceptor());
        interceptor.addInnerInterceptor(new BlockAttackInnerInterceptor());

        return interceptor;
    }

    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return configuration -> configuration.setUseDeprecatedExecutor(false);
    }


}
