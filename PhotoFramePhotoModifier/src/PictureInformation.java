package photoframephotomodifier;

import java.awt.Image;
import javax.swing.ImageIcon;

public class PictureInformation {
    
  float height;
  float width;
  float ratio1;
  float ratio2;
  boolean orientation;
    
   public PictureInformation(Image image) {
        ImageIcon imageIcon = new ImageIcon(image);
        height = imageIcon.getIconHeight();
        width = imageIcon.getIconWidth();
        ratio1 = width/height;
        ratio2 = height/width;
        if (ratio1 > 1) {
            this.orientation = true;
        } else {
            this.orientation = false;
        }
   }   
}
