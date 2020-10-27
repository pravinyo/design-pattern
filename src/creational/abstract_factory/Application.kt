package creational.abstract_factory

import creational.abstract_factory.button.Button
import creational.abstract_factory.checkbox.CheckBox
import creational.abstract_factory.factories.GUIFactory

class Application(factory:GUIFactory) {
    private val button:Button = factory.createButton()
    private val checkBox:CheckBox = factory.createCheckBox()

    fun paint(){
        button.paint()
        checkBox.paint()
    }
}