package Classes;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    private String getLastModified(File file) {
        if (file.exists()) {
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
            return formatter.format(file.lastModified());
        } else {
            System.out.println("File not found.");
        }
        return null;
    }

    public List<File> getFileNames() {
        File file = new File("inventory/");
        File[] files = file.listFiles();

        List<File> fileList = new ArrayList<>();
        for (var f : files) {
            if (f.toString().endsWith(".csv")) {
                fileList.add(f);
            }
        }
        return fileList;
    }

    public List<File> getFiles() {
        File file = new File("inventory/");
        File[] files = file.listFiles();

        System.out.printf("   %-35s %10s", "Name", "Date Modified");
        System.out.println();

        int cntr = 0;
        List<File> fileList = new ArrayList<>();
        for (var f : files) {
            if (f.toString().endsWith(".csv")) {
                System.out.printf("%d. %-35s %10s", ++cntr, f.getName(), getLastModified(f));
                System.out.println();
                fileList.add(f);
            }
        }
        System.out.println();

        return fileList;
    }

}
