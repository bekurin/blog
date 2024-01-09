package escape.localhost.core.domain

import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToOne

@Entity
class Workout(
    routine: Routine,
    training: Training,
    repetition: Int,
    weight: Int,
) : BaseEntity() {
    var repetition: Int = repetition
        protected set

    var weight: Int = weight
        protected set

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "routine_id")
    var routine: Routine = routine
        protected set

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "training_id")
    var training: Training = training
        protected set
}
