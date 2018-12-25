package mateuszmacholl.continens.util

import org.springframework.stereotype.Service

@Service
abstract class CrudServiceTemplate<Model: Entity, Id>: ICrudService<Model, Id> {
    final override fun findById(id: Id) = validatePresence(getById(id))

    fun validatePresence(model: Model?): Model {
        if(model == null){
            throw Exception("Resource not found") // TODO(dedicated exception)
        } else {
            return model
        }
    }
    abstract fun getById(id: Id): Model?
}