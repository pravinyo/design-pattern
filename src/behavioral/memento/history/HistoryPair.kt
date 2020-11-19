package behavioral.memento.history

import behavioral.memento.commands.Command

data class HistoryPair (
        val command: Command,
        val memento: Memento
)