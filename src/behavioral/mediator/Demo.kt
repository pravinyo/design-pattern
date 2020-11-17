package behavioral.mediator

import behavioral.mediator.components.*
import behavioral.mediator.components.List
import behavioral.mediator.mediators.Editor
import behavioral.mediator.mediators.Mediator
import javax.swing.DefaultListModel

/**
 * Mediator is a behavioral design pattern that lets you reduce chaotic dependencies
 * between objects. The pattern restricts direct communications between the objects and
 * forces them to collaborate only via a mediator object.
 *
 * URL: https://refactoring.guru/design-patterns/mediator
 */
object Demo {
    @JvmStatic
    fun main(args: Array<String>) {
        val mediator:Mediator = Editor()
        mediator.registerComponent(Title())
        mediator.registerComponent(TextBox())
        mediator.registerComponent(AddButton())
        mediator.registerComponent(DeleteButton())
        mediator.registerComponent(SaveButton())
        mediator.registerComponent(List(DefaultListModel<Any>()))
        mediator.registerComponent(Filter())

        mediator.createGUI()
    }
}