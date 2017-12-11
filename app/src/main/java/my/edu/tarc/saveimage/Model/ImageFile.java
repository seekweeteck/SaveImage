package my.edu.tarc.saveimage.Model;

/**
 * Created by KweeTeck on 11/1/2017.
 */

public class ImageFile {
    private int id;
    private String image;

    public ImageFile() {
    }

    public ImageFile(int id, String image) {
        this.id = id;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
