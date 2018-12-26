package mateuszmacholl.continens.user.service

import mateuszmacholl.continens.user.model.User
import mateuszmacholl.continens.util.ICrudService

interface IUserService: ICrudService<User, String> {
    fun findByUsername(username: String): User
}