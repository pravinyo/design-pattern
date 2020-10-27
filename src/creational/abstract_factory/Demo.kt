package creational.abstract_factory

import creational.abstract_factory.factories.GUIFactory
import creational.abstract_factory.factories.MacOSFactory
import creational.abstract_factory.factories.WindowsFactory

object Demo {
    fun configureApplication():Application{

        val factory: GUIFactory = when(System.getProperty("os.name").toLowerCase()){
            "mac" -> {
                MacOSFactory()
            }

            else -> {
                WindowsFactory()
            }
        }

        return Application(factory)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val app = configureApplication()
        app.paint()
    }
}