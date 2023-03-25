# Changing object's behaviour by fixing its abstract parent

There is an abstract class `Device` which is an abstract parent for all gadgets. It has two abstract method that should
be implemented in descendants:

* `int getBatteryPercentage()` which returns amount of remaining charge.
* 'String getName()' which returns a name of the device.

It also implements two methods by itself:

* `String getFullInfo()` which returns full information about the device.
* `boolean needCharging()` which returns `true` when the device has low level of charge.

Methods `getFullInfo()` and `needCharging()` work incorrect now - they do nothing. You should fix them so any device
works properly.

* The `String getFullInfo()` method should return the string `Device {name} has {batteryPercentage}% battery`,
  where `{name}` should be replaced with the name of the device, and `{batteryPercentage}` should be replaced with the
  charge percentage.
* The `boolean needCharging()` method should return `true` if the battery percentage lower than 20%.

Pay attention: You should not create any new classes. You should just change the `Device` class. All specific devices
will be created and inherited by the tests.