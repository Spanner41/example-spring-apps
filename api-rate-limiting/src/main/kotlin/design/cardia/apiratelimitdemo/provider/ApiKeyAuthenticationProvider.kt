package design.cardia.apiratelimitdemo.provider

import design.cardia.apiratelimitdemo.model.ApiKeyAuthenticationToken
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.InsufficientAuthenticationException
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import org.springframework.util.ObjectUtils

@Component
class ApiKeyAuthenticationProvider : AuthenticationProvider {
    override fun authenticate(authentication: Authentication): Authentication {
        val apiKey = authentication.principal as String?
        if (apiKey == null || ObjectUtils.isEmpty(apiKey)) {
            throw InsufficientAuthenticationException("No API key in request")
        } else {
            if (apiKey.endsWith("valid")) {
                return ApiKeyAuthenticationToken(apiKey, true)
            }
            throw BadCredentialsException("API Key is invalid")
        }
    }

    override fun supports(authentication: Class<*>) =
            ApiKeyAuthenticationToken::class.java.isAssignableFrom(authentication)
}