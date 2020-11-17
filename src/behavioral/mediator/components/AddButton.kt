package behavioral.mediator.components

import behavioral.mediator.mediators.Mediator
import behavioral.mediator.mediators.Note
import java.awt.event.ActionEvent
import javax.swing.JButton

class AddButton : JButton("Add"), Component {
    private lateinit var mediator: Mediator

    override fun name(): String = "AddButton"

    override fun setMediator(mediator: Mediator) {
        this.mediator = mediator
    }

    override fun fireActionPerformed(event: ActionEvent) {
        mediator.addNewNote(Note())
    }
}