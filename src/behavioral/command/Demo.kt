package behavioral.command

import behavioral.command.editor.Editor

/**
 * Command is a behavioral design pattern that turns a request into a stand-alone object
 * that contains all information about the request. This transformation lets you parameterize
 * methods with different requests, delay or queue a request’s execution, and support undoable
 * operations.
 *
 * URL: https://refactoring.guru/design-patterns/command
 */
object Demo {
    @JvmStatic
    fun main(args: Array<String>) {
        Editor().init()
    }
}