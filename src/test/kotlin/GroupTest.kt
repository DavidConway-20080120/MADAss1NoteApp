import NoteTaker.Data.Group
import NoteTaker.Data.GroupCollection
import NoteTaker.Data.Note
import NoteTaker.Main.main
import NoteTaker.Views.MainView
import NoteTaker.Views.NewGroupView
import NoteTaker.Views.NewNoteView
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNull
import org.junit.Test

class GroupTest{
    @Test
    fun newNormalNote(){
        val testGroupView = NewGroupView()
        val infoIn:Array<String?> = arrayOf("test Titel")
        testGroupView.create(infoIn)
        assertEquals("test Titel",testGroupView.newGroup!!.title)
    }

    @Test
    fun newBadTitelNote(){
        val testGroupView = NewGroupView()
        val infoIn:Array<String?> = arrayOf("")
        testGroupView.create(infoIn)
        assertNull(testGroupView.newGroup)
    }

}