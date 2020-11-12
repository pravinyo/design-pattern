package structural.flyweight.trees

import java.awt.Color

class TreeFactory {
    companion object{
        private val treeType = HashMap<String,TreeType>()

        fun treeType(name:String, color: Color, otherTreeData:String):TreeType {
            var result = treeType[name]

            if (result == null){
                result = TreeType(name,color,otherTreeData)
                treeType[name] = result
            }

            return result
        }
    }
}