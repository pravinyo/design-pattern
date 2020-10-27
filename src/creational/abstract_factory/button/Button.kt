package creational.abstract_factory.button;

/**
 * Abstract Factory assumes that you have several families of products,
 * structured into separate class hierarchies (Button/Checkbox). All products of
 * the same family have the common interface.
 */
interface Button {
    fun paint()
}
