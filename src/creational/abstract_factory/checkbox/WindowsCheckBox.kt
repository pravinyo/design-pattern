package creational.abstract_factory.checkbox

/**
 * Windows variant for checkbox
 */
class WindowsCheckBox : CheckBox {
    override fun paint() {
        println("Checkbox created for windows")
    }
}