package com.nganle.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import com.nganle.controller.aop.AdminAspect;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.nganle"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class WebConfig extends WebMvcConfigurerAdapter {

	@Bean
	public TilesConfigurer configTile() {
		TilesConfigurer tileConfig = new TilesConfigurer();
		tileConfig.setDefinitions(new String[] { "/WEB-INF/tiles.xml","/*/tiles.xml","*/tiles.xml" });
		return tileConfig;
	}
	
	@Bean
	public StandardServletMultipartResolver multipartResolver() {
	    return new StandardServletMultipartResolver();
	}
	
	 
    @Bean
    public AdminAspect createValidate() {
    	return new AdminAspect();
    }

	 /**
     * Configure ViewResolvers to deliver preferred views.
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        TilesViewResolver viewResolver = new TilesViewResolver();
        registry.viewResolver(viewResolver);
    }
     
    /**
     * Configure ResourceHandlers to serve static resources like CSS/ Javascript etc...
     */
     
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	registry
        .addResourceHandler("/resources/**")
        .addResourceLocations("/resources/"); 
    }
   

}
