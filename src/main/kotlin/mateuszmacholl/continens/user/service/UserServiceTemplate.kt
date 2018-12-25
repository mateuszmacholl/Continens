package mateuszmacholl.continens.user.service

import mateuszmacholl.continens.user.model.User
import mateuszmacholl.continens.util.CrudServiceTemplate
import org.springframework.stereotype.Service

@Service
abstract class UserServiceTemplate: CrudServiceTemplate<User, String>() {
    final fun findByUsername(username: String) = validatePresence(getByUsername(username))
    abstract fun getByUsername(username: String): User?
}