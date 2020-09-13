/*
@author Andrei Gorevoi
*/
package deathvalley.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:database.properties")
public class HibernateConfig {

    @Autowired
    private Environment environment;

    @Bean
    public DataSource getDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(environment.getProperty("url"));
        dataSource.setUsername(environment.getProperty("login"));
        dataSource.setPassword(environment.getProperty("password"));
        dataSource.setDriverClassName(environment.getProperty("driver"));
        return dataSource;
    }

    private Properties getHibernateProperties(){
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
        hibernateProperties.setProperty("hibernate.show_sql", "true");
        hibernateProperties.setProperty("hibernate.format_sql", "true");
        hibernateProperties.setProperty("hibernate.use_sql_comments", "true");
        return hibernateProperties;
    }

    @Bean
    public LocalSessionFactoryBean localSessionFactoryBean(){
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(getDataSource());
        localSessionFactoryBean.setPackagesToScan("deathvalley.model");
        localSessionFactoryBean.setHibernateProperties(getHibernateProperties());
        return localSessionFactoryBean;
    }

    @Bean
    public PlatformTransactionManager transactionManager(){
        HibernateTransactionManager tm = new HibernateTransactionManager();
        tm.setSessionFactory(localSessionFactoryBean().getObject());
        return tm;
    }
}
