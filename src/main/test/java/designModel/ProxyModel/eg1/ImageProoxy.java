package designModel.ProxyModel.eg1;

/**
 * Created by longjinwen on 11/10/2017.
 */
public class ImageProoxy implements Image {
    private Image image;
    public ImageProoxy(Image image){
        this.image = image;
    }

    public void show() {
        if(image == null){
            image = new BigImage();
        }
        image.show();
    }
}
