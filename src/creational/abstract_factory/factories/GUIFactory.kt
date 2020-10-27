package creational.abstract_factory.factories

import creational.abstract_factory.button.Button
import creational.abstract_factory.checkbox.CheckBox

/**
 * Abstract factory knows about all (abstract) product types.
 */
interface GUIFactory {
    fun createButton(): Button
    fun createCheckBox():CheckBox
}