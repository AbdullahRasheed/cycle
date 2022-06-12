package me.abdullah.game.files;

import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.io.FilenameUtils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class ImageLoader {

    private static final Map<String, BufferedImage> images = new HashMap<>();

    public static void loadAssets(String category) throws IOException {
        URL url = ImageLoader.class.getClassLoader().getResource("assets/" + category);

        if(url == null) return; // TODO log something here

        File file = new File(url.getPath());
        if(!file.isDirectory()) return; // TODO log something here

        for (File f : file.listFiles()) {
            images.put(FilenameUtils.removeExtension(f.getName()), Thumbnails.of(f).scale(1).asBufferedImage());
            // TODO scale the image based on unit here
            // TODO log something here
        }
    }

    public static BufferedImage getThumbnail(String asset){
        return images.get(asset);
    }

    public static Thumbnails.Builder<BufferedImage> getThumbnailBuilder(String asset){
        return Thumbnails.of(images.get(asset));
    }
}