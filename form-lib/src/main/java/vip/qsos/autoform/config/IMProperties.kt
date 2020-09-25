package vip.qsos.autoform.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "im.server")
open class IMProperties {
    lateinit var hostIp: String
    lateinit var hostName: String
    var port: Int = 23456
}