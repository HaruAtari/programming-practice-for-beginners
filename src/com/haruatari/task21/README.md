# Visiting a restaurant with friends. Part 2

You and your friends arrived to the restaurant, and now you are exploring the menu. Finally, after a long discussion you
are ready to make an order. Each of you have a list of dishes you are going to order. Now you want to check does your
party have enough money for such order.

You should implement the `int Task.countTotalPrice(Map<Dish, Integer> order)` method which takes
the `Map<Dish, Integer> order` map, calculates total price of your order and returns it. The `order` argument contain a
map whose keys are ordered dishes and values are amount of these dishes in the order. Each dish is represented by an
instance of the `Dish` class which has an `int price` field. You can calculate the price of the dish by multiplying its
price by the amount.