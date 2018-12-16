package mateuszmacholl.continens.security.config

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer

@Configuration
class OAuth2ServerConfig {
    @Configuration
    @EnableResourceServer
    protected class ResourceServerConfiguration : ResourceServerConfigurerAdapter() {

        override fun configure(resources: ResourceServerSecurityConfigurer) {
            resources
                    .resourceId(RESOURCE_ID)
        }

        @Throws(Exception::class)
        override fun configure(http: HttpSecurity) {
            http
                    .authorizeRequests()
                    .antMatchers("/xxx").hasRole("ADMIN")
                    .antMatchers("/yyy").authenticated()
        }

    }
    companion object {
        const val RESOURCE_ID = "restservice"
    }
}