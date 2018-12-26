package mateuszmacholl.continens.util

class EntityValidator(private val entity: Entity?) {
    fun isNull(): Boolean{
        return entity == null
    }
}