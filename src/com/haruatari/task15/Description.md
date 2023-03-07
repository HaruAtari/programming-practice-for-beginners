# Calculate a total price for the shop cart taking into account the discounts

You were shopping, and now you have some products in your cart. You need to know whether you have enough money for the
purchase. So you need to calculate a total size of the upcoming payment. By the way, today is the discount on several
products, so you can same some money!

Each product is represented as an instance of the `Product` class which has three fields: `string name`,
`int amount` and `int price`. Each discount is represented as an instance of the `Discount` class which has two fields:
`string productName` and `int discount`.

You should implement the `Task.calculatePayment()` method which takes the next arguments `Product[] products` and
`Disount[] discounts`. It should calculate a total price of all your products taking into account the discounts and
return it.

To calculate a price of the products you should:

* Check if there is a discount for that product. You should search for the discount in the `discounts` array which
  `productName` is equals to the product's name. If the discount is found, you should subtract it from the product's
  price.
* Multiply the final product's price by its amount.

Pay attention:

* The discount is **not** the percentage. It's an absolute amount of money which should be subtracted from the product's
  price: `totalProductPrice = product.price - discount.discount`.
* The product **can't** have several discounts. It can be only one discount for the products (or no discount at all). So
  you
  can don't bother about searching for the biggest discount.
* The discount can't be more then product's price. So don't bother about this too.