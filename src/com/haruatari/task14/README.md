# Calculate a total price for the shop cart

You were shopping, and now you have some products in your cart. You need to know whether you have enough money for the
purchase. So you need to calculate a total size of the upcoming payment.

Each product is represented as an instance of the `Product` class. Each product has two fields: `int amount`
and `int price`. You should implement the `Task.calculatePayment()` method which takes the `Cart cart` argument.
The cart has the `Product[] products` field with an array of your products. The method should calculate a total price of
all your products and return it. The price of each product is its amount multiplied by its price.