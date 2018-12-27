package mateuszmacholl.continens.util

import org.springframework.stereotype.Service

@Service
abstract class CrudServiceTemplate<Model: Entity, Id> {
    final fun findById(id: Id) = validate(getById(id))

    fun validate(model: Model?): Model {
        if(model == null){
            throw Exception("Resource not found") // TODO(dedicated exception)
        } else {
            return model
        }
    }
    abstract fun getById(id: Id): Model?
}