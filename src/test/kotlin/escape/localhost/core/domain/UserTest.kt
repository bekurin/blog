package escape.localhost.core.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class UserTest {

    @Test
    fun `회원 생성을 할 때 이름이 2글자 미만인 경우 예외가 발생한다`() {
        // given
        val invalidName = "홍"
        val (password, email) = "123123123" to "test@gmail.com"

        // when & then
        assertThrows<IllegalStateException> {
            User(invalidName, password, email)
        }
    }

    @Test
    fun `회원 생성을 할 때 이메일에 @가 포함되지 않는 경우 예외가 발생한다`() {
        // given
        val invalidEmail = "testgmail.com"
        val (name, password) = "홍" to "123123123"

        // when & then
        assertThrows<IllegalStateException> {
            User(name, password, invalidEmail)
        }
    }
}
