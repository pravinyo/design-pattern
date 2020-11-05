package creational.prototype.shapes

class Circle (target:Circle?) : Shape(target){

    var radius:Int = 0

    init {
        target?.let {
            this.radius = target.radius
        }
    }

    override fun clone(): Shape {
        return Circle(this)
    }

    override fun equals(other: Any?): Boolean {
        if (other !is Circle || !super.equals(other)) return false

        return other.radius == radius
    }
}