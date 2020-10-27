package creational.abstract_factory.checkbox

/**
 * Mac variant of checkbox
 */
class MacOSCheckBox : CheckBox {
    override fun paint() {
        println("Checkbox created for macOS")
    }
}