package creational.method_factory

import creational.method_factory.factory.Dialog
import creational.method_factory.factory.HtmlDialog
import creational.method_factory.factory.WindowsDialog

/**
 *
 * Factory Method is a creational design pattern that provides an interface for creating
 * objects in a superclass, but allows subclasses to alter the type of objects that will be created.
 *
 * URL: https://refactoring.guru/design-patterns/factory-method
 */
object Demo {

    private lateinit var dialog:Dialog

    @JvmStatic
    fun main(args: Array<String>) {
        configure()
        runBusinessLogic()
    }

    /**
     * The concrete factory is usually chosen depending on configuration or
     * environment options.
     */
    private fun configure(){
        dialog = if (System.getProperty("os.name")!="Windows 10"){
            WindowsDialog()
        }else{
            HtmlDialog()
        }
    }

    /**
     * All of the business logic should work with factories and products
     * through abstract interfaces. This way it does not care which factory it
     * works with and what kind of product it returns.
     */
    private fun runBusinessLogic(){
        dialog.renderWindow()
    }
}