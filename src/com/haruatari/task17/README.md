# Searching for the most popular posts on the social network. Part 2

When you started looking for a winner of your contest on the InstaLiter social network (see task 16), you noticed that
there are a lot of participants - much more that you expected. After a short thinking you decided to increase the number
of prize places, so more participants can win. You also decided that the number of reposts doesn't matter for you. Now
you should implement a new method which will search the winner.

To do it you should implement the `Task.findWinners()` method which takes the `Post[] posts` arguments with a
list of posts and return the `User[]` list of winners. The list of winners should be sorted by the place: the `0`
element is the first place, the `1` is the second place, and the `2` element is the third place.

Each post has the next fields: `int likesNumber`, `User author`. Each user has the next fields: `int age` and
`boolean isConfirmed`.

* Only posts which authors are 18 (`>= 18`) years old and is confirmed can win.
* A post that fits all requirements and has the maximum number of likes wins and its author is the winner.
* The number of prize places is **3**.

Pay attention:

* The number of posts which fits requirements will always be greater than 3. So don't bother about not full list of
  winners - it will always be full.
* A single user can have only one post. So there will be no situations when the single user are on the several prize
  places. Don't bother about that.
* There will be no posts with the same number of likes, so you always can define the winners.