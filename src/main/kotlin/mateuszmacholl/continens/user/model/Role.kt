package mateuszmacholl.continens.user.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.security.core.GrantedAuthority

@Document(collection="role")
data class Role(
        val name: String
): GrantedAuthority {
    @Id
    var id: ObjectId? = null

    override fun getAuthority() = name
}