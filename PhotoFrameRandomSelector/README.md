# PhotoFrameRandomSelector
## About
PhotoFrameRandomSelector is a Java program for selecting images to display in a digital photo frame. Many digital photo frames display only a limited number of images; this program allows random selection of user-specified number of images, to enable a mixed set of images to be displayed. It could also be used to randomly select images for other purposes.

** PLEASE NOTE: PhotoFrameRandomSelector is one of my first Java programs written as a beginner Java programmer and so I apologise if the code is inelegant, unconventional or otherwise sub-optimal; it works for the intended purpose and I provide it in case it might be useful to others, but with no guarantees. **

## Requirements
PhotoFramePhotoModifier requires a Java Runtime Environment.

## Usage
PhotoFrameModifier has two required arguments: a directory containing images, and the number of images to be selected.

## Example
To select 1000 photos from the directory 'Images', the command would be:

    java -jar PhotoFramePhotoModifier.jar Images 1000
  
## Output
PhotoFrameModifier generates a directory named 'Random images' containing the specified number of randomly selected images.
