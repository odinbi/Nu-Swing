# USER GUIDE
## Iporting and Using Nu-Swing
Firstly, and most importantly, download NuSwing.jar from [GitHub](https://github.com/odinbi/Nu-Swing).
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

Note that in windows, path names are written with backslashes, `\`, but Unix uses slashes, `/`, i used. If there would be several files needed in the `jarfolder` it would be possible to add an asterisk instead of directing the compiler to a specific file, e.g. `./jarfolder/*`.

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

Some expected error messages related to compilation:

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

Some expected error messages related to running:

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

There are six concrete `shapes` in *Nu-Swing*: `NuPoint, NuLine, NuCircle, NuRectangle, NuPolygon` and `NuText`.

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

[MyShape run](https://github.com/odinbi/Nu-Swing/blob/main/examples/images/MyShape.PNG)

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

[ButtonExample](https://github.com/odinbi/Nu-Swing/blob/main/examples/images/ButtonExample.PNG)

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

[TextfieldExample](https://github.com/odinbi/Nu-Swing/blob/main/examples/images/TextfieldExample.png)

## Moving an Object
