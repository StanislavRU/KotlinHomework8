data class Comment(val noteId: Int, val text: String, val id: Int = 0, val deleted: Boolean = false)

class CommentsService: CrudService<Comment> {
    private var comments = mutableListOf<Comment>()
    private var nextId = 0

    override fun add(item: Comment): Comment {
        val itemEdit = item.copy(id = ++nextId)
        comments.add(itemEdit)
        println("Комментарий добавлен")
        return comments.last()
    }

    override fun delete(id: Int): Boolean {
        val find = comments.find { it.id == id }
        if (find != null && !find.deleted) {
            val itemEdit = find.copy(deleted = true)
            comments.remove(find)
            comments.add(itemEdit)
            println("Комментарий удален")
            return true
        }
        println("Комментарий не найден")
        return false
    }

    override fun edit(item: Comment): Boolean {
        val find = comments.find { it.id == item.id }
        if (find != null) {
            val itemEdit = find.copy(text = item.text)
            comments.remove(find)
            comments.add(itemEdit)
            println("Комментарий отредактирован")
            return true
        }
        println("Комментарий не найден")
        return false
    }

    fun restoreComment(id: Int): Boolean {
        val find = comments.find { it.id == id }
        if (find != null && find.deleted) {
            val itemEdit = find.copy(deleted = false)
            comments.remove(find)
            comments.add(itemEdit)
            println("Комментарий восстановлен")
            return true
        }
        println("Комментарий не найден")
        return false
    }

    fun getComments(noteId: Int): List<Comment> {
        val filter = comments.filter { !it.deleted; it.noteId == noteId }
        if (filter.isEmpty()) {
            println("Комментариев с данным id заметки не найдены")
        }
        return filter
    }
}