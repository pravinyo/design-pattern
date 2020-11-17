package behavioral.mediator.mediators

import behavioral.mediator.components.*
import behavioral.mediator.components.List
import java.awt.Color
import java.awt.Dimension
import java.awt.FlowLayout
import java.awt.Font
import javax.swing.*
import javax.swing.border.LineBorder


class Editor : Mediator {
    private lateinit var title: Title
    private lateinit var textBox: TextBox
    private lateinit var add: AddButton
    private lateinit var del: DeleteButton
    private lateinit var save: SaveButton
    private lateinit var list: List
    private lateinit var filter: Filter
    private  val titleLabel = JLabel("Title:")
    private  val textLabel = JLabel("Text:")
    private  val label = JLabel("Add or select existing note to proceed...")

    /**
     * Here the registration of components by the mediator.
     */
    override fun registerComponent(component: Component) {
        component.setMediator(this)
        when (component.name()) {
            "AddButton" -> add = component as AddButton
            "DeleteButton" -> del = component as DeleteButton
            "Filter" -> filter = component as Filter
            "SaveButton" -> save = component as SaveButton
            "TextBox" -> textBox = component as TextBox
            "Title" -> title = component as Title
            "List" -> list = component as List
            else -> println("Ignored : ${component.name()}")
        }
    }

    /**
     * Various methods to handle requests from particular components.
     */
    override fun addNewNote(note: Note) {
        title.text = ""
        textBox.text = ""
        list.addElement(note)
    }

    override fun deleteNote() {
        list.deleteElement()
    }

    override fun getInfoFromList(note: Note) {
        title.text = note.getName().replace('*', ' ')
        textBox.text = note.getText()
    }

    override fun saveChanges() {
        try {
            val note = list.selectedValue as Note
            note.setName(title.text)
            note.setText(textBox.text)
            list.repaint()
        } catch (ignored: NullPointerException) {
        }
    }

    override fun markNote() {
        try {
            val note: Note = list.currentElement
            val name = note.getName()
            if (!name.endsWith("*")) {
                note.setName(note.getName() + "*")
            }
            list.repaint()
        } catch (ignored: NullPointerException) {
        }
    }

    override fun clear() {
        title.text = ""
        textBox.text = ""
    }

    override fun sendToFilter(listModel: ListModel<Any>) {
        filter.setList(listModel)
    }

    override fun setElementsList(list: ListModel<Any>) {
        this.list.model = list
        this.list.repaint()
    }

    override fun hideElements(flag: Boolean) {
        titleLabel.isVisible = !flag
        textLabel.isVisible = !flag
        title.isVisible = !flag
        textBox.isVisible = !flag
        save.isVisible = !flag
        label.isVisible = flag
    }

    override fun createGUI() {
        val notes = JFrame("Notes")
        notes.setSize(960, 600)
        notes.defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        val left = JPanel()
        left.border = LineBorder(Color.BLACK)
        left.setSize(320, 600)
        left.layout = BoxLayout(left, BoxLayout.Y_AXIS)
        val filterPanel = JPanel()
        filterPanel.add(JLabel("Filter:"))
        filter.columns = 20
        filterPanel.add(filter)
        filterPanel.preferredSize = Dimension(280, 40)
        val listPanel = JPanel()
        list.fixedCellWidth = 260
        listPanel.setSize(320, 470)
        val scrollPane = JScrollPane(list)
        scrollPane.preferredSize = Dimension(275, 410)
        listPanel.add(scrollPane)
        val buttonPanel = JPanel()
        add.preferredSize = Dimension(85, 25)
        buttonPanel.add(add)
        del.preferredSize = Dimension(85, 25)
        buttonPanel.add(del)
        buttonPanel.layout = FlowLayout()
        left.add(filterPanel)
        left.add(listPanel)
        left.add(buttonPanel)
        val right = JPanel()
        right.layout = null
        right.setSize(640, 600)
        right.setLocation(320, 0)
        right.border = LineBorder(Color.BLACK)
        titleLabel.setBounds(20, 4, 50, 20)
        title.setBounds(60, 5, 555, 20)
        textLabel.setBounds(20, 4, 50, 130)
        textBox.border = LineBorder(Color.DARK_GRAY)
        textBox.setBounds(20, 80, 595, 410)
        save.setBounds(270, 535, 80, 25)
        label.font = Font("Verdana", Font.PLAIN, 22)
        label.setBounds(100, 240, 500, 100)
        right.add(label)
        right.add(titleLabel)
        right.add(title)
        right.add(textLabel)
        right.add(textBox)
        right.add(save)
        notes.layout = null
        notes.contentPane.add(left)
        notes.contentPane.add(right)
        notes.isResizable = false
        notes.setLocationRelativeTo(null)
        notes.isVisible = true
    }
}