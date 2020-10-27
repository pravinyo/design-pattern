package creational.abstract_factory.button

/**
 * All products families have the same varieties (MacOS/Windows).
 * This is a MacOS variant of a button.
 */
class MacButton : Button {
    override fun paint() {
        println("Button created for MacOs")
    }
}