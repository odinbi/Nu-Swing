# USER GUIDE
## Iporting and Using Nu-Swing
Firstly, and most importantly, download NuSwing.jar from [GitHub](https://github.com/odinbi/Nu-Swing).
After `<NuSwing.jar>` is downloaded, make sure to place it in a folder you will remember, or place it in the same folder as your program.

`<NuSwing.jar>` located in the `<jarfolder>`:

![NuSwing.jar located in the jarfolder](https://github.com/odinbi/Nu-Swing/blob/main/examples/images/jarOnlyFolder.PNG)

After having downloaded and placed the `<NuSwing.jar>` file in a known folder, lets start by making a very simple program using `<NuWindow>` from the *Nu-Swing* package.

```java
import NuSwing.NuWindow;

public class MyWindow {
    public static void main(String[] args){
        NuWindow myWindow = new NuWindow("My Window", 400, 400);
    }
}
```

This will make a window object using the `<NuWindow>` class in *Nu-Swing*.
    
## Compile and Run Using the Classpath Option
fter having made the test program, example code \ref{MyWindow-Example}, we are now ready to compile and run the code. In this example the `<jarfolder>` folder is located in the folder with the program.

`<MyWindow.java>` is located in the same folder as `<jarfolder>`:
    
![MyWindow in same folder](https://github.com/odinbi/Nu-Swing/blob/main/examples/images/remoteTestFolder.PNG)

To compile MyWindow.java we are going to use the terminal and navigate to the folder with `<MyWindow.java>` and use the `<javac>` compile command. The java compiler can take several different command line arguments, among these we are interested in `<-classpath>` or `<-cp>`, since these both do the same we will be using `<-cp>` in the examples. This argument demands that we provide a file path to the folder that contains the desired classes, in this case the `<jarfolder>`. Since we placed `<jarfolder>` in the same folder as our program, we may use the OS symbol for the current dictionary `<.>`, i.e. the folder we navigated to in the terminal and called `<javac>` in.
    
Compiling `<MyWindow.java>` with `<javac>`:
    
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

Note that in windows, path names are written with backslashes, `<\>`, but Unix uses slashes, `</>`, i used. If there would be several files needed in the `<jarfolder>` it would be possible to add an asterisk instead of directing the compiler to a specific file, e.g. `<./jarfolder/*>`.

After having compiled the program, we now want to run it. To do that we want to use the `<java>` command in the terminal with the `<-cp>` command again. This time we need to make sure to tell java where to find the main method, i.e. where `<MyWindow.class>` is. This means, we need to tell java where both `<NuSwing.jar>` and `<MyWindow.class>` is. Since we need two paths we also need a separator to separate the paths, in windows `<;>` is used, in unix `<:>`.
