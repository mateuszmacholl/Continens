package mateuszmacholl.continens.util

import org.springframework.stereotype.Service
import java.util.*

@Service
abstract class CrudServiceTemplate<Model: Entity, Id> {
    fun findById(id: Id): Model?{
        val model = getById(id)
        validatePresent(model)
        return model.get()
    }

    protected abstract fun getById(id: Id): Optional<Model>
    fun validatePresent(model: Optional<Model>){
        if(!model.isPresent){
            throw Exception("Resource not found") // TODO(dedicated exception)
        }
    }
}