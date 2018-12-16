package mateuszmacholl.continens.util

interface CrudService<Model, Id> {
    fun findById(id: Id): Model?
    fun findAll(): List<Model>
    fun save(user: Model): Model
    fun delete(id: Id)
}