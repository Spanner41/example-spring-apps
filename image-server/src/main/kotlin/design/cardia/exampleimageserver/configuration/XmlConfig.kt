package design.cardia.exampleimageserver.configuration

import design.cardia.ktxml.printer.CompressedFormat
import design.cardia.ktxml.printer.PrettyFormat
import design.cardia.ktxml.printer.XmlPrinter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

@Configuration
class XmlConfig {
    @Bean
    @Profile("production")
    fun xmlFormatProd() = CompressedFormat()

    @Bean
    @Profile("!production")
    fun xmlFormatNonProd() = PrettyFormat()

    @Bean
    fun xmlPrinter() = XmlPrinter()
}