package com.awt;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;

public class ImageView extends Component {
    private Image image;

    public ImageView() {
    }

    public ImageView(String pathname) throws IOException {
        InputStream is = new FileInputStream(pathname);
        this.image = ImageIO.read(is);
        is.close();
    }

    @Override
    public void paint(Graphics g) {
//        g.setColor(Color.BLACK);
//        g.fillRect(0, 0, getWidth(), getHeight());
//        g.setColor(Color.RED);    //画笔改成红色
//        //在中间画个圆角矩形边框
//        g.drawRoundRect(getWidth() / 4, getHeight() / 4, getWidth() / 2, getHeight() / 2, 30, 30);
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        g.setColor(Color.CYAN);
        g.drawString("Beautiful Miss", 100, 120);
    }
}
