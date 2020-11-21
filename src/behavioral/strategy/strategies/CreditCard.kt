package behavioral.strategy.strategies

// Dummy credit card class
data class CreditCard(val number:String,
                      val date:String,
                      val CVV:String,
                      var amount:Int = 100_000)