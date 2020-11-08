package structural.bridge

import structural.bridge.devices.Device
import structural.bridge.devices.Radio
import structural.bridge.devices.Tv
import structural.bridge.remotes.AdvancedRemote
import structural.bridge.remotes.BasicRemote

/**
 * Bridge is a structural design pattern that lets you split a large class or a set of closely
 * related classes into two separate hierarchies—abstraction and implementation—which can be
 * developed independently of each other.
 *
 * URL: https://refactoring.guru/design-patterns/bridge
 */
object Demo {

    @JvmStatic
    fun main(args: Array<String>) {
        testDevice(Tv())
        testDevice(Radio())
    }

    private fun testDevice(device: Device) {
        println("Tests with basic remote.")
        val basicRemote = BasicRemote(device)
        basicRemote.power()
        device.printStatus()

        println("Tests with advanced remote.")
        val advancedRemote = AdvancedRemote(device)
        advancedRemote.power()
        advancedRemote.mute()
        device.printStatus()
    }
}