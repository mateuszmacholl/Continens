package mateuszmacholl.continens.user.service

import mateuszmacholl.continens.user.repo.UserRepo
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service


@Service(value = "CustomUserDetailsService")
class CustomUserDetailsService(private val userRepo: UserRepo) : UserDetailsService {

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails {
        val user = userRepo.findByUsername(username)
                ?: throw UsernameNotFoundException("User: $username does not exist!")
        return org.springframework.security.core.userdetails.User(user.username,
                user.password, true, true,
                true, true,
                listOf(user.roles))
    }
}