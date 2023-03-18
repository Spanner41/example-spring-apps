package design.cardia.apiratelimitdemo.model

import org.springframework.security.authentication.AbstractAuthenticationToken
import org.springframework.security.core.Transient
import org.springframework.security.core.authority.AuthorityUtils

@Transient
class ApiKeyAuthenticationToken(
        private var apiKey: String? = null,
        authenticated: Boolean = false
) : AbstractAuthenticationToken(AuthorityUtils.NO_AUTHORITIES) {
    init {
        isAuthenticated = authenticated
    }

    override fun getCredentials(): Any? = null

    override fun getPrincipal(): Any? = apiKey
}