package behavioral.mediator.components

import behavioral.mediator.mediators.Mediator
import behavioral.mediator.mediators.Note
import javax.swing.DefaultListModel
import javax.swing.JList


class List(private val LIST_MODEL: DefaultListModel<Any>) : JList<Any>(LIST_MODEL), Component {
    private lateinit var mediator: Mediator

    init {
        model = LIST_MODEL
        layoutOrientation = VERTICAL
        val thread = Thread(Hide(this))
        thread.start()
    }

    override fun setMediator(mediator: Mediator) {
        this.mediator = mediator
    }

    fun addElement(note: Note) {
        LIST_MODEL.addElement(note)
        val index = LIST_MODEL.size() - 1
        selectedIndex = index
        ensureIndexIsVisible(index)
        mediator.sendToFilter(LIST_MODEL)
    }

    fun deleteElement() {
        val index = this.selectedIndex
        try {
            LIST_MODEL.remove(index)
            mediator.sendToFilter(LIST_MODEL)
        } catch (ignored: ArrayIndexOutOfBoundsException) {
        }
    }

    val currentElement: Note
        get() = selectedValue as Note

    override fun name(): String {
        return "List"
    }

    private inner class Hide(private val list: List) : Runnable {
        override fun run() {
            while (true) {
                try {
                    Thread.sleep(300)
                } catch (ex: InterruptedException) {
                    ex.printStackTrace()
                }
                if (list.isSelectionEmpty) {
                    mediator.hideElements(true)
                } else {
                    mediator.hideElements(false)
                }
            }
        }
    }
}