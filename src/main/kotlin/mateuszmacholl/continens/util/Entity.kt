package mateuszmacholl.continens.util

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id

abstract class Entity {
    @Id
     var id: ObjectId? = null
}