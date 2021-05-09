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
