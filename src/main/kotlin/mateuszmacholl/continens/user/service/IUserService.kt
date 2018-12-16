package mateuszmacholl.continens.user.service

import mateuszmacholl.continens.user.model.User
import mateuszmacholl.continens.util.CrudService

interface IUserService: CrudService<User, String> {
    fun findByUsername(username: String): User?
}