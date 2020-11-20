package behavioral.state.ui

import java.awt.FlowLayout
import java.awt.event.ActionEvent
import javax.swing.*


class UI(private val player: Player) {
    private val textField = JTextField()

    fun init() {
        val frame = JFrame("Test player")
        frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        val context = JPanel()
        context.layout = BoxLayout(context, BoxLayout.Y_AXIS)
        frame.contentPane.add(context)
        val buttons = JPanel(FlowLayout(FlowLayout.CENTER))
        context.add(textField)
        context.add(buttons)

        // Context delegates handling user's input to a state object.
        // Naturally, the outcome will depend on what state is currently active,
        // since all states can handle the input differently.

        val play = JButton("Play")
        play.addActionListener { textField.text = player.getState().onPlay() }
        val stop = JButton("Stop")
        stop.addActionListener { textField.text = player.getState().onLock() }
        val next = JButton("Next")
        next.addActionListener { textField.text = player.getState().onNext() }
        val prev = JButton("Prev")
        prev.addActionListener { textField.text = player.getState().onPrevious() }
        frame.isVisible = true
        frame.setSize(300, 100)
        buttons.add(play)
        buttons.add(stop)
        buttons.add(next)
        buttons.add(prev)
    }
}