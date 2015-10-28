package photoframephotomodifier;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class PhotoFramePhotoModifier {

    public static void main(String[] args) throws IOException {
        
        //Creating list of files
        FileVisitor<Path> fileLister = new FileLister();
        Files.walkFileTree(Paths.get(args[0]), fileLister);
        
        for (int i=0; i < FileLister.pictures.size(); i++) {
            
            //Creating title from filename
            String filenamePath = FileLister.pictures.get(i).toString();
            String[] filenameArray = filenamePath.split("/");
            String filename = filenameArray[filenameArray.length-1];
            String date = filenameArray[filenameArray.length-3];
            String name = filenameArray[filenameArray.length-2];
            String title = date+" - "+name;

            
            try {
                Image image = ImageIO.read(new File(filenamePath));
                PictureInformation pictureInformation = new PictureInformation(image);
                  
                //Cropping picture to correct aspect ratio if necessary
                if (pictureInformation.ratio2 < 0.75) {
                    double h = pictureInformation.height;
                    double w = Math.round((double)pictureInformation.height/3*4);
                    int y = 1;
                    double x = Math.round((pictureInformation.width - w)/2);
                    image = Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(image.getSource(), new CropImageFilter((int)x,y,(int)w,(int)h)));
                } else if (pictureInformation.ratio2 > 0.75 && pictureInformation.orientation == true) {
                    double w = pictureInformation.width;
                    double h = Math.round((double)pictureInformation.width/4*3);
                    int x = 1;
                    double y = Math.round((pictureInformation.height - h)/2);
                    image = Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(image.getSource(), new CropImageFilter(x,(int)y,(int)w,(int)h)));
                } else if (pictureInformation.ratio1 < 0.75) {
                    double w = pictureInformation.width;
                    long h = Math.round((double)pictureInformation.width/3*4);
                    int x = 1;
                    double y = Math.round((pictureInformation.height - h)/2);
                    image = Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(image.getSource(), new CropImageFilter(x,(int)y,(int)w,(int)h)));
                } else if (pictureInformation.ratio1 > 0.75 && pictureInformation.orientation == false) {
                    double h = pictureInformation.height;
                    double w = Math.round((double)pictureInformation.height/4*3);
                    int y = 1;
                    double x = Math.round((pictureInformation.width - w)/2);
                    image = Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(image.getSource(), new CropImageFilter((int)x,y,(int)w,(int)h)));
                }
               
                //Resizing picture
                if (pictureInformation.orientation == true) {
                    image = image.getScaledInstance(800,600,Image.SCALE_SMOOTH);
                } else {
                    image = image.getScaledInstance(450,600,Image.SCALE_SMOOTH);
                }
                
                //Creating frame and image components
                JFrame frame = new JFrame();
                frame.setSize(800,622);
                JLayeredPane layeredPane = new JLayeredPane();
                layeredPane.setBackground(Color.black);
                layeredPane.setOpaque(true);
                ImageIcon icon = new ImageIcon(image);
                JLabel imageLabel = new JLabel(icon);
                imageLabel.setBounds((800-icon.getIconWidth())/2, 0, icon.getIconWidth(), icon.getIconHeight());
                
                //Adding title
                JLabel titleLabel = new JLabel(title);
                titleLabel.setBackground(Color.black);
                titleLabel.setOpaque(true);
                titleLabel.setForeground(Color.white);
                titleLabel.setHorizontalAlignment(JLabel.CENTER);
                Font font = new Font("Century Gothic",Font.BOLD,16);
                titleLabel.setFont(font);
                titleLabel.setBounds((800-icon.getIconWidth())/2, 550, icon.getIconWidth(), 50);
                
                //Adding image and title to frame
                layeredPane.add(imageLabel, new Integer (0));
                layeredPane.add(titleLabel, new Integer (1));
                frame.add(layeredPane);
                frame.setVisible(true);
                
                 //Creating folder for output
                File outputFolder = new File("Output images");
                outputFolder.mkdir();

                //Saving contents of frame as file
                Container content = frame.getContentPane();
                BufferedImage output = new BufferedImage(content.getWidth(), content.getHeight(), BufferedImage.TYPE_INT_RGB);
                Graphics2D g2d = output.createGraphics();
                content.printAll(g2d);
                g2d.dispose();
                frame.dispose();
                try {
                    ImageIO.write(output, "jpg", new File("Output images/"+date+" - "+filename));
                    output.flush();
                    output=null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        } 
    System.exit(0);    
    }    
}
