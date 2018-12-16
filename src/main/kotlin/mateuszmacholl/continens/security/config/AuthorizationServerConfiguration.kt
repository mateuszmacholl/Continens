package mateuszmacholl.continens.security.config

import mateuszmacholl.continens.user.service.CustomUserDetailsService
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer
import org.springframework.security.oauth2.provider.token.DefaultTokenServices
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore

@Configuration
@EnableAuthorizationServer
class AuthorizationServerConfiguration(
        @Qualifier("authenticationManagerBean")
        private val authenticationManager: AuthenticationManager,
        private val userDetailsService: CustomUserDetailsService) : AuthorizationServerConfigurerAdapter() {

    private val tokenStore = InMemoryTokenStore()

    @Throws(Exception::class)
    override fun configure(endpoints: AuthorizationServerEndpointsConfigurer) {
        endpoints
                .tokenStore(this.tokenStore)
                .authenticationManager(this.authenticationManager)
                .userDetailsService(userDetailsService)
    }

    @Throws(Exception::class)
    override fun configure(clients: ClientDetailsServiceConfigurer) {
        clients
                .inMemory()
                .withClient("clientapp")
                .authorizedGrantTypes("password", "refresh_token")
                .authorities("USER")
                .scopes("read", "write")
                .resourceIds(OAuth2ServerConfig.RESOURCE_ID)
                .secret("123456")
    }

    @Bean
    @Primary
    fun tokenServices(): DefaultTokenServices {
        val tokenServices = DefaultTokenServices()
        tokenServices.setSupportRefreshToken(true)
        tokenServices.setTokenStore(this.tokenStore)
        return tokenServices
    }

}
