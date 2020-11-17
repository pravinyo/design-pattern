package behavioral.mediator.components

import behavioral.mediator.mediators.Mediator
import java.awt.event.ActionEvent

import javax.swing.JButton


class SaveButton : JButton("Save"), Component {
    private lateinit var mediator: Mediator

    override fun setMediator(mediator: Mediator) {
        this.mediator = mediator
    }

    override fun fireActionPerformed(actionEvent: ActionEvent) {
        mediator.saveChanges()
    }

    override fun name(): String {
        return "SaveButton"
    }
}