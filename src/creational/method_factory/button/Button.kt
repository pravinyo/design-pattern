package creational.method_factory.button

/**
 * Common Interface for all button
 */
interface Button {
    /**
     * Handle rendering of the button
     */
    fun render()

    /**
     * Handle click action
     */
    fun onClick()
}