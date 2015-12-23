package be.vdab.datasource;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

/**
 * @author guillaume.vandecasteele on 17/12/2015 at 07:45.
 */
@Configuration
@PropertySource("classpath:/dao.properties")
public class CreateDataSourceBean {
    @Autowired
    private Environment environment;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    /**
     * Datasource bean: returns a datasource for local db unless it detects openshift environment variables
     *
     * @return DataSource
     */
    @Bean
    DataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        if (environment.containsProperty("OPENSHIFT_MYSQL_DB_HOST")) {
            dataSource.setJdbcUrl("jdbc:mysql://"
                    + environment.getProperty("OPENSHIFT_MYSQL_DB_HOST") + ":"
                    + environment.getProperty("OPENSHIFT_MYSQL_DB_PORT") + "/"
                    + environment.getProperty("openshift.database"));
            dataSource.setDriverClassName(environment.getProperty("openshift.driverClassName"));
            dataSource.setUsername(environment.getProperty("OPENSHIFT_MYSQL_DB_USERNAME"));
            dataSource.setPassword(environment.getProperty("OPENSHIFT_MYSQL_DB_PASSWORD"));

        } else {
            dataSource.setDriverClassName(environment.getProperty("local.driverClassName"));
            dataSource.setJdbcUrl(environment.getProperty("local.jdbcURL"));
            dataSource.setUsername(environment.getProperty("local.userName"));
            dataSource.setPassword(environment.getProperty("local.password"));
        }
        return dataSource;
    }
}
