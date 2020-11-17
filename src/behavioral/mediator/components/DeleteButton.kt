package behavioral.mediator.components

import behavioral.mediator.mediators.Mediator
import java.awt.event.ActionEvent
import javax.swing.JButton

/**
 * Concrete components don't talk with each other. They have only one
 * communication channel–sending requests to the mediator.
 */
class DeleteButton : JButton("Delete"), Component {
    private lateinit var mediator: Mediator

    override fun name(): String = "DeleteButton"

    override fun setMediator(mediator: Mediator) {
        this.mediator = mediator
    }

    override fun fireActionPerformed(event: ActionEvent) {
        mediator.deleteNote()
    }
}