package creational.method_factory.factory

import creational.method_factory.button.Button

/**
 * Base Factory class
 */
abstract class Dialog {

    /**
     * Subclasses will override this method in order to create specific
     * button objects.
     */
    abstract fun createButton():Button

    fun renderWindow(){
        val okButton = createButton()
        okButton.render()
    }

}