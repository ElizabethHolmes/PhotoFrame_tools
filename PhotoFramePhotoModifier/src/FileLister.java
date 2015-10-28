package photoframephotomodifier;

import java.io.IOException;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.util.ArrayList;

public class FileLister extends SimpleFileVisitor<Path> {
    
    static ArrayList pictures = new ArrayList();
    
    @Override public FileVisitResult visitFile(Path aFile, BasicFileAttributes aAttrs) throws IOException {
        String aFileString = aFile.toString();
        if (aFileString.endsWith("jpg")) {
            pictures.add(aFile);
        }
      return FileVisitResult.CONTINUE;
    }  
}
