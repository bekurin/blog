package escape.localhost.core.service

import escape.localhost.core.domain.User
import escape.localhost.core.domain.repository.StudentRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(
    private val studentRepository: StudentRepository,
) {
    @Transactional
    fun register(user: User): User {
        studentRepository.findByEmail(user.email)
            .ifPresent { throw IllegalArgumentException("중복된 이메일이 존재합니다.") }
        return studentRepository.save(user)
    }
}
