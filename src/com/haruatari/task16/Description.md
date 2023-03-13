# Searching for the most popular post on the social network

You are holding a contest on the popular social network InstaLiter.The contest is over, and now you should find the
winner. To do it you should implement the `Task.findWinner()` method which takes the `Post[] posts` arguments with a
list of posts and return the winner.

Each post has the next fields: `int likesNumber`, `int repostsNumber`, `User author`. Each user has the next fields:
`int age` and `boolean isConfirmed`. Not all users and not all posts can participate in the contest - there are some
requirements for participants:

* The post should have more than 10 (`> 10`) reposts.
* The post's author should reach 18 (`>= 18`) years old and be confirmed.

A post that fits all requirements and has the maximum number of likes wins and its author is the winner. If there are
several posts with the same number of likes, the one with the maximum number of reposts wins.