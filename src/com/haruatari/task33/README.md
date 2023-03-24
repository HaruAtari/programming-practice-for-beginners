# Simple messenger. Part 1

You are going to write the simple messenger. Nothing serious just for you and your friends.

Every messenger's user is represented with the `User` class. It has the `receiveMessage(String message)` method.
When the user receives a message the messenger should just call that method and pass the message to it.

You should implement the `Messager` class which has all methods required for messaging:

* `void Messenger.addUser(User user)` adds a new user into your messenger. Now he/she will be able to receive messages.
  If the user is already in the messenger, he/she **should not** be added one more time. In this case nothing should
  happen. The user should become online immediately after adding.
* `void Messenger.removeUser(User user)` removes the specified user from your messenger. Now he/she will not be able to
  receive messages. If the user is not in the messenger, he/she **should not** be removed one more time. In this case
  nothing should happen.
* `void Messenger.setUserOnline(User user)` marks the specified user as online. If the user is in your messenger or
  he/she is already online, nothing should happen.
* `void Messenger.setUserOffline(User user)` marks the specified user as offline. If the user is not in your messenger
  or
  he/she is already offline, nothing should happen.
* `List<User> Messenger.getOnlineUsers()` returns a list of all online users in your messenger. The order doesn't
  matter.
* `List<User> Messenger.getOfflineUsers()` returns a list of all offline users in your messenger. The order doesn't
  matter.
* `int Messenger.countAllUsers()` returns a number of all users in the messenger.
* `int Messenger.countOnlineUsers()` returns a number of online users in the messenger.
* `void Messenger.sendMessageToAllUsers(String message)` sends the specified message to all users.
* `void Messenger.sendMessageToOnlineUsers(String message)` sends the specified message only to online users.
* `void Messenger.sendMessageToUser(String message, User user)` sends the message only to specified user. It doesn't
* matter is he/she online or offline. Pay attention: the method  **should not** send the message to the user if he/she
  is not in the messenger.