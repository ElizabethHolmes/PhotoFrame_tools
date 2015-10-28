package photoframephotomodifier;

import java.io.File;
import java.io.FilenameFilter;

public class PictureFilter implements FilenameFilter {
    
    String extension;
    
    public PictureFilter(String extension) {
        this.extension = "."+extension;
    }
    @Override
    public boolean accept (File dir, String name) {
        return name.endsWith(extension);
    }
}
