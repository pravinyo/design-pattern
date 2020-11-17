package behavioral.mediator.components

import behavioral.mediator.mediators.Mediator

interface Component {
    fun name():String
    fun setMediator(mediator:Mediator)
}