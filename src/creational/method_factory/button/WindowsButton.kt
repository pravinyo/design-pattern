package creational.method_factory.button

import java.awt.Color
import java.awt.FlowLayout
import java.awt.Font
import javax.swing.*
import kotlin.system.exitProcess

/**
 * Button Implementation for windows platform
 */
class WindowsButton : Button {
    private val panel = JPanel()
    private val frame = JFrame()
    private lateinit var button:JButton


    override fun render() {
        frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        val label = JLabel("Hello From Windows Button!")
        label.isOpaque = true
        label.background = Color(235, 233, 126)
        label.font = Font("Dialog", Font.BOLD, 14)
        label.horizontalAlignment = SwingConstants.CENTER
        panel.layout = FlowLayout(FlowLayout.CENTER)
        frame.contentPane.add(panel)
        panel.add(label)
        onClick()
        panel.add(button)

        frame.setSize(320, 200)
        frame.isVisible = true
        onClick()
    }

    override fun onClick() {
        button = JButton("Close")
        button.addActionListener {
            frame.isVisible = false
            exitProcess(0)
        }
    }
}