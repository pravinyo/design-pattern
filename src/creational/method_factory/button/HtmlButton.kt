package creational.method_factory.button

/**
 * HTML Button implementation
 */
class HtmlButton : Button {

    override fun render() {
        println("<button> HTML button </html>")
        onClick()
    }

    override fun onClick() {
        println("Hello from HTML Button!")
    }
}