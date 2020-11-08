package structural.bridge.devices

class Tv : Device{

    private var on:Boolean = false
    private var volume:Int = 30
    private var channel:Int = 1

    override fun isEnabled(): Boolean {
        return on
    }

    override fun enable() {
        on = true
    }

    override fun disable() {
        on = false
    }

    override fun getVolume(): Int {
        return volume
    }

    override fun setVolume(percent: Int) {
        when {
            volume > 100 -> {
                this.volume = 100
            }
            volume < 0 -> {
                this.volume = 0
            }
            else -> {
                this.volume = percent
            }
        }
    }

    override fun getChannel(): Int {
         return  channel
    }

    override fun setChannel(channel: Int) {
        when {
            channel > 500 -> {
                this.channel = 500
            }
            channel < 0 -> {
                this.channel = 0
            }
            else -> {
                this.channel = channel
            }
        }
    }

    override fun printStatus() {
        println("------------------------------------")
        println("| I'm TV set.")
        println("| I'm " + if (on) "enabled" else "disabled")
        println("| Current volume is $volume%")
        println("| Current channel is $channel")
        println("------------------------------------\n")
    }
}