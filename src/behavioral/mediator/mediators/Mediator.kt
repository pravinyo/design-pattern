package behavioral.mediator.mediators

import behavioral.mediator.components.Component
import javax.swing.ListModel

interface Mediator {
    fun addNewNote(note: Note)
    fun deleteNote()
    fun getInfoFromList(note: Note)
    fun saveChanges()
    fun markNote()
    fun clear()
    fun sendToFilter(listModel: ListModel<Any>)
    fun setElementsList(list: ListModel<Any>)
    fun registerComponent(component: Component)
    fun hideElements(flag: Boolean)
    fun createGUI()
}