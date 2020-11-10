package structural.decorator.decorators

import structural.decorator.dataSources.DataSource

open class DataSourceDecorator(private val wrappee:DataSource) : DataSource {

    override fun writeData(data: String) {
        wrappee.writeData(data)
    }

    override fun readData(): String {
        return wrappee.readData()
    }
}