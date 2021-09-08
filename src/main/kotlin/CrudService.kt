interface CrudService<T> {

    fun add(item: T): T

    fun edit(item: T): Boolean

    fun delete(id: Int): Boolean
}