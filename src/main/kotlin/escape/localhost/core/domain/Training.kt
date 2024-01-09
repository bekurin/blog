package escape.localhost.core.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
class Training(
    name: String,
    category: Category
) : BaseEntity() {
    @Column(nullable = false, length = 127)
    var name: String = name
        protected set

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id")
    var category: Category = category
        protected set
}
