package mateuszmacholl.continens.user.service

import mateuszmacholl.continens.user.model.User
import mateuszmacholl.continens.user.repo.UserRepo
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepo: UserRepo) : IUserService {
    override fun findById(id: String): User? {
        val user = userRepo.findById(id)
        return if(user.isPresent){
            user.get()
        } else {
            null
        }
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