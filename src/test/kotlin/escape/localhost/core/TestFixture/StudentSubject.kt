package escape.localhost.core.TestFixture

import escape.localhost.core.domain.Student

class StudentSubject {
    fun of(
        name: String = "홍길동",
        password: String = "123123123",
        email: String = "test@gmail.com"
    ): Student {
        return Student(name, password, email)
    }
}
