package it.michele;

import java.sql.*;
import javax.sql.DataSource;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import it.michele.security.SecurityConfig;

@Configuration
@ComponentScan(basePackages = "it.michele")
@EnableWebMvc
@Import(value = {SecurityConfig.class })
public class ApplicationConfiguration implements WebMvcConfigurer  {

	//Permette di vedere le pagine di stile, immagini e js.
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/css/**").addResourceLocations("/css/*");
        registry.addResourceHandler("/img/**").addResourceLocations("/img/*");
        registry.addResourceHandler("/js/**").addResourceLocations("/js/*");
        registry.addResourceHandler("/components/**").addResourceLocations("/components/");
        registry.addResourceHandler("/application/**").addResourceLocations("/application/");
        registry.addResourceHandler("/template/**").addResourceLocations("/template/");
        // Serve per far girare rest.html
        registry.addResourceHandler("/**").addResourceLocations("/");
    }
	
	// Serve per consentire l'accesso ad un servizio web fuori dal
	// proprio dominio (server).
	@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }
	
	//permette di vedere le pagine in resources, quindi le validazione
	@Bean
	public MessageSource messageSource() {

		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
	    messageSource.setBasename("classpath:application-resource");
	    messageSource.setCacheSeconds(10);

	    return messageSource;
	}
	
	@Bean
	public DataSourceTransactionManager txManager() throws SQLException {
	    return new DataSourceTransactionManager(dataSource());
	}

	@Bean
	public DataSource dataSource() throws SQLException {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/michieledb");
		dataSource.setUsername("root");
		dataSource.setPassword("Ny.rk@aDlpRKXX7x");
		dataSource.getConnection().setAutoCommit(false);

		return dataSource;
	}

	@Bean
	public ViewResolver configureViewResolver() {

		InternalResourceViewResolver viewResolve = new InternalResourceViewResolver();
		viewResolve.setViewClass(JstlView.class);
		viewResolve.setPrefix("/WEB-INF/pages/");
		viewResolve.setSuffix(".jsp");
		viewResolve.setExposeContextBeansAsAttributes(true);
		//registry.viewResolver(viewResolve);
		return viewResolve;
	}
	
}