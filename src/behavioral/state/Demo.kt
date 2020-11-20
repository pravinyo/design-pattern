package behavioral.state

import behavioral.state.ui.Player
import behavioral.state.ui.UI

/**
 * State is a behavioral design pattern that lets an object alter its behavior
 * when its internal state changes. It appears as if the object changed its class.
 *
 * URL: https://refactoring.guru/design-patterns/state
 */
object Demo {
    @JvmStatic
    fun main(args: Array<String>) {
        val player = Player()
        val ui = UI(player)
        ui.init()
    }
}