package escape.localhost.core.domain.repository

import escape.localhost.core.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface StudentRepository : JpaRepository<User, Long> {
    fun findByEmail(email: String): Optional<User>
}
