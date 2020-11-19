package behavioral.memento.commands

import behavioral.memento.editor.Editor
import java.awt.Color

class ColorCommand(private val editor: Editor, private val color: Color) : Command {
    val name: String
        get() = "Colorize: $color"

    override fun name(): String {
        return name
    }

    override fun execute() {
        println("color set to  => X:$color")
    }

}