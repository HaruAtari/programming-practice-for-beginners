# Visiting a restaurant with friends. Part 1

Yes are going to visit restaurant with your friends, and now you are assembling the party. You have to decide which of
your friends will be invited. Each of your friends is represented as an instance of the `Friend` class which have the
`boolean isBusy` and `String name` fields. If `isBusy` is `true` it means that your friend is busy and can't go with
you. Also, you can't invite as many friends as you want because you were able to book the limited amount of seats.

Thus, you should implement the `List<Friend> Task.assembleTheParty(List<Friend> friends, int bookedSeatsNumber)` method
which takes a list of all your friends and a number of the booked seats. It should return a list of friends which should
be invited. You should not invite those friends who are busy. Also, the total size of the party should not be bigger
than the number of booked seats. You don't have any favorites among your friends, so just invite friends in the order
of the input list - from the beginning and so on until you have free seats.

Pay attention: You are going to visit restaurant too, aren't you? So the number of invited friends should be 1 less than
the number of booked seats.