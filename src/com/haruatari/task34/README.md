# Changing object's behaviour by inheritance

There is the `Product` class which represents a product in the shop. It has several properties and methods (you can
research them in the code). This class has several errors in its implementation. Your task is to fix them. But you *
*should not** change the `Product` class. You should crete your own class which extends the `Product` class and override
some parent's methods.

So, your task is to create your own class which extends the `Prodcut` class, implement required fixes (see the list
below)in it and change the `Task.createProduct()` method, so it returns an instance of your class instead of
the `Product`.

## Step 1

The product has several getters: `String getName()` and `int getPrice()` that should return values of
the `Product.name` and `Product.price` properties appropriately. BBut they don't. Fix it! These
methods in your class should return proper values.

## Step 2

The product also has the `int getTotalPrice()` method which should return a total price: the base price minus a
discount. But how it returns the base price and ignore the discount. Fix it!

Pay attention: The `int getTotalPrice()` method if final - you can't override it in your class. You should find another
way to make that method returns a correct value.