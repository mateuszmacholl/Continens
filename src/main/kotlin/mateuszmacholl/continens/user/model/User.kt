package mateuszmacholl.continens.user.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection="user")
data class User(
        val username: String,
        val password: String
) {
    @Id
    var id: ObjectId? = null
    @DBRef
    var roles: List<Role> = listOf()
}