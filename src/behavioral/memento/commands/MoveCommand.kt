package behavioral.memento.commands

import behavioral.memento.editor.Editor

class MoveCommand(private val editor: Editor) : Command {
    private var startX = 0
    private var startY = 0
    private var endX = 0
    private var endY = 0
    val name: String
        get() = "Move by X:" + (endX - startX) + " Y:" + (endY - startY)

    fun start(x: Int, y: Int) {
        startX = x
        startY = y
        println("start => X:$x and y:$y")
    }

    fun move(x: Int, y: Int) {
        println("move child by => X:${x - startX} and y:${y - startY}")
    }

    fun stop(x: Int, y: Int) {
        endX = x
        endY = y
        println("Stop => X:$x and y:$y")
    }

    override fun name(): String {
        return name
    }

    override fun execute() {
        println("move by => X:${endX - startX} and y:${endY - startY}")
    }

}
