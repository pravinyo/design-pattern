package behavioral.memento.editor

import behavioral.memento.commands.ColorCommand
import behavioral.memento.commands.MoveCommand
import behavioral.memento.shapes.Shape
import java.awt.BorderLayout
import java.awt.Canvas
import java.awt.Color
import java.awt.Graphics
import java.awt.event.*
import java.awt.image.BufferedImage
import javax.swing.*
import javax.swing.border.Border


internal class Canvas(private val editor: Editor) : Canvas() {
    private var frame: JFrame? = null
    private fun createFrame() {
        frame = JFrame()
        frame!!.defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        frame!!.setLocationRelativeTo(null)
        val contentPanel = JPanel()
        val padding: Border = BorderFactory.createEmptyBorder(PADDING, PADDING, PADDING, PADDING)
        contentPanel.border = padding
        contentPanel.layout = BoxLayout(contentPanel, BoxLayout.Y_AXIS)
        frame!!.contentPane = contentPanel
        contentPanel.add(JLabel("Select and drag to move."), BorderLayout.PAGE_END)
        contentPanel.add(JLabel("Right click to change color."), BorderLayout.PAGE_END)
        contentPanel.add(JLabel("Undo: Ctrl+Z, Redo: Ctrl+R"), BorderLayout.PAGE_END)
        contentPanel.add(this)
        frame!!.isVisible = true
        contentPanel.background = Color.LIGHT_GRAY
    }

    private fun attachKeyboardListeners() {
        addKeyListener(object : KeyAdapter() {
            override fun keyPressed(e: KeyEvent) {
                if (e.getModifiers() and KeyEvent.CTRL_MASK !== 0) {
                    when (e.getKeyCode()) {
                        KeyEvent.VK_Z -> editor.undo()
                        KeyEvent.VK_R -> editor.redo()
                    }
                }
            }
        })
    }

    private fun attachMouseListeners() {
        val colorizer: MouseAdapter = object : MouseAdapter() {
            override fun mousePressed(e: MouseEvent) {
                if (e.button !== MouseEvent.BUTTON3) {
                    return
                }
                val target: Shape? = editor.shapes.childAt(e.x, e.y)
                if (target != null) {
                    editor.execute(ColorCommand(editor, Color((Math.random() * 0x1000000).toInt())))
                    repaint()
                }
            }
        }
        addMouseListener(colorizer)
        val selector: MouseAdapter = object : MouseAdapter() {
            override fun mousePressed(e: MouseEvent) {
                if (e.getButton() !== MouseEvent.BUTTON1) {
                    return
                }
                val target: Shape? = editor.shapes.childAt(e.x, e.y)
                val ctrl = e.getModifiers() and ActionEvent.CTRL_MASK === ActionEvent.CTRL_MASK
                if (target == null) {
                    if (!ctrl) {
                        editor.shapes.unSelect()
                    }
                } else {
                    if (ctrl) {
                        if (target.isSelected()) {
                            target.unSelect()
                        } else {
                            target.select()
                        }
                    } else {
                        if (!target.isSelected()) {
                            editor.shapes.unSelect()
                        }
                        target.select()
                    }
                }
                repaint()
            }
        }
        addMouseListener(selector)
        val dragger: MouseAdapter = object : MouseAdapter() {
            var moveCommand: MoveCommand? = null
            override fun mouseDragged(e: MouseEvent) {
                if (e.getModifiersEx() and MouseEvent.BUTTON1_DOWN_MASK !== MouseEvent.BUTTON1_DOWN_MASK) {
                    return
                }
                if (moveCommand == null) {
                    moveCommand = MoveCommand(editor)
                    moveCommand!!.start(e.getX(), e.getY())
                }
                moveCommand!!.move(e.getX(), e.getY())
                repaint()
            }

            override fun mouseReleased(e: MouseEvent) {
                if (e.getButton() !== MouseEvent.BUTTON1 || moveCommand == null) {
                    return
                }
                moveCommand!!.stop(e.x, e.y)
                editor.execute(moveCommand!!)
                moveCommand = null
                repaint()
            }
        }
        addMouseListener(dragger)
        addMouseMotionListener(dragger)
    }

    override fun getWidth(): Int {
        return editor.shapes.x + editor.shapes.width() + PADDING
    }

    override fun getHeight(): Int {
        return editor.shapes.y+ editor.shapes.height() + PADDING
    }

    fun refresh() {
        this.setSize(width, height)
        frame!!.pack()
    }

    override fun update(g: Graphics) {
        paint(g)
    }

    override fun paint(graphics: Graphics) {
        val buffer = BufferedImage(width, height, BufferedImage.TYPE_INT_RGB)
        val ig2 = buffer.createGraphics()
        ig2.background = Color.WHITE
        ig2.clearRect(0, 0, width, height)
        editor.shapes.paint(buffer.graphics)
        graphics.drawImage(buffer, 0, 0, null)
    }

    companion object {
        private const val PADDING = 10
    }

    init {
        createFrame()
        attachKeyboardListeners()
        attachMouseListeners()
        refresh()
    }
}