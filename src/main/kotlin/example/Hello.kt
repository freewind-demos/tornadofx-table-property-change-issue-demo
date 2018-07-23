package example

import tornadofx.*

data class User(val id: Int, val name: String)

private val data = listOf(User(111, "AAA"), User(222, "BBB"), User(333, "CCC"), User(444, "DDD")).observable()

class HelloWorld : View() {

    override val root = vbox {
        tableview(data) {
            column("id", User::id.getter)
            column("name", User::name.getter)
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