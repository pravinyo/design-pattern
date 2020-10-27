package creational.abstract_factory.button

/**
 * All products families have the same varieties (MacOS/Windows).
 * This is windows variant of button
 *
 */
class WindowsButton : Button {

    override fun paint() {
        println("Button created for Windows")
    }
}