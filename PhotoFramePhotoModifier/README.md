# PhotoFramePhotoModifier
## About
PhotoFramePhotoModifier is a Java program for editing images to display in a digital photo frame. It crops the images if necessary so that their aspect ratio is 4:3, resizes them to a resolution of 800 x 600 for lanscape images and 450 x 600 for portrait images, and adds a title comprised of a date (or other user-defined specifier) and a name.

## Requirements
PhotoFramePhotoModifier requires a Java Runtime Environment.

## Usage
PhotoFrameModifier takes as its input a directory containing images in sub-directories. The directory structure should be as follows:
- Level 1 - Directory used as input
- Level 2 - Directories named by date (e.g. '2015'), or other specifier
- Level 3 - Directories named by another specifier (e.g. 'Mountain biking holiday')
- Level 4 - Images

## Example
To modify photos in the directory 'Images', the command would be:

    java -jar PhotoFramePhotoModifier.jar Images
  
## Output
PhotoFrameModifier generates a directory named 'Output images' containing modified versions of all the images in the directory specified as an input parameter. An example of what the images with title look like is shown in the file '2015 - Mountain biking holiday.jpg'.
