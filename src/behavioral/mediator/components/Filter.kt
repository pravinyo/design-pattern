package behavioral.mediator.components

import behavioral.mediator.mediators.Mediator
import behavioral.mediator.mediators.Note
import java.awt.event.KeyEvent
import java.util.*
import javax.swing.DefaultListModel
import javax.swing.JTextField
import javax.swing.ListModel


class Filter : JTextField(), Component {
    private lateinit var mediator: Mediator
    private var listModel:ListModel<Any>? = null

    override fun name(): String = "Filter"

    override fun setMediator(mediator: Mediator) {
        this.mediator = mediator
    }

    override fun processComponentKeyEvent(e: KeyEvent) {
        val start = text
        searchElements(start)
    }

    fun setList(listModel: ListModel<Any>) {
        this.listModel = listModel
    }

    private fun searchElements(s: String) {

        listModel?.let {
            if (s == "") {
                mediator.setElementsList(it)
                return
            }

            val notes: ArrayList<Note> = ArrayList<Note>()
            for (i in 0 until it.size) {
                notes.add(it.getElementAt(i) as Note)
            }
            val listModel: DefaultListModel<Note> = DefaultListModel<Note>()
            for (note in notes) {
                if (note.getName().contains(s)) {
                    listModel.addElement(note)
                }
            }
            mediator.setElementsList(it)
        }
    }
}