import java.io.*;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import static java.nio.file.Files.delete;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        File dir = new File("C:\\forTestJava");
        File[] listOffFiles = dir.listFiles();
        ArrayList<String> fileLIst = new ArrayList<>();
        assert listOffFiles != null;
        for (File file : listOffFiles) {
            if (file.isFile()) {
                fileLIst.add(file.getCanonicalPath());
            }
        }
        zipFiles("C:/forTestJava/testRar.zip", fileLIst);
        deleteDataFile(listOffFiles);
    }

    private static void zipFiles(String zipName, ArrayList<String> filenames) throws IOException {
        if (filenames == null || filenames.isEmpty()) {
            return;
        }

        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(zipName))) {
            for (String fileName : filenames) {
                try (FileInputStream fis = new FileInputStream(fileName)) {
                    ZipEntry entry = new ZipEntry(fileName);
                    zout.putNextEntry(entry);
                    byte[] buffer = new byte[fis.available()];//считываем
                    zout.write(buffer);//записываем
                    zout.closeEntry();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private static void deleteDataFile(File[] files) throws IOException, InterruptedException {
        if (files == null) {
            return;
        }
        for (File file : files) {
            Thread.sleep(2000);
            delete(file.toPath());
        }
    }
}

