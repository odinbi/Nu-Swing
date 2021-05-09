#USER GUIDE
##Iporting and Using Nu-Swing
Firstly, and most importantly, download NuSwing.jar from [GitHub](https://github.com/odinbi/Nu-Swing).
After NuSwing.jar is downloaded, make sure to place it in a folder you will remember, or place it in the same folder as your program.

![NuSwing.jar located in the jarfolder](image here)

After having downloaded and placed the NuSwing.jar file in a known folder, lets start by making a very simple program using <NuWindow> from the Nu-Swing package.

```java
import NuSwing.NuWindow;

public class MyWindow {
    public static void main(String[] args){
        NuWindow myWindow = new NuWindow("My Window", 400, 400);
    }
}
```
