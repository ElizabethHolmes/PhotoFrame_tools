# PhotoFrameRandomSelector
## About
PhotoFrameRandomSelector is a Java program for selecting images to display in a digital photo frame. Many digital photo frames display only a limited number of images; this program allows random selection of user-specified number of images, to enable a mixed set of images to be displayed. It could also be used to randomly select images for other purposes.

## Requirements
PhotoFramePhotoModifier requires a Java Runtime Environment.

## Usage
PhotoFrameModifier has two required arguments: a directory containing images, and the number of images to be selected.

## Example
To select 1000 photos from the directory 'Images', the command would be:

    java -jar PhotoFramePhotoModifier.jar Images 1000
  
## Output
PhotoFrameModifier generates a directory named 'Random images' containing the specified number of randomly selected images.
