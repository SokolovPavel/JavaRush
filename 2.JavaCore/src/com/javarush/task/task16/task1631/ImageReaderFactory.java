package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes type)throws IllegalArgumentException{

        ImageReader imager = null;
         if(type == ImageTypes.JPG)imager = new JpgReader();
         else if(type == ImageTypes.BMP)imager = new BmpReader();
         else if(type == ImageTypes.PNG)imager = new PngReader();
         else {
             throw new IllegalArgumentException("Неизвестный тип картинки");

         }
         return imager;
    }
}
