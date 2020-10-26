package creational.method_factory.factory

import creational.method_factory.button.Button
import creational.method_factory.button.HtmlButton

/**
 * HTML Dialog will produce html button
 */
class HtmlDialog : Dialog(){

    override fun createButton(): Button {
        return HtmlButton()
    }
}