# USER GUIDE

## Table of Contents
<details>
 <summary><b>ToC</b> (click to open)</summary>
 
 - [USER GUIDE](#user-guide)
   * [Iporting and Using Nu-Swing](#iporting-and-using-nu-swing)
     + [Compile and Run Using the Classpath Option](#compile-and-run-using-the-classpath-option)
       - [Common Error Messages](#common-error-messages)
         * [Some expected error messages related to compilation:](#some-expected-error-messages-related-to-compilation-)
         * [Some expected error messages related to running:](#some-expected-error-messages-related-to-running-)
     + [Add the Classpath to Environmental Variables](#add-the-classpath-to-environmental-variables)
       - [For Windows Users](#for-windows-users)
     + [Using an IDE to Add a Library to Classpath](#using-an-ide-to-add-a-library-to-classpath)
   * [Making a Shape](#making-a-shape)
     + [What Shapes Exist?](#what-shapes-exist-)
     + [How to Add a Shape to a NuWindow](#how-to-add-a-shape-to-a-nuwindow)
   * [Making a Button](#making-a-button)
   * [Using NuTextfield](#using-nutextfield)
   * [Moving an Object](#moving-an-object)
   * [NuUtils](#nuutils)
   * [API Overview](#api-overview)
     + [Nuwindow](#nuwindow)
     + [NuColor](#nucolor)
     + [NuComponent (abstract)](#nucomponent--abstract-)
       - [NuShape (abstract) - (NuComponent)](#nushape--abstract-----nucomponent-)
         * [NuPoint - (NuShape)](#nupoint----nushape-)
         * [NuLine - (NuShape)](#nuline----nushape-)
         * [NuCircle - (NuShape)](#nucircle----nushape-)
         * [NuRectangle - (NuShape)](#nurectangle----nushape-)
         * [NuPolygon - (NuShape)](#nupolygon----nushape-)
         * [NuText - (NuShape)](#nutext----nushape-)
       - [NuButton - (NuComponent)](#nubutton----nucomponent-)
       - [NuTextfield - (NuComponent)](#nutextfield----nucomponent-)
     + [NuUtils - (NuComponent)](#nuutils----nucomponent-)

</details>


## Iporting and Using Nu-Swing
Firstly, and most importantly, download `NuSwing.jar` from [GitHub](https://github.com/odinbi/Nu-Swing).
After `NuSwing.jar` is downloaded, make sure to place it in a folder you will remember, or place it in the same folder as your program.

`NuSwing.jar` located in the `jarfolder`:

![NuSwing.jar located in the jarfolder](https://github.com/odinbi/Nu-Swing/blob/main/examples/images/jarOnlyFolder.PNG)

After having downloaded and placed the `NuSwing.jar` file in a known folder, lets start by making a very simple program using `NuWindow` from the *Nu-Swing* package.

```java
import NuSwing.NuWindow;

public class MyWindow {
    public static void main(String[] args){
        NuWindow myWindow = new NuWindow("My Window", 400, 400);
    }
}
```

This will make a window object using the `NuWindow` class in *Nu-Swing*.
    
### Compile and Run Using the Classpath Option
After having made the test program we are now ready to compile and run the code. In this example the `jarfolder` folder is located in the folder with the program.

`MyWindow.java` is located in the same folder as `jarfolder`:
    
![MyWindow in same folder](https://github.com/odinbi/Nu-Swing/blob/main/examples/images/remoteTestFolder.PNG)

To compile MyWindow.java we are going to use the terminal and navigate to the folder with `MyWindow.java` and use the `javac` compile command. The java compiler can take several different command line arguments, among these we are interested in `-classpath` or `-cp`, since these both do the same we will be using `-cp` in the examples. This argument demands that we provide a file path to the folder that contains the desired classes, in this case the `jarfolder`. Since we placed `jarfolder` in the same folder as our program, we may use the OS symbol for the current dictionary `.`, i.e. the folder we navigated to in the terminal and called `javac>` in.
    
Compiling `MyWindow.java` with `javac`:
    
```
In Windows:
> javac -cp ".\jarfolder\NuSwing.jar" MyWindow.java
or
> javac -cp ".\jarfolder\*" MyWindow.jar

In Unix:
$ javac -cp "./jarfolder/NuSwing.jar" MyWindow.java
or
$ javac -cp "./jarfolder/*" MyWindow.java
```

Note that in *Windows*, path names are written with backslashes, `\`, and slashes `/` in *Unix*. If there would be several files needed in the `jarfolder` it would be possible to add an asterisk instead of directing the compiler to a specific file, e.g. `./jarfolder/*`.

After having compiled the program, we now want to run it. To do that we want to use the `java` command in the terminal with the `-cp` command again. This time we need to make sure to tell java where to find the main method, i.e. where `MyWindow.class` is. This means, we need to tell java where both `NuSwing.jar` and `MyWindow.class` is. Since we need two paths we also need a separator to separate the paths, in windows `;` is used, in unix `:`.

Running `MyWindow` with `java -cp`:

```
In Windows:
> java -cp ".;.\jarfolder\NuSwing.jar" MyWindow

In Unix:
$ java -cp ".:./jarfolder/NuSwing.jar" MyWindow
```

Result:

![MyWindowRunning](https://github.com/odinbi/Nu-Swing/blob/main/examples/images/MyWindow.PNG)

This will of course work if the `jar` file is in a totally different folder, however, then the full path is needed. For *Windows* user it would typically be something like `C:\Users\User\Documents\JarJars\NuSwing.jar`, in *Unix* it would be something like `/home/user/docs/JarJars/NuSwing.jar` alternatively `$\sim$/user/docs/JarJars/NuSwing.jar`. For further reading and an easy overview: [Wikipedia: Path (Computing)](https://en.wikipedia.org/wiki/Path\_(computing)).

#### Common Error Messages
When coding, at some point one inevitably encounters some `errors` while either trying to compile or run a program. As such, it might be nice to get a little overview of some `errors` one might encounter while using the `-cp` option.

##### Some expected error messages related to compilation:

```
# No -cp option:
> javac MyWindow.java
MyWindow.java:1: error: package NuSwing does not exist

# No -cp arguments:
> javac -cp MyWindow.java
javac: no source files

# Wrong folder:
> javac -cp "." MyWindow.java
MyWindow.java:1: error: package NuSwing does not exist

# Incomplete folder name:
> javac -cp ".\jarfolder" MyWindow.java
MyWindow.java:1: error: package NuSwing does not exist

# Correct folder, unspecified file:
> javac -cp ".\jarfolder\ " MyWindow.java
javac: no source files
```

##### Some expected error messages related to running:

```
# Forgot to add path to MyWindow (.): 
> java -cp ".\jarfolder\NuSwing.jar" MyWindow
Error: Could not find or load main class MyWindow

# Forgot to add path to NuSwing.jar:
> java -cp "." MyWindow
Exception in thread "main" java.lang.NoClassDefFoundError: NuSwing/NuWindow

# Trying to use the "*" to include files in child folders:
> java -cp ".;.\*" MyWindow
Exception in thread "main" java.lang.NoClassDefFoundError: NuSwing/NuWindow
```

### Add the Classpath to Environmental Variables

Using the classpath option with long arguments for every compilation and run call can be tedious and prone to errors, e.g. giving the wrong directory. There is, however, a way around this that lest us use the compiler and java launcher without having to worry about any extra options. By adding the desired library to environmental variables the java compiler and launcher will automatically find the library and use it without the user having to explicitly state where to find it, just like the standard java libraries.

#### For Windows Users

To add a environmental variable we need to access the `Environmental variables` panel in *Windows*. To access this panel we need to open the `This PC` &#8594; `Properties` &#8594; `Advanced System Settings` &#8594; `Environmental Variables`.

Alternatively, use the `windows` key on your keyboard and type `environment variables`. You may not need to type everything out before one of the matches shows `Edit the system environment variables`. Note that if your PC is set to a different language than English, you might have to use the corresponding name in that language, e.g. `miljøvariabler` in Norwegian.

Now that we found the panel we can go ahead and add the `classpath`. If there is no `classpath` variable under the `User variables for <Username>` click `New...` and name it `classpath`. If it exist then click `Edit...`. Now add the path to the `jar` file including the name of the `jar` file. Remember to add separators, `;`, between paths, and to add the the current directory address, `.`, at the end. The variable value should look something like this: `D:\jarjars\NuSwing.jar;.`.

It should look something like this:

![envVars](https://github.com/odinbi/Nu-Swing/blob/main/examples/images/envVars.PNG)

Since we now have added both the `NuSwing.jar` and `.` to the `classpath variable`, we should be able to compile and run the program without adding any extra options:

```
> javac MyWindow.java
> java MyWindow
```

### Using an IDE to Add a Library to Classpath

Many IDE's, such as *Eclipse* and *IntelliJ*, allows users to add `jar` libraries to the internal `classpath`. As such, if you are using an IDE for *Java*, it may be easier to use the tools the IDE offers to add the library. Thus, it's recommended to look up how to add a `jar` file to the `classpath` of your preferred IDE.

## Making a Shape
As shown in the `MyWindow` example above, making a simple `window` is very easy in *Nu-Swing*. Now we will take a look on how to make a simple `shape` with *Nu-Swing* and display it in the `window`.

### What Shapes Exist?

A `shape` in *Nu-Swing* is any class that extends `NuShape`.

There are six concrete `shapes` in *Nu-Swing*:
* `NuPoint` 
* `NuLine`
* `NuCircle`
* `NuRectangle` 
* `NuPolygon`
* `NuText`

### How to Add a Shape to a NuWindow

We will reuse the code from `MyWindow` and add to it.

The class `MyShape` adds a `NuRectangle` to a `NuWindow`:

```java
import NuSwing.NuWindow;
import NuSwing.NuRectangle;
import NuSwing.NuPoint;
import NuSwing.NuColor;

public class MyShape {

    public static void main(String[] args){
        NuWindow myWindow = new NuWindow("My Window", 400, 400);
        NuPoint myPoint = new NuPoint(100, 200);
        NuRectangle myRect = new NuRectangle(200, 100, myPoint, NuColor.WHITE);

        myRect.setOutlineColor(NuColor.BLACK);

        myWindow.addComponent(myRect);
    }
}
```

The ressult of running `MyShape`:

![MyShape run](https://github.com/odinbi/Nu-Swing/blob/main/examples/images/MyShape.PNG)

## Making a Button

The `NuButton` provides the button functionality to *Nu-Swing*. To create a button, one simply creates a `NuButton` object and add it to the `NuWindow`. There are two ways of adding functionality to the `button`. Either by the `setAction` method, or as an argument in the `constructor`. Lets look at a simple button example using both methods.

A simple `Hello World!` button. `ButtonExample` alternative 1:

```java
import NuSwing.*;

public class ButtonExample {
  public static void main(String[] args){
    NuWindow nw = new NuWindow("Button Example",
      200, 200);

    NuButton nb = new NuButton("Button",
      new NuPoint(50, 75), 100, 50, 
      () -> System.out.println("Hello World!"));

    nw.addComponent(nb);
  }
}
```

`ButtonExample` alternative 2:

```java
import NuSwing.*;

public class ButtonExample {
  public static void main(String[] args){
    NuWindow nw = new NuWindow("Button Example",
      200, 200);

    NuButton nb = new NuButton("Button",
      new NuPoint(50, 75), 100, 50);
    nb.setAction(
      () -> System.out.println("Hello World!"));
    nw.addComponent(nb);
  }
}
```

Result of running `ButtonExample`:

![ButtonExample](https://github.com/odinbi/Nu-Swing/blob/main/examples/images/ButtonExample.PNG)

When pressed:

```
> Hello World!
```

Furthermore, `NuButton` has some other features that might be worth mentioning. Giving `NuButton` and `empty function` will result in a button that can be clicked but does nothing.

```java
// the empty function
button.setAction(() -> ());
```

Giving `NuButton` no function,  `null`, will result in an inactive button that cannot be clicked.

```java
// no function
button.setAction(null);
```

## Using NuTextfield

NuTextfield mainly relies on two methods, `getText` and `setText`. Like the other components we have seen, it's simple to create a `NuTextfield`, create the object and add it to the `NuWindow`.

Transfer text from sender to receiver when button is pressed:

```java
import NuSwing.*;

public class TextfieldExample {
  public static void main(String[] args){
    NuWindow nw = new NuWindow("TF Example", 350, 250);

    NuTextfield sender = new NuTextfield("sender",
      new NuPoint(75, 175));
    NuTextfield receiver = new NuTextfield("receiver",
      new NuPoint(175, 175));

    NuButton btn = new NuButton("submit",
      new NuPoint(120, 100), 100, 50,
      () -> receiver.setText(sender.getText()));
    nw.addComponent(sender); nw.addComponent(receiver);
    nw.addComponent(btn);
  }
}
```

Running `TextfieldExample` result:

![TextfieldExample](https://github.com/odinbi/Nu-Swing/blob/main/examples/images/TextfieldExample.png)

## Moving an Object
There are mainly two ways of moving an object in *Nu-Swing*, either call `move` on the object, or move the `NuPoint` the object is located on. To move a `NuShape` there is one method, `move`, that takes a `vector` from the current location of the object to the new location. For `NuPoint` there are two methods, `move` and `moveTo`. `move` is the same as for `NuShape`, `moveTo` however, takes a `coordinate` and sets the `NuPoint`'s location to that `coordinate`. 

`move` and `moveTo` can be used to achieve the same result when objects such as `NuCircle`, which only contain one `NuPoint` as positional reference, has the same `NuPoint` referenced.

`move` the `NuCircle` to a new location when the `NuButton` is pressed with `NuLine` attached:

```java
import NuSwing.*;

public class MoveCircle {
   public static void main(String[] args){
      NuWindow nw = new NuWindow("Move Circle", 400, 400);
      NuButton nb = new NuButton("move", 
         new NuPoint(20, 100), 100, 50);
      NuPoint shared = new NuPoint(250, 200);
      NuCircle nc = new NuCircle(100, shared,
         NuColor.GRAY);
      NuLine nl = new NuLine(new NuPoint(150, 200),
         shared, NuColor.BLACK);

      nb.setAction(() -> nc.move(0, 100));
      nw.addComponent(nb); nw.addComponent(nc);
      nw.addComponent(nl);
   }
}
```

![MoveCircle](https://github.com/odinbi/Nu-Swing/blob/main/examples/images/MoveCircle.png)

As seen above, only the `NuPoint` that is also referenced in `nc` is moved.

Same example, but `move` is called on `NuLine` instead:

```java
import NuSwing.*;

public class MoveLine {
   public static void main(String[] args){
      NuWindow nw = new NuWindow("Move Line", 400, 400);
      NuButton nb = new NuButton("move", 
         new NuPoint(20, 100), 100, 50);
      NuPoint shared = new NuPoint(250, 200);
      NuCircle nc = new NuCircle(100, shared,
         NuColor.GRAY);
      NuLine nl = new NuLine(new NuPoint(150, 200),
         shared, NuColor.BLACK);

      nb.setAction(() -> nl.move(0, 100));
      nw.addComponent(nb); nw.addComponent(nc);
      nw.addComponent(nl);
   }
}
```

![MoveLine](https://github.com/odinbi/Nu-Swing/blob/main/examples/images/MoveLine.png)

As seen in this example, both the `nl` and `nc` moves when `move` is called on `nl`.

## NuUtils

`NuUtils` is a class that contains a handfull of `static` utility methods that may be helpfull for the user while using *Nu-Swing*, but not directly related to the GUI API. The methods are: `sleep`, `fileSelector`, `multiFileSelectore` and `fileSaver`. Since all the methods are `static`, the user does not need to create a `NuUtils` object.

The `sleep` method, will allow the user to let a `thread` `sleep` for a given amount of `milliseconds` without having to consider a `try catch` block for the java `Thread` class' `sleep` method.

```java
// let calling thread sleep for 1 second (1000 ms)
NuUtils.sleep(1000);
```

The other methods, are all related to `opening` or `saving` files. Both `fileSelector` and `multiFileSelector` require the `file` selected to exist, where as `fileSaver` may create a new `file` if selected filename does not resolve in an existing `file`.

```java
// fileSelector returns 1 file
File file = NuUtils.fileSelector();

// multiFileSelector returns an array of files
File[] files = NuUtils.multiFileSelector();

// fileSaver returns 1 file
File save = NuUtils.fileSaver();
```

Result of calling `NuUtlis.fileSelector()`.

![fileSelectorExample](https://github.com/odinbi/Nu-Swing/blob/main/examples/images/fileSelector.png)

## API Overview
Bellow is a comprehensive overview of all *Nu-Swing* classes and methods.

### Nuwindow
Method | Return Type | Arguments | Description
-------|-------------|-----------|------------
NuWindow | NuWindow | int x, int y | constructs a NuWindow object
NuWindow | NuWindow | String title, int x, int y | =
NuWindow | NuWindow | int x, int y, NuColor color | =
NuWindow | NuWindow | String title, int x, int y, NuColor color | =
addComponent | void | NuComponent component | adds compoenent to the element list
setColor | void | NuColor color | sets the color of NuWindow
remove | boolean | NuCompoenent component | removes component from the element list

### NuColor
Method | Return Type | Arguments | Description
-------|-------------|-----------|------------
NuColor | NuColor | int red, int green, int blue | constructs a NuColor object
NuColor | NuColor | int hexRGB | =

### NuComponent (abstract)
Method | Return Type | Arguments | Description
-------|-------------|-----------|------------
remove | boolean | none | removes NuCompoent from NuWindow
setVisible | void | boolean visible | sets visibility of NuComponent

#### NuShape (abstract) - (NuComponent)
Method | Return Type | Arguments | Description
-------|-------------|-----------|------------
setColor | void | NuColor color | sets color of NuShape
setOutlineColor | void | NuColor color | sets outline color of NuShape
setLineWidth | void | int pts | sets outline width of NuShape
rotate | void | float degrees, NuPoint point | rotates NuShape around point
move | void | float x, float y | moves NuShape

##### NuPoint - (NuShape)
Method | Return Type | Arguments | Description
-------|-------------|-----------|------------
NuPoint | NuPoint | float x, float y | constructs a NuPoint object
x | float | none | returns the x coordinate
y | float | none | returns the y coordinate
moveTo | void | float x, float y | sets new location of NuPoint

##### NuLine - (NuShape)
Method | Return Type | Arguments | Description
-------|-------------|-----------|------------
NuLine | NuLine | NuPoint a, NuPoint b | constructs a NuLine object
NuLine | NuLine | NuPoint a, NuPoint b, int lineWidth | =
NuLine | NuLine | NuPoint a, NuPoint b, NuColor color | =
NuLine | NuLine | NuPoint am Nupoint b, Nucolor color, int lineWidth | =

##### NuCircle - (NuShape)
Method | Return Type | Arguments | Description
-------|-------------|-----------|------------
NuCircle | NuCircle | float radius | constructs a NuCircle object
NuCircle | NuCircle | float radius, NuPoint point | =
NuCircle | NuCircle | float radius, NuPoint point, NuColor color | =

##### NuRectangle - (NuShape)
Method | Return Type | Arguments | Description
-------|-------------|-----------|------------
NuRectangle | NuRectangle | float width, float height | constructs a NuRectangle object
NuRectangle | NuRectangle | float width, float height, NuPoint point | =
NuRectangle | NuRectangle | float width, float height, NuPoint point, NuColor color | =

##### NuPolygon - (NuShape)
Method | Return Type | Arguments | Description
-------|-------------|-----------|------------
NuPolygon | NuPolygon | NuPoint[] points | constructs a NuPolygon object
NuPolygon | NuPolygon | NuPoint[] points, NuColor color | =

##### NuText - (NuShape)
Method | Return Type | Arguments | Description
-------|-------------|-----------|------------
NuText | NuText | String text | constructs a NuText object
NuText | NuText | String text, NuPoint point | =
NuText | NuText | String text, int pts | =
NuText | NuText | String text, int pts, NuPoint point | =
setFontSize | void | int pts | sets font size of NuPoint
setText | void | String text | sets texts of NuPoint

#### NuButton - (NuComponent)
Method | Return Type | Arguments | Description
-------|-------------|-----------|------------
NuButton | NuButton | String name, NuPoint point, int width, int height | constructs a NuButton object
NuButton | NUButton | String name, NuPoint point, int width, int height, Runnable action | =
setAction | void | Runnable action | sets action of NuButton

#### NuTextfield - (NuComponent)
Method | Return Type | Arguments | Description
-------|-------------|-----------|------------
NuTextfield | NuTextfield | String text, NuPoint point | constructs a NuTextfield object
NuTextfield | NuTextfield | String text, NuPoint point, int width, int height | =
setText | void | String text | sets text of NuTextfield
getText | String | none | retuns text from NuTextfield

### NuUtils - (NuComponent)
Method | Return Type | Arguments | Description
-------|-------------|-----------|------------
sleep | void | int ms | sleeps thread for ms milliseconds
sleep | void | none | sleeps thread for one NuWindow cycle
fileSelector | File | none | opens file selector (single file)
multiFileSelector | File[] | none | opens file selector (multiple files)
fileSaver | File | none | opens file selector (single file, may create new file)
