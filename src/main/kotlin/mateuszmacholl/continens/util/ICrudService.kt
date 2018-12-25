package mateuszmacholl.continens.util

interface ICrudService<Model: Entity, Id> {
    fun findById(id: Id): Model
    fun findAll(): List<Model>
    fun save(user: Model): Model
    fun delete(id: Id)
}