package com.example.courserism.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestProperties;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.autoconfigure.web.HttpMessageConvertersAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.Order;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@ConditionalOnWebApplication
@AutoConfigureAfter({ HttpMessageConvertersAutoConfiguration.class,
        JacksonAutoConfiguration.class })
@EnableConfigurationProperties(RepositoryRestProperties.class)
@Import( RepositoryRestMvcConfiguration.class )
public class RepositoryConfiguration extends RepositoryRestMvcConfiguration
{
    @Override
    public RepositoryRestConfiguration config()
    {
        return new ExposeEntityIdRepositoryRestConfiguration( super.config() );
    }

    @Bean
    public SpringBootRepositoryRestConfigurer springBootRepositoryRestConfigurer()
    {
        return new SpringBootRepositoryRestConfigurer();
    }

    @Order( 0 )
    class SpringBootRepositoryRestConfigurer extends RepositoryRestConfigurerAdapter
    {

        @Autowired( required = false )
        private Jackson2ObjectMapperBuilder objectMapperBuilder;

        @Autowired
        private RepositoryRestProperties    properties;

        @Override
        public void configureRepositoryRestConfiguration( RepositoryRestConfiguration config )
        {
            this.properties.applyTo( config );
        }

        @Override
        public void configureJacksonObjectMapper( ObjectMapper objectMapper )
        {
            if ( this.objectMapperBuilder != null )
            {
                this.objectMapperBuilder.configure( objectMapper );
            }
        }

    }
}
