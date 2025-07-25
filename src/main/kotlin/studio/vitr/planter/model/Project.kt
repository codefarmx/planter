package studio.vitr.planter.model

import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "projects")
data class Project(
        @Id @GeneratedValue(strategy = GenerationType.UUID) val id: UUID? = null,
        @Version val version: Int? = null,
        val name: String,
        val githubRepositoryId: Long,
        val type: ProjectType,
        val createdAt: Long = System.currentTimeMillis(),

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id", nullable = false)
        @JsonManagedReference
        var user: User
)