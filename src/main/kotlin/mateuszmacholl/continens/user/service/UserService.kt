package mateuszmacholl.continens.user.service

import mateuszmacholl.continens.user.model.User
import mateuszmacholl.continens.user.repo.UserRepo
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepo: UserRepo): UserServiceTemplate(), IUserService {
    override fun findAll() = userRepo.findAll().toList()
    override fun save(user: User) = userRepo.save(user)
    override fun delete(id: String) = userRepo.deleteById(id)
    override fun getByUsername(username: String) = userRepo.findByUsername(username)
    override fun getById(id: String): User? = userRepo.findById(id).orElse(null)
}