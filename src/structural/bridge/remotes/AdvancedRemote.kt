package structural.bridge.remotes

import structural.bridge.devices.Device

class AdvancedRemote(device: Device) : BasicRemote(device) {

    fun mute(){
        println("Advance: Mute")
        device.setVolume(0)
    }
}