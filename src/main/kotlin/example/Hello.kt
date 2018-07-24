@file:Suppress("MemberVisibilityCanBePrivate")

package example

import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.*

class User(id: Int, name: String) {
    val idProperty = SimpleIntegerProperty(id)
    var id by idProperty

    val nameProperty = SimpleStringProperty(name)
    var name by nameProperty
}

private val data = listOf(User(111, "AAA"), User(222, "BBB"), User(333, "CCC"), User(444, "DDD")).observable()

class HelloWorld : View() {

    override val root = vbox {
        tableview(data) {
            column("id", User::id)
            column("name", User::name)
        }
    }
}

class HelloWorldStyle : Stylesheet() {
    init {
        root {
            prefWidth = 600.px
            prefHeight = 400.px
        }
    }
}

class HelloWorldApp : App(HelloWorld::class, HelloWorldStyle::class)

fun main(args: Array<String>) {
    launch<HelloWorldApp>()
}