# Summarizing of all integers inputted to the object  

You have the `Counter` class which has four methods: `void add(int x)`, `void subtract(int x)`,`int getValue()`
and `void reset()`. An instance of this class would store the value (init value is `0`). This value can be increased by
calling the `add()` method and decreased by calling the `subtract()` method. The `getValue()` method returns the current
stored value and the `reset()` method resets the value to `0`.

You should implement the next methods:

* `void add(int x)` which increases the current value by `x`
* `void subtract(int x)` which decreases the current value by `x`
* `void reset(int x)` which set the current value to `0`
* `int getValue()` which returns the current value

* You can (and probably should) create class's properties or extra methods. Do whatever you need to solve the task. But
  **do not** change the existing methods and their signatures.
* Each instance of the `Counter` class should store and change its own value and don't share it with other
  instances (do not use static properties).
* The `Counter` class has to have the default constructor without any arguments which will be used in test.