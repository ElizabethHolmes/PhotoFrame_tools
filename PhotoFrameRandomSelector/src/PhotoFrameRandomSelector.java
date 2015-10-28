package photoframerandomselector;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import org.apache.commons.io.FileUtils;

public class PhotoFrameRandomSelector {

    public static void main(String[] args) throws IOException {
        
        //Creating list of files
        FileVisitor<Path> fileLister = new FileLister();
        Files.walkFileTree(Paths.get(args[0]), fileLister);
        
        //Randomising file order
        Collections.shuffle(FileLister.pictures);
        
        //Creating folder for output
        File outputFolder = new File("Random images");
        outputFolder.mkdir();
        
        for (int i=0; i < Integer.valueOf(args[1]); i++) {
            String filenamePath = FileLister.pictures.get(i).toString();
            String[] filenameArray1 = filenamePath.split("/");
            String filename = filenameArray1[filenameArray1.length-1];
            File source = new File(filenamePath);
            File destination = new File("Random images/"+filename);
            try {
                FileUtils.copyFile(source, destination);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
