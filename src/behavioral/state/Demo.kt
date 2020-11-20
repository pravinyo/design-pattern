package behavioral.state

import behavioral.state.ui.Player
import behavioral.state.ui.UI

object Demo {
    @JvmStatic
    fun main(args: Array<String>) {
        val player = Player()
        val ui = UI(player)
        ui.init()
    }
}