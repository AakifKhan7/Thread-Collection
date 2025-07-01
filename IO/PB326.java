package IO;

import java.io.File;

/*
 * Write a program to create directories (/home/abc/bcd/def/ghi/jkl) in the
home directory /home/abc and list the files and directories showing
file/directory,file size. Read-writeexecute permissions
 */

public class PB326 {
    public static void main(String[] args) {
        String baseDir = "/home/abc";
        String nestedDirs = "bcd/def/ghi/jkl";

        String fullPath = baseDir + "/" + nestedDirs;

        File directory = new File(fullPath);
        if (!directory.exists()) {
            boolean success = directory.mkdirs();
            if (!success) {
                System.out.println("Failed to create directories.");
                return;
            }
        }
        System.out.println("List of files and directories with permissions:");
        permitioncheck(directory);
    }

    static void permitioncheck(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                String name = file.getName();
                String type = file.isFile() ? "File" : "Directory";
                String permissions = "Read: " + file.canRead() + ", Write: " + file.canWrite() + ", Execute: "
                        + file.canExecute();
                System.out.println(name + " - " + file.getAbsolutePath() + " - " + type + " - " + permissions);
            }
        }
    }
}
