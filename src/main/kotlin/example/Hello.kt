@file:Suppress("MemberVisibilityCanBePrivate")

package example

import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.*

class User1(id: Int, name: String) {
    val id = SimpleIntegerProperty(id)
    val name = SimpleStringProperty(name)
}

class User2(id: Int, name: String) {
    val idProperty = SimpleIntegerProperty(id)
    var id by idProperty

    val nameProperty = SimpleStringProperty(name)
    var name by nameProperty
}

private val data1 = listOf(User1(111, "AAA"), User1(222, "BBB"), User1(333, "CCC"), User1(444, "DDD")).observable()
private val data2 = listOf(User2(111, "AAA"), User2(222, "BBB"), User2(333, "CCC"), User2(444, "DDD")).observable()

class HelloWorld : View() {

    override val root = hbox {
        vbox {
            tableview(data1) {
                column("id", User1::id)
                column("name", User1::name).minWidth(200)
            }
            button("Modify data with type of User1").setOnAction {
                data1.forEach { it.name += " changed!" }
            }
        }

        vbox {
            tableview(data2) {
                column("id", User2::id)
                column("name", User2::name).minWidth(200)
            }
            button("Modify data with type of User2").setOnAction {
                data2.forEach { it.name += " changed!" }
            }
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