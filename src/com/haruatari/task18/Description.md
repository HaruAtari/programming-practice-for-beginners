# Searching for the most popular posts on the social network. Part 3

Now you noticed that some users creates fake accounts to trick you and have higher chance for winning. You decided to
allow only your followers to participate in the contest. Given that InstaLiter denys unconfirmed users to follow
someone, you don't have to worry about participants' confirmation - it's enough to check that they are your followers.

You should implement the `Task.findWinners()` method which takes the `Post[] posts` arguments with a
list of posts and return the `User[]` list of winners. The list of winners should be sorted by the place: the `0`
element is the first place, the `1` is the second place, and the `2` element is the third place.

Each post has the next fields: `int likesNumber`, `User author`. Each user has the next fields: `int age` and
`boolean isConfirmed`. The `Task` class has the `User[] followers` field which contains a list of your followers.

* Only posts which authors are 18 (`>= 18`) years old can win.
* The user can become a winner only if he/she is your follower (he/she is in the `Task.followers` list).
* A post that fits all requirements and has the maximum number of likes wins and its author is the winner.
* The number of prize places is **3**.

Pay attention:

* The number of posts which fits requirements will always be greater than 3. So don't bother about not full list of
  winners - it will always be full.
* A single user can have only one post. So there will be no situations when the single user are on the several prize
  places. Don't bother about that.
* There will be no posts with the same number of likes, so you always can define the winners.