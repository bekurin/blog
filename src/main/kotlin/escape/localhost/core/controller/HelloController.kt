package escape.localhost.core.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {
    @GetMapping("/hello")
    fun hello(): Map<String, String> {
        return mapOf("message" to "hello world")
    }
}
