package mateuszmacholl.continens.user.repo

import mateuszmacholl.continens.user.model.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepo: MongoRepository<User, String> {
    fun findByUsername(username: String): User?
}