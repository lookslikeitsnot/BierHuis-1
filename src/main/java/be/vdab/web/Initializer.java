package be.vdab.web;
/**
 * @author guillaume.vandecasteele on 17/12/2015 at 07:42.
 */

import be.vdab.dao.CreateDAOBeans;
import be.vdab.datasource.CreateDataSourceBeans;
import be.vdab.services.CreateServiceBeans;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

public class Initializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{CreateDAOBeans.class, CreateDataSourceBeans.class, CreateServiceBeans.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{CreateControllerBeans.class};
    }

    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter utf8Filter = new CharacterEncodingFilter();
        utf8Filter.setEncoding("UTF-8");
        return new Filter[]{utf8Filter, new OpenEntityManagerInViewFilter()};
    }
}