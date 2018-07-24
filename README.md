TornadoFX Table Data Property Change Issue Demo
===============================================

Defined two types of `User`, show them in `tableview`, and changes the `user.name`:

```
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
```

But I found the changes to `User2` is not reflected in table.

Please run `Hello.kt` file in your IDE, and click the `change` buttons in the window, you will find the second table is not working well.

A question posted on stackoverflow: <https://stackoverflow.com/questions/51491615/change-the-value-of-a-property-of-some-data-but-tableview-doesnt-update>

Resources
---------

- Guide: <https://github.com/edvin/tornadofx-guide/blob/master/part1/11.%20Editing%20Models%20and%20Validation.md>