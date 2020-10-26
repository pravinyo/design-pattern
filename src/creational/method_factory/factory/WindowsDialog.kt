package creational.method_factory.factory

import creational.method_factory.button.Button
import creational.method_factory.button.WindowsButton

/**
 * Windows dialog will produce windows button
 */
class WindowsDialog : Dialog() {
    override fun createButton(): Button {
        return WindowsButton()
    }
}