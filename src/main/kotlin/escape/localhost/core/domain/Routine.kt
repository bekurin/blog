package escape.localhost.core.domain

import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.OneToMany
import jakarta.persistence.OneToOne

@Entity
class Routine(
    user: User,
    name: String
) : BaseEntity() {

    var name: String = name
        protected set

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    var user: User = user
        protected set

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "routine")
    var workouts: MutableList<Workout> = mutableListOf()
        protected set
}
