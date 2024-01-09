package escape.localhost.core.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity

@Entity
class User(
    name: String,
    password: String,
    email: String,
) : BaseEntity() {

    @Column(nullable = false, length = 127)
    var name: String = name
        protected set

    @Column(nullable = false, length = 255)
    var password: String = password
        protected set

    @Column(nullable = false, length = 127)
    var email: String = email
        protected set

    init {
        if (name.length < 2) {
            throw IllegalStateException("이름은 최소 2글자 이상이여야 합니다.")
        }
        if (email.contains("@").not()) {
            throw IllegalStateException("이메일 형식이 올바르지 않습니다.")
        }
    }
}
