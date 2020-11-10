package structural.decorator.dataSources

interface DataSource {
    fun writeData(data:String)
    fun readData():String
}