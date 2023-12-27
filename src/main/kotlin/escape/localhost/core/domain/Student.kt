package escape.localhost.core.domain

import jakarta.persistence.Entity

@Entity
class Student(
    name: String,
    password: String,
    email: String
) : BaseEntity() {

    var name: String = name
        protected set

    var password: String = password
        protected set

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
