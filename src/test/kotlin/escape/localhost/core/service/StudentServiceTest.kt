package escape.localhost.core.service

import escape.localhost.core.domain.Student
import escape.localhost.core.domain.repository.StudentRepository
import escape.localhost.core.testfixture.StudentSubject
import org.assertj.core.api.SoftAssertions
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito.any
import org.mockito.BDDMockito.given
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import java.util.*

@ExtendWith(MockitoExtension::class)
class StudentServiceTest {

    @InjectMocks
    private lateinit var sut: StudentService

    @Mock
    private lateinit var studentRepository: StudentRepository

    @Nested
    inner class `회원 등록을 할 때` {

        @Nested
        inner class `등록에 실패한다` {

            @Test
            fun `이미 존재하는 이메일인 경우`() {
                // given
                val duplicateEmail = "duplicate@gmail.com"
                val student = StudentSubject().of(email = duplicateEmail)
                given(studentRepository.findByEmail(duplicateEmail))
                    .willReturn(Optional.of(student))

                // when & then
                assertThrows<IllegalArgumentException> {
                    sut.registerStudent(student)
                }
            }
        }

        @Nested
        inner class `등록에 성공한다` {

            @Test
            fun `존재하지 않는 이메일인 경우`() {
                // given
                val student = StudentSubject().of()
                given(studentRepository.findByEmail(student.email))
                    .willReturn(Optional.empty())
                given(studentRepository.save(any(Student::class.java)))
                    .willReturn(student)

                // when
                val savedStudent = sut.registerStudent(student)

                // then
                SoftAssertions.assertSoftly { softly ->
                    softly.assertThat(savedStudent.name).isEqualTo(student.name)
                    softly.assertThat(savedStudent.email).isEqualTo(student.email)
                    softly.assertThat(savedStudent.password).isEqualTo(student.password)
                }
            }
        }
    }
}
