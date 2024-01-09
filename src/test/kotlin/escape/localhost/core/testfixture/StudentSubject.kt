package escape.localhost.core.testfixture

import escape.localhost.core.domain.User

class StudentSubject {
    fun of(
        name: String = "홍길동",
        password: String = "123123123",
        email: String = "test@gmail.com",
    ): User {
        return User(name, password, email)
    }
}
