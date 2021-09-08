import org.junit.Test

import org.junit.Assert.*

class CommentsServiceTest {

    @Test
    fun add() {
        val commentsService = CommentsService()
        val original = commentsService.add(Comment(1,"Текст комментария"))
        val expected = original.copy(id = 1)
        assertEquals(expected, original)
    }

    @Test
    fun deleteTrue() {
        val commentsService = CommentsService()
        commentsService.add(Comment(2,"Текст комментария"))
        val result = commentsService.delete(1)
        assertTrue(result)
    }

    @Test
    fun deleteFalse() {
        val commentsService = CommentsService()
        commentsService.add(Comment(2,"Текст комментария"))
        val result = commentsService.delete(2)
        assertFalse(result)
    }

    @Test
    fun editTrue() {
        val commentsService = CommentsService()
        commentsService.add(Comment(2,"Текст комментария"))
        val edited = Comment(2,"Текст редактированный", id = 1)
        val result = commentsService.edit(edited)
        assertTrue(result)
    }

    @Test
    fun editFalse() {
        val commentsService = CommentsService()
        commentsService.add(Comment(2,"Текст комментария"))
        val edited = Comment(2,"Текст редактированный", id = 2)
        val result = commentsService.edit(edited)
        assertFalse(result)
    }

    @Test
    fun restoreCommentTrue() {
        val commentsService = CommentsService()
        commentsService.add(Comment(2,"Текст комментария"))
        commentsService.delete(1)
        val result = commentsService.restoreComment(1)
        assertTrue(result)
    }

    @Test
    fun restoreCommentFalse() {
        val commentsService = CommentsService()
        commentsService.add(Comment(2,"Текст комментария"))
        commentsService.delete(1)
        val result = commentsService.restoreComment(2)
        assertFalse(result)
    }

    @Test
    fun getComments() {
        val commentsService = CommentsService()
        val original = commentsService.add(Comment(2,"Текст комментария"))
        val expected = commentsService.getComments(2)
        assertEquals(expected[0], original)
    }
}