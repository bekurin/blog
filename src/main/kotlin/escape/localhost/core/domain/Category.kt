package escape.localhost.core.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.OneToMany

@Entity
class Category(
    name: String,
) : BaseEntity() {
    @Column(nullable = false, length = 127)
    var name: String = name
        protected set

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    var trainings: MutableList<Training> = mutableListOf()
        protected set
}
