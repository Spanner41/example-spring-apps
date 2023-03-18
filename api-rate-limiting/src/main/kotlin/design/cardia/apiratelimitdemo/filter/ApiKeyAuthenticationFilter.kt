package design.cardia.apiratelimitdemo.filter

import design.cardia.apiratelimitdemo.model.ApiKeyAuthenticationToken
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter

class ApiKeyAuthenticationFilter(authenticationManager: AuthenticationManager) : AbstractAuthenticationProcessingFilter("/**") {
    init {
        this.authenticationManager = authenticationManager
    }

    override fun attemptAuthentication(request: HttpServletRequest, response: HttpServletResponse): Authentication {
        val apiKey = request.getHeader("X-Api-Key")
        val token = ApiKeyAuthenticationToken(apiKey)
        return authenticationManager.authenticate(token)
    }

    override fun successfulAuthentication(request: HttpServletRequest, response: HttpServletResponse, chain: FilterChain, authResult: Authentication) {
        SecurityContextHolder.getContext().authentication = authResult
        chain.doFilter(request, response)
    }
}