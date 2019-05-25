package mateuszmacholl.continens.user.model

import mateuszmacholl.continens.util.Entity
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.security.core.GrantedAuthority

@Document(collection="role")
data class Role(
        val title: String
): GrantedAuthority, Entity() {
    override fun getAuthority() = name
}