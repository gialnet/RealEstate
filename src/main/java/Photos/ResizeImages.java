/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * otra libreria http://www.thebuzzmedia.com/software/imgscalr-java-image-scaling-library/#download
 * otra imagenJ
 */
package Photos;

import java.io.File;
import java.io.IOException;
import net.coobird.thumbnailator.Thumbnails;

/**
 *
 * @author antonio
 */
public class ResizeImages {

    public ResizeImages() {
    }
    
    /**
     * Ajustar el tamaño de una imagen JPG
     * @param image
     * @throws IOException 
     */
    public void ResizeJPG(String image) throws IOException{
        
        Thumbnails.of(new File(image))
                .size(160, 160)
                .toFile(new File("thumbnail.jpg"));
    }
}
