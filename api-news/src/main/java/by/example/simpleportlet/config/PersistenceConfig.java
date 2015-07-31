package by.example.simpleportlet.config;

import org.hibernate.ejb.HibernatePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

@Configuration
@ComponentScan("by.example.simpleportlet.dao.domain")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages="by.example.simpleportlet.dao.jpa")
public class PersistenceConfig
{
    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory()
        throws
            SQLException,
            NamingException
    {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistence.class);
        entityManagerFactoryBean.setPackagesToScan("by.example.simpleportlet.dao.domain");
        
        entityManagerFactoryBean.setJpaProperties(hibernateProperties());

        return entityManagerFactoryBean;
    }

//    @Bean(name = "dataSource")
//    public DataSource dataSource()
//    {
//        final JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
//        dsLookup.setResourceRef(true);
//        return dsLookup.getDataSource(env.getProperty("jdbc.jndiDatasource"));
//    }

    @Bean(name = "dataSource")
    public DataSource dataSource() {
        DriverManagerDataSource toReturn = new DriverManagerDataSource("jdbc:mysql://localhost:3306/lportal",
                "lportaluser", "12345");
        toReturn.setDriverClassName("com.mysql.jdbc.Driver");
        return toReturn;
    }



    @Bean
    public JpaTransactionManager transactionManager()
        throws
            SQLException,
            NamingException
    {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

        return transactionManager;
    }

    @Bean
    public HibernateExceptionTranslator hibernateExceptionTranslator()
    {
        return new HibernateExceptionTranslator();
    }

    private Properties hibernateProperties()
    {
        Properties hibernateProperties = new Properties();
        hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
        hibernateProperties.put("hibernate.hbm2ddl.auto", "create");
        hibernateProperties.put("hibernate.show_sql", "true");
//        hibernateProperties.put("hibernate.format_sql", "true");
//        hibernateProperties.put("hibernate.id.new_generator_mappings", "true");
        hibernateProperties.put("hibernate.default_schema", "lportal");

        return hibernateProperties;
    }

}
