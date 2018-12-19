package mateuszmacholl.continens.user.service

import mateuszmacholl.continens.user.model.User
import mateuszmacholl.continens.user.repo.UserRepo
import mateuszmacholl.continens.util.CrudServiceTemplate
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(private val userRepo: UserRepo) : IUserService, CrudServiceTemplate<User, String>() {
    override fun getById(id: String): Optional<User> {
       return userRepo.findById(id)
    }

    override fun findByUsername(username: String): User? {
        return userRepo.findByUsername(username)
    }

    override fun findAll(): List<User>{
        return userRepo.findAll()
    }

    override fun save(user: User): User {
        return userRepo.save(user)
    }

    override fun delete(id: String){
        userRepo.deleteById(id)
    }
}