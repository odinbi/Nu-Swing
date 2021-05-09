package NuSwing;

import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class NuUtils {

    /**
    * Lets the user make a thread sleep for a given amount of milliseconds
    * without having to use Thread's sleep method and make a try catch block.
    */
    public static void sleep(int ms){
        try{
            Thread.sleep(ms);
        } catch (InterruptedException e){
            System.err.println("Thread interrupted, could not sleep " + ms + "ms."
            + "\n" + e.getMessage());
        }
    }

    /**
    * Sleeps for 40 milliseconds, which is the same as the window refresh rate.
    */
    public static void sleep(){
        try{
            Thread.sleep(40);
        } catch (InterruptedException e){
            System.err.println("Thread interrupted, could not sleep."
            + "\n" + e.getMessage());
        }
    }

    //File CHOOSER METHODS
    /**
    * Opens a selection window that allows the user to select a single file.
    * Returnds the selected file
    */
    public static File fileSelector(){
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setDialogTitle("Single file selector");
        jfc.setMultiSelectionEnabled(false);
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int retval = jfc.showOpenDialog(null);
        if (retval == JFileChooser.APPROVE_OPTION){
            return jfc.getSelectedFile();
        }
        return null;
    }

    /**
    * opens a selection window that allows the user to select multiple files.
    * Returns a list of selected files.
    */
    public static File[] multiFileSelector(){
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setDialogTitle("Multiple file selector");
        jfc.setMultiSelectionEnabled(true);
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int retval = jfc.showOpenDialog(null);

        if (retval == JFileChooser.APPROVE_OPTION){
            return jfc.getSelectedFiles();
        }
        return null;
    }

    /**
    * opens a selection window that allows the user to select a single file
    * if the file doesn't exist it will be created to the abstract path given.
    * Returns the selected file.
    */
    public static File fileSaver(){
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setDialogTitle("Multiple file selector");
        jfc.setMultiSelectionEnabled(true);
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);

        File file = null;
        int retval = jfc.showSaveDialog(null);
        if (retval == JFileChooser.APPROVE_OPTION){
            file = jfc.getSelectedFile();
            if(!file.exists()){
                try{
                    file.createNewFile();
                } catch(IOException e){
                    System.err.println("Could not create file: " + file.getAbsolutePath() +
                    "\nCaught error: " + e.getMessage());
                    file = null;
                }
            }
        }
        return file;
    }
    //end file chooser methods
}
