package escape.localhost.core.controller

import escape.localhost.core.dto.MenuResponse
import escape.localhost.core.service.MenuService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/menus")
class MenuController(
    private val menuService: MenuService
) {
    @GetMapping
    fun get(): MenuResponse {
        return menuService.getSideMenu()
    }
}
