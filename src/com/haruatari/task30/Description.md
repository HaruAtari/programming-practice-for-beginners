# Factory of objects

You have the `Factory` class which allows to preconfigure and create new instances of the `Node` class. The `Node` class
has the next properties: `int number`, `String name`, `boolean isActive` that are set in the constructor. The `Factory`
class has several methods (`setNumber(int number)`, `setName(String name)` and `setIsActive(boolean isActive)`) that
save configurations and the `build()` method which creates a new instance of the `Node` class, pass preconfigured values
to its constructor and returns created object.

You should implement the next methods:

* `void Factory.setNuber(int number)` which saves the number
* `void Factory.setName(String name)` which saves the name
* `void Factory.setIsActive(boolea isActive)` which saves the isActive values
* `Node Factory.build()` which generates and returns a new `Node` instance

For example, the next code:

``` 
Factory factory = new Factory();
factory.setValue(10);
factory.setName("Test");
factory.setIsActive(false);
Node result = factory.build();
```

should write into the `result` variable the node instance with value `10`, name `Test` and isActive `false`.

* You can (and probably should) create class's properties or extra methods. Do whatever you need to solve the task. But
  **do not** change the existing methods and their signatures. Also, there is no need to change the Node class.
* Each instance of the `Factory` class should store and change its own values and don't share it with other
  instances (do not use static properties).
* All configured values should have the default values. It means that if the appropriate configuration method isn't
  called, the default value should be passed to the Node constructor. The default values:
    * value: 100
    * name: Test
    * isActive: true
* The `Factory` class has to have the default constructor without any arguments which will be used in test.