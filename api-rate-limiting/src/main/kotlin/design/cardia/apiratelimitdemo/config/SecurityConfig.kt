package design.cardia.apiratelimitdemo.config

import design.cardia.apiratelimitdemo.filter.ApiKeyAuthenticationFilter
import design.cardia.apiratelimitdemo.provider.ApiKeyAuthenticationProvider
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.ProviderManager
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val apiKeyAuthenticationProvider: ApiKeyAuthenticationProvider
) {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .authorizeHttpRequests()
            .anyRequest()
            .authenticated()
            .and()
            .addFilterBefore(
                ApiKeyAuthenticationFilter(authenticationManager()),
                AnonymousAuthenticationFilter::class.java
            )
        return http.build()
    }

    @Bean
    fun authenticationManager() =
        ProviderManager(listOf<AuthenticationProvider?>(apiKeyAuthenticationProvider))
}