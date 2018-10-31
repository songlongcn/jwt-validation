package config.spring.security

import org.codehaus.groovy.grails.commons.GrailsApplication
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer

/**
 * Created by michael.song on 10/30/2018 for jwt-validation
 */
@Configuration
@EnableResourceServer
class ResourceServerConfigure extends ResourceServerConfigurerAdapter{

    static String RESOURCE_ID = 'j2-corp-admin'

    @Autowired
    GrailsApplication grailsApplication

    @Override
    public void configure(ResourceServerSecurityConfigurer resources){
        resources.resourceId(RESOURCE_ID).accessDeniedHandler(customAccessDeniedHandler()).authenticationEntryPoint(customAuthenticationEntryPoint());
    }

    @Override
    public void configure(HttpSecurity http) throws Exception{
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        http.authorizeRequests().antMatchers("").permitAll()
        .antMatchers("").permitAll()
    }

}
