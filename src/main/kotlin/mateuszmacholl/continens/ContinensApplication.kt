package mateuszmacholl.continens

import mateuszmacholl.continens.user.model.Role
import mateuszmacholl.continens.user.model.User
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.MongoTemplate

@SpringBootApplication
class ContinensApplication(private val mongoTemplate: MongoTemplate,
                           private val mongoOperations: MongoOperations) {

    fun dropDatabase() {
        mongoTemplate.db.drop()
    }
    fun saveInitialData() {
        val adminRole = Role("admin")
        mongoOperations.save(adminRole)
        val user = User("root", "root")
        user.roles = listOf(adminRole)
        mongoOperations.save(user)
    }

    @Bean
    fun init(){
        dropDatabase()
        saveInitialData()
    }
}

fun main(args: Array<String>) {
    runApplication<ContinensApplication>(*args)
}
