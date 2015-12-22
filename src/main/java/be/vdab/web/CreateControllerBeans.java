package be.vdab.web;

import be.vdab.entities.Bestelbon;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author guillaume.vandecasteele on 17/12/2015 at 07:43.
 */
@Configuration
@ComponentScan
@EnableWebMvc
@EnableSpringDataWebSupport
public class CreateControllerBeans extends WebMvcConfigurerAdapter {

    /**
     * MessageSource bean: enables usage of text.properties in resources
     */
    @Bean
    MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:text");
        messageSource.setFallbackToSystemLocale(false);
        return messageSource;
    }

    /**
     * Purpose: not having to retype the path and extension to every view String
     */
    @Bean
    InternalResourceViewResolver resourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/JSP/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    /**
     * allows error messages to be reinterpreted through messages source
     */
    @Bean
    LocalValidatorFactoryBean validatorFactory() {
        LocalValidatorFactoryBean factory = new LocalValidatorFactoryBean();
        factory.setValidationMessageSource(messageSource());
        return factory;
    }

    /**
     * adds the css & img folders to spring's resources
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/**");
        registry.addResourceHandler("/css/**");
    }

    /**
     * Use validator produced by validatorbeanfactory
     */
    @Override
    public Validator getValidator() {
        return new SpringValidatorAdapter(validatorFactory().getValidator());
    }

    @Bean
    public Basket basket() {
        return new BasketImpl(new Bestelbon());
    }
}
