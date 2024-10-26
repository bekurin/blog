package escape.localhost.core.service

import escape.localhost.core.dto.MenuResponse
import escape.localhost.core.dto.MenuResponse.Menu
import escape.localhost.core.dto.MenuResponse.MenuType.GROUP
import escape.localhost.core.dto.MenuResponse.MenuType.ROUTE
import org.springframework.stereotype.Service

@Service
class MenuService {
    fun getSideMenu(): MenuResponse {
        val menus = listOf(
            Menu("회원 관리", ROUTE, "/users", "USER"),
            Menu("강의 관리", ROUTE, "/users", "COURSE"),
            Menu("강사 관리", ROUTE, "/users", "TEACHER"),
        )
        return MenuResponse(
            label = "일반",
            type = GROUP,
            menus = menus
        )
    }
}
