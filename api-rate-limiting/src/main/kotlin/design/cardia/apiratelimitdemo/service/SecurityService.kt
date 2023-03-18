package design.cardia.apiratelimitdemo.service

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service


@Service
class SecurityService {
    fun apiKey() = SecurityContextHolder.getContext().authentication?.principal
}