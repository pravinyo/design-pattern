package behavioral.command.commands

import java.util.Stack

class CommandHistory {
    private val history = Stack<Command>()

    fun push(command: Command){
        history.push(command)
    }

    fun pop():Command = history.pop()

    fun isEmpty():Boolean = history.isEmpty()
}