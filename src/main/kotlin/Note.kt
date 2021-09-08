data class Note(val title: String, val text: String, val id: Int = 0)

class NotesService: CrudService<Note> {
    private var notes = mutableListOf<Note>()
    private var nextId = 0

    override fun add(item: Note): Note {
        val itemEdit = item.copy(id = ++nextId)
        notes.add(itemEdit)
        println("Заметка добавлена")
        return notes.last()
    }

    override fun edit(item: Note): Boolean {
        val find = notes.find { it.id == item.id }?.copy(title = item.title, text = item.text)
        if (find == null) {
            notes
            println("Заметка не найдена")
            return false
        }
        notes.remove(find)
        println("Заметка отредактирована")
        return true
    }

    override fun delete(id: Int): Boolean {
        val find = notes.find { it.id == id }
        if (find != null) {
            notes.remove(find)
            println("Заметка удалена")
            return true
        }
        println("Заметка не найдена")
        return false
    }

    fun getById(id: Int): List<Note> {
        val filter = notes.filter { it.id == id }
        if (filter.isEmpty()) {
            println("Заметка с данным id не найдена")
        }
        return filter
    }
}