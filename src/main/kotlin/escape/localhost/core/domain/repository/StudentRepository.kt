package escape.localhost.core.domain.repository

import escape.localhost.core.domain.Student
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface StudentRepository : JpaRepository<Student, Long> {
    fun findByEmail(email: String): Optional<Student>
}
