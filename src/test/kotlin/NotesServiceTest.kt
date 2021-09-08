import org.junit.Test

import org.junit.Assert.*

class NotesServiceTest {

    @Test
    fun add() {
        val service = NotesService()
        val original = service.add(Note("Заметка", "Текст"))
        val expected = original.copy(id = 1)
        assertEquals(expected, original)

    }

    @Test
    fun editTrue() {
        val service = NotesService()
        val original = Note("Заметка", "Текст")
        service.add(original)
        val edited = Note("Заметка", "Текст редактированный", 1)
        val result = service.edit(edited)
        assertTrue(result)
    }

    @Test
    fun editFalse() {
        val service = NotesService()
        val original = Note("Заметка", "Текст")
        service.add(original)
        val edited = Note("Заметка", "Текст редактированный", 2)
        val result = service.edit(edited)
        assertFalse(result)
    }

    @Test
    fun deleteTrue() {
        val service = NotesService()
        val original = Note("Заметка", "Текст")
        service.add(original)
        val result = service.delete(1)
        assertTrue(result)
    }

    @Test
    fun deleteFalse() {
        val service = NotesService()
        val original = Note("Заметка", "Текст")
        service.add(original)
        val result = service.delete(2)
        assertFalse(result)
    }

    @Test
    fun getById() {
        val service = NotesService()
        val original = service.add(Note("Заметка", "Текст"))
        val expected = service.getById(1)
        assertEquals(expected[0], original)
    }
}