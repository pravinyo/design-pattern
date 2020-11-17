package behavioral.mediator.mediators

class Note {
    private var name: String = "New note"
    private var text: String = ""

    fun setName(name: String) {
        this.name = name
    }

    fun setText(text: String) {
        this.text = text
    }

    fun getName(): String {
        return name
    }

    fun getText(): String {
        return text
    }

    override fun toString(): String {
        return name
    }
}