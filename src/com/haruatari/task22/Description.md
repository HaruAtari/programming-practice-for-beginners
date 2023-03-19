# Visiting a restaurant with friends. Part 3

You and your friends are ready to order. Each of you have a list of dishes you are going to order. As your parti is
big you just tell the waiter the name of the dish and names of persons who would like it. But the waiter should remember
the full list of dished ordered by each client.

You should implement the `Map<Dish, List<Friend>> Task.makeOrder(Map<Friend, List<Dish>> friendsOrders)`. It takes the
`Map<Friend, List<Dish>> friendsOrders` map which represents your order when the key is a person and the value is a list
of dishes ordered by that person. The method should rearrange the input information and return in
as the `Map<Dish, List<Friend>>` map where the key is a particular dish adn the value si a list of persons who ordered
that dish.

For example the method takes the next map (in pseudocode):

```
meat: [Fred, Viktor, Marina],
tea: [Bob, Alice, Marina]
```

should return that value:

``` 
Fred: [meat],
Viktor: [meat],
Marina: [meat, tea],
Bob: [tea],
Alice: [tea]
```