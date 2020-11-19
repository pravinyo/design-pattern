package behavioral.memento.editor

import behavioral.memento.commands.Command
import behavioral.memento.history.History
import behavioral.memento.history.Memento
import behavioral.memento.shapes.CompoundShape
import behavioral.memento.shapes.Shape
import java.io.*
import java.util.*
import javax.swing.JComponent


class Editor : JComponent() {
    private val canvas: Canvas = Canvas(this)
    var shapes: CompoundShape = CompoundShape()
    private val history: History = History()

    fun loadShapes(vararg shapes: Shape) {
        this.shapes.clear()
        this.shapes.add(*shapes)
        canvas.refresh()
    }

    fun execute(c: Command) {
        history.push(c, Memento(this))
        c.execute()
    }

    fun undo() {
        if (history.undo()) canvas.repaint()
    }

    fun redo() {
        if (history.redo()) canvas.repaint()
    }

    fun backup(): String {
        return try {
            val baos = ByteArrayOutputStream()
            val oos = ObjectOutputStream(baos)
            oos.writeObject(shapes)
            oos.close()
            Base64.getEncoder().encodeToString(baos.toByteArray())
        } catch (e: IOException) {
            ""
        }
    }

    fun restore(state: String?) {
        try {
            val data: ByteArray = Base64.getDecoder().decode(state)
            val ois = ObjectInputStream(ByteArrayInputStream(data))
            shapes = ois.readObject() as CompoundShape
            ois.close()
        } catch (e: ClassNotFoundException) {
            print("ClassNotFoundException occurred.")
        } catch (e: IOException) {
            print("IOException occurred.")
        }
    }

}