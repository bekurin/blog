package escape.localhost.core.dto

data class MenuResponse(
    val label: String,
    val type: MenuType,
    val menus: List<Menu>
) {
    enum class MenuType(private val description: String) {
        GROUP("그룹핑 메뉴"),
        ROUTE("단일 메뉴"),
    }

    data class Menu(
        val label: String,
        val type: MenuType,
        val path: String,
        val component: String
    )
}
