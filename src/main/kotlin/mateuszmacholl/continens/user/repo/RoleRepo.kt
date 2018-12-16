package mateuszmacholl.continens.user.repo

import mateuszmacholl.continens.user.model.Role
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface RoleRepo: MongoRepository<Role, String> {
    fun findByName(name: String): Role?
}