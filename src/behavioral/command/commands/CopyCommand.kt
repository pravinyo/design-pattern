package behavioral.command.commands

import behavioral.command.editor.Editor

class CopyCommand(private val editor:Editor) : Command(editor) {
    override fun execute(): Boolean {
        editor.apply {
            clipboard = textField.selectedText?:""
        }
        return false
    }
}