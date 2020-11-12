package structural.flyweight.forest

import structural.flyweight.trees.Tree
import structural.flyweight.trees.TreeFactory
import java.awt.Color
import java.awt.Graphics
import javax.swing.JFrame

class Forest : JFrame() {
    private val trees = mutableListOf<Tree>()

    fun plantTree(x:Int, y:Int, name:String, color:Color, otherTreeData:String){
        val type = TreeFactory.treeType(name, color, otherTreeData)
        val tree = Tree(x,y,type)
        trees.add(tree)
    }

    override fun paint(g: Graphics) {
        trees.forEach { tree -> tree.draw(g) }
    }
}