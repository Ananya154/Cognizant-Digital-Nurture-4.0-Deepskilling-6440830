package proxypattern_6;

public class ImageViewer {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("photo1.jpg");
        Image image2 = new ProxyImage("photo2.jpg");

        image1.display();
        System.out.println();

        image1.display();
        System.out.println();

        image2.display();
    }
}
