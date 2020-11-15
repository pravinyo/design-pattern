package behavioral.command.commands

import behavioral.command.editor.Editor

class PasteCommand(private val editor: Editor) : Command(editor) {
    override fun execute(): Boolean {
        editor.apply {
            if (clipboard.isBlank()) return false
            backup()
            textField.insert(clipboard,textField.caretPosition)
            return true
        }
    }
}