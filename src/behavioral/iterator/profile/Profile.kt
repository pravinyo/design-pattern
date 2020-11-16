package behavioral.iterator.profile

class Profile(private val email:String, private val name:String,vararg contacts:String) {

    private val contacts = HashMap<String,MutableList<String>>()

    init {
        contacts.forEach {contact ->
            val parts = contact.split(":")
            val email:String
            var type = "friend"

            if (parts.size == 1){
                email = parts.first()
            }else{
                type = parts.first()
                email = parts.last()
            }

            this.contacts.apply {
                if (!containsKey(type)){
                    put(type,ArrayList())
                }

                get(type)?.add(email)
            }
        }
    }

    fun name():String = name

    fun email():String = email

    fun contacts(type:String):List<String>{
        return contacts[type] ?: emptyList()
    }
}