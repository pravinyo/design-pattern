package behavioral.memento.commands

interface Command {
    fun name():String
    fun execute()
}