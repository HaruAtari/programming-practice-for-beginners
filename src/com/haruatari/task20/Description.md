# Creating a linked list. Part 2: Inserting

In this task you should implement methods for inserting new elements at the Linked List collection. You have two 
classes: the `Task` which represents the collection and the `Node` which represents values. You should implement next 
methods:

* `void Task.insertFirst(String value)` which takes the `String value` argument. It should create a new Node with the
given value and insert it at the **beginning** of the list.
* `void Task.insertLast(String value)` which takes the `String value` argument. It should create a new Node with the
given value and insert it at the **end** of the list.
* `void Task.insertAfter(String value, Node previousNode)` which takes the `String value` and the `Node previousNode` 
argument. It should create a new Node with the given value and insert it **next to** the `previousNode` node. **Pay 
attention:** the `previousNode` contains exactly the node after which the new node should be inserted. You don't need 
to search for any nodes in that method - use the given previousNode.
* `void Task.insertBefore(String value, Node nextNode)` which takes the `String value` and the `Node nextNode` argument. 
It should create a new Node with the given value and insert it **before** the `nextNode` node. **Pay attention:** the 
`nextNode` contains exactly the node before which the new node should be inserted. You don't need to search for any 
nodes in that method - use the given nextNode.