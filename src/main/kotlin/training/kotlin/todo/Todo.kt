package training.kotlin.todo

import javax.persistence.*

@Entity
@Table(name = "todo")
data class Todo(@Id @GeneratedValue(strategy=GenerationType.IDENTITY) var id: Int? = 0,
                @Column var name: String = "",
                @Column var done: Int = 0
)