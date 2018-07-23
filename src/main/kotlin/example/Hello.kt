package example

import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleStringProperty
import javafx.collections.FXCollections.observableArrayList
import javafx.scene.control.TableView
import tornadofx.*

data class User(val id: SimpleIntegerProperty, val name: SimpleStringProperty) {
    companion object {
        fun new(id: Int, name: String) = User(id = SimpleIntegerProperty(id), name = SimpleStringProperty(name))
    }
}

private val data = observableArrayList<User>(
        User.new(111, "AAA"),
        User.new(222, "BBB"),
        User.new(333, "CCC"),
        User.new(444, "DDD")
)

class HelloWorld : View() {

    private lateinit var tableView: TableView<User>

    override val root = vbox {
        tableview<User>(data) {
            tableView = this
            column("id", User::id).makeEditable()
            column("name", User::name).makeEditable()
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