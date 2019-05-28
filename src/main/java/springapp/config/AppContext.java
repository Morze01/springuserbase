package springapp.config;

import java.util.Properties;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springapp.dao.InitialDataLoader;

@Configuration
@PropertySource("classpath:database.properties")
@EnableTransactionManagement
@ComponentScan(basePackages = {
        "springapp"
})
public class AppContext {

    private final Environment environment;

    @Autowired
    public AppContext(Environment environment) {
        this.environment = environment;
    }


    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan("springapp.model");
        Properties properties = new Properties();
        properties.put("hibernate.dialect",environment.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql",environment.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.hbm2ddl.auto",environment.getRequiredProperty("hibernate.hbm2ddl.auto"));

        entityManagerFactoryBean.setJpaProperties(properties);
        return entityManagerFactoryBean;
    }


//    @Bean
//    public HibernateJpaVendorAdapter hibernateJpaVendorAdapter() {
//        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
//        hibernateJpaVendorAdapter.setGenerateDdl(Boolean.parseBoolean(environment.getRequiredProperty("JpaVendorAdapter.generateDll")));
//        hibernateJpaVendorAdapter.setShowSql(Boolean.parseBoolean(environment.getRequiredProperty("JpaVendorAdapter.show_sql")));
//        return hibernateJpaVendorAdapter;
//    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
        dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
        dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
        return dataSource;
    }


    //@Autowired
    @Bean
    public JpaTransactionManager getJpaTransactionManager(EntityManagerFactory entityManagerFactory){
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);


        return jpaTransactionManager;
    }

//    @Autowired
//    @Bean
//    public InitialDataLoader setInitialDataToUsersTable (EntityManagerFactory entityManagerFactory) {
//        InitialDataLoader initialDataLoader = new InitialDataLoader(entityManagerFactory.createEntityManager());
//        //initialDataLoader.InitialFillingUsersTable();
//        return initialDataLoader;
//    }
}
