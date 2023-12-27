package escape.localhost.core.service

import escape.localhost.core.domain.Student
import escape.localhost.core.domain.repository.StudentRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class StudentService(
    private val studentRepository: StudentRepository
) {

    @Transactional
    fun registerStudent(student: Student): Student {
        studentRepository.findByEmail(student.email)
            .ifPresent { throw IllegalArgumentException("중복된 이메일이 존재합니다.") }
        return studentRepository.save(student)
    }
}
