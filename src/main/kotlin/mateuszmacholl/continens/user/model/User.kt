package mateuszmacholl.continens.user.model

import mateuszmacholl.continens.util.Entity
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "user")
data class User(
        val username: String,
        val password: String
) : Entity() {
    @DBRef
    var roles: List<Role> = listOf()
}