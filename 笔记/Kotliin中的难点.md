## Kotliin中的难点

### 函数类型

什么是函数类型？首先你可以先理解为一种数据结构！也就是类似与Int之类的。

但是这种数据结构有一定的局限性。以后我们会重点讨论这个问题。

在Java中我们常常通过接口的回调来传递一个方法（函数）到另一个函数中。也就是常说的函数可以调用函数，但是在Java中必须通过接口来调用，将这个函数通过参数的方式传过去。但是接口是什么？接口是一个可以实例化的功能定义的东西（实现必须在其实现的类中定义，实例化的是可以通过匿名函数来定义(override)）具体一点，也就是回调：设计一个接口，接口封装了方法，再将这个接口实例化（抽象类不可以实例化）然后传入

所以对于	Java来说，我们必须通过上述来实现这样的调用。但Kotlin不一样，Kotlin可以通过传递函数类型进行传递。当一个函数含有函数类型的参数的时候，你可以但是也必须通过传入一个函数类型的对象给它。

例子：如果b函数传递给a函数并且想让a函数调用他

```kotlin
fun a(funParam:(Int)->String):String{//定义a函数传入的参数是函数类型这个函数输入Int返回String
    return funParam(1)
}
```

上面我们所说的是函数类型作为参数传输给其，当然也可以作为返回值

```kotlin
fun c(param:Int):(Int)->Unit{
    ...
}
```

以上的a与c函数统称为高阶函数

所以我们继续，如何传递进去？

直接a(b)？当然不是

对于你需要传递这个参数来说，你必须在函数名的左边加上双冒号才可以将它传递过去

```kotlin
a(::b)
val d = ::b
```

所以::method是什么？

这个其实叫做函数的引用，表示指向的函数。两个：：代表的是实例化类对象。也就是说将这个参数进行实例化，将其变成一个对象，然后再传递给函数

所以以下三者是等价的

```kotlin
b(1) // 调用函数
d(1) // 用对象 a 后面加上括号来实现 b() 的等价操作
(::b)(1) // 用对象 :b 后面加上括号来实现 b() 的等价操作
```

实际d(1)就是调用d.invoke(1) 

但是你不能直接写

```kotlin
b.invoke(1)
```

为什么？因为invoke是类对象的方法，是一种数据类型的方法，而d是什么？只是一个函数，函数和函数类型不一样！函数类型是指向函数的一个对象，所以你可以对对象进行传参数，但是你不能传函数声明！

### 匿名函数

当我们了解了函数类型，我们现在再来看什么是匿名函数，我们说过，我们的目的是传入一个类对象来进行操作。

那么我们还有一种方法，利用匿名函数来表示函数类型。

```kotlin
a(fun(param:Int):String){
    return param.toString()
}
```

