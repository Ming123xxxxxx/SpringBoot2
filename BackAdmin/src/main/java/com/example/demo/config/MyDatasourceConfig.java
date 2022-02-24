package com.example.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2022/1/24 10:03
 */
@Deprecated
//@Configuration
public class MyDatasourceConfig {

    //默认的自动配置是判断容器中没有才会配@ConditionalOnMissingBean(DataSource.class)
    //此配置会让此方法的属性与配置文件中的属性绑定
//    @ConfigurationProperties("spring.datasource")
//    @Bean
    public DataSource dataSource() throws SQLException {

        DruidDataSource druidDataSource  = new DruidDataSource();
//        druidDataSource.setFilters("stat,wall"); //stat加入监控功能,wall加入防火墙功能
        return druidDataSource;
    }

    //配置druid的监控页功能
//    @Bean
    public ServletRegistrationBean statViewServlet(){

        StatViewServlet statViewServlet = new StatViewServlet();
        ServletRegistrationBean<StatViewServlet> statViewServletServletRegistrationBean = new ServletRegistrationBean<>(statViewServlet, "/druid/*");
        statViewServletServletRegistrationBean.addInitParameter("loginUsername","admin");//设置监控页的账号名
        statViewServletServletRegistrationBean.addInitParameter("loginPassword","12345");//设置监控页的密码
        return statViewServletServletRegistrationBean;
    }

//    @Bean
    //WebStatFilter用于采集web-jdbc关联监控的数据
    public FilterRegistrationBean webStatFilter(){
        WebStatFilter webStatFilter = new WebStatFilter();
        FilterRegistrationBean<WebStatFilter> registrationBean = new FilterRegistrationBean<>(webStatFilter);
        registrationBean.setUrlPatterns(Arrays.asList("/*"));
        registrationBean.addInitParameter("exclutions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return registrationBean;
    }
}
