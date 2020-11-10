package structural.decorator

import structural.decorator.dataSources.DataSource
import structural.decorator.dataSources.FileDataSource
import structural.decorator.decorators.CompressionDecorator
import structural.decorator.decorators.DataSourceDecorator
import structural.decorator.decorators.EncryptionDecorator


object Demo {
    @JvmStatic
    fun main(args: Array<String>) {
        val salaryRecords = "Name,Salary\nJohn Smith,100000\nSteven Jobs,912000"
        val encoded: DataSourceDecorator =
                CompressionDecorator(EncryptionDecorator(FileDataSource("out/OutputDemo.txt")))

        encoded.writeData(salaryRecords)
        val plain: DataSource = FileDataSource("out/OutputDemo.txt")

        println("- Input ----------------")
        println(salaryRecords)
        println("- Encoded --------------")
        println(plain.readData())
        println("- Decoded --------------")
        println(encoded.readData())
    }
}