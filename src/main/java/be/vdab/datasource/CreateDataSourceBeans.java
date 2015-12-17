package be.vdab.datasource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;

import javax.sql.DataSource;

/**
 * @author guillaume.vandecasteele on 17/12/2015 at 07:45.
 */
@Configuration
public class CreateDataSourceBeans {

    @Bean
    DataSource dataSource() {
        return new JndiDataSourceLookup().getDataSource("jdbc/bierhuis");
    }
}
