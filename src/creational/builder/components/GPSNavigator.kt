package creational.builder.components

class GPSNavigator {

    private var route:String

    constructor(){
        this.route = "Sindhi Colony, Chembur, Mumbai"
    }

    constructor(manualRoute:String){
        this.route = manualRoute
    }

    fun route() = route
}