package creational.abstract_factory.factories

import creational.abstract_factory.button.Button
import creational.abstract_factory.button.WindowsButton
import creational.abstract_factory.checkbox.CheckBox
import creational.abstract_factory.checkbox.WindowsCheckBox

/**
 * Each concrete factory extends basic factory and responsible for creating
 * products of a single variety.
 *
 */
class WindowsFactory : GUIFactory {

    override fun createButton(): Button {
        return WindowsButton()
    }

    override fun createCheckBox(): CheckBox {
        return WindowsCheckBox()
    }
}