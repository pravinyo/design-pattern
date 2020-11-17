package behavioral.mediator.components

import behavioral.mediator.mediators.Mediator
import java.awt.event.KeyEvent
import javax.swing.JTextArea

class TextBox : JTextArea(), Component {
    private lateinit var mediator: Mediator

    override fun setMediator(mediator: Mediator) {
        this.mediator = mediator
    }

    override fun processComponentKeyEvent(e: KeyEvent) {
        mediator.markNote()
    }

    override fun name(): String {
        return "TextBox"
    }
}