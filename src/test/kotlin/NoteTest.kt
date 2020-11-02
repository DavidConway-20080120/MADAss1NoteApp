import NoteTaker.Views.NewNoteView
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNull
import org.junit.Test

class NoteTest{
    @Test
    fun newNormalNote(){
        val testNoteView = NewNoteView()
        val infoIn:Array<String?> = arrayOf("text text","","test Titel")
        testNoteView.create(infoIn)
        assertEquals("test Titel",testNoteView.newNote!!.title)
    }

    @Test
    fun newBadTitelNote(){
        val testNoteView = NewNoteView()
        val infoIn:Array<String?> = arrayOf("text text","","")
        testNoteView.create(infoIn)
        assertNull(testNoteView.newNote)
    }

    @Test
    fun newBadTextNote(){
        val testNoteView = NewNoteView()
        val infoIn:Array<String?> = arrayOf("","","test Titel")
        testNoteView.create(infoIn)
        assertNull(testNoteView.newNote)
    }
}