# Creating a Double Linked List. Part 1: Searching

In the next several tasks you will implement your own Double Linked List collection. In this task you should implement
methods for searching in the collection. You have two classes: the `Task` which represents the collection and the `Node`
which represents values. You should implement next methods:

* `Node Task.findByIndex(int index)` which takes the `int index` argument. It should find and return the node with
  that index (the position on the node in the list like an array's index). If the collection contains such index, the
  method should return an appropriate node. Is the index is out of bounds, the method should return `null`.
* `Node Task.findByValue(String value)` which takes the `String value` argument. It should find and return the
  **first** node with specified value. It should return `null` if there are no nodes with such value.