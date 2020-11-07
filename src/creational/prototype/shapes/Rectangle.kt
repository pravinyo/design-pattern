package creational.prototype.shapes

class Rectangle(target:Rectangle?) : Shape(target) {

    var width:Int=0
    var height:Int=0

    constructor() : this(null)

    init {
        target?.let {
            this.height = target.height
            this.width = target.width
        }
    }

    override fun clone(): Shape {
        return Rectangle(this)
    }

    override fun equals(other: Any?): Boolean {
        if (other !is Rectangle || !super.equals(other)) return false
        return other.width == width && other.height == height
    }
}