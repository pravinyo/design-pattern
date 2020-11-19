package behavioral.memento.history

import behavioral.memento.commands.Command


class History {
    private var history: MutableList<HistoryPair> = ArrayList()
    private var virtualSize = 0

    fun push(c: Command, m: Memento) {
        if (virtualSize != history.size && virtualSize > 0) {
            history = history.subList(0, virtualSize - 1)
        }
        history.add(HistoryPair(c, m))
        virtualSize = history.size
    }

    fun undo(): Boolean {
        val pair:HistoryPair = undo ?: return false
        println("Undoing: " + pair.command.name())
        pair.memento.restore()
        return true
    }

    fun redo(): Boolean {
        val pair:HistoryPair = redo ?: return false
        println("Redoing: " + pair.command.name())
        pair.memento.restore()
        pair.command.execute()
        return true
    }

    private val undo: HistoryPair?
        get() {
            if (virtualSize == 0) {
                return null
            }
            virtualSize = Math.max(0, virtualSize - 1)
            return history[virtualSize]
        }
    private val redo: HistoryPair?
        get() {
            if (virtualSize == history.size) {
                return null
            }
            virtualSize = Math.min(history.size, virtualSize + 1)
            return history[virtualSize - 1]
        }
}