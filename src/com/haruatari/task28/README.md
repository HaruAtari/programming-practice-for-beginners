# Pivot the map

You should implement the `Map<Integer, String> Task.pivot(Map<String, Integer> map)` method which takes the map. It
should pivot that map (swap the keys and values) and return it.
map.

For example, for the next input (in pseudocode):

```
Map(
    "str1" => 10,
    "str2" => 20
)
```

the method should return the net map:

```
Map(
    10 => "str1",
    20 => "str2"
)
```

Pay attention: The input map always has unique values. So you don't have to worry about duplicated keys in the result.