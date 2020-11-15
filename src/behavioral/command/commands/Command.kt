package behavioral.command.commands

import behavioral.command.editor.Editor

abstract class Command(private val editor:Editor) {
    private var backup:String=""

    fun backup(){
        backup = editor.textField.text
    }

    fun undo(){
        editor.textField.text = backup
    }

    abstract fun execute():Boolean
}