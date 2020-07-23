package com.javabase;


import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: java-base
 * @Author chali
 * @Description
 * @Date 2020/7/21 6:00 下午
 */
public class GenerateReceipt {

    private static int WIDTH = 1200;// 图片的宽度
    private static int HEIGHT = 600;// 图片的高度
    private static String COMPONYNAME = "华 图 教 育 财 务";
    private static String CENTERNAME = "专  用  章";

    /**
     * 保存图片
     *
     * @param fileLocation
     * @param image
     */
    public static void createImage(String fileLocation, BufferedImage image) {
        try {
            FileOutputStream fos = new FileOutputStream(fileLocation);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(bos);
            encoder.encode(image);
            bos.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 绘制收据内容
     *
     * @param graphics
     * @param param
     */
    public static void genereteContent(Graphics graphics, Map<String, String> param) {

        int high = 100;
        int wigth = 0;
        graphics.setFont(new Font("华文楷体", Font.BOLD, 50));
        graphics.drawString("收      据", 500, high);
        graphics.setFont(new Font("华文楷体", Font.BOLD, 20));
        high += 10;
        graphics.drawLine(490, high, 710, high);

        graphics.setColor(Color.black);

        high += 50;
        wigth = 750;
        graphics.setFont(new Font("华文楷体", Font.PLAIN, 20));
        graphics.drawString("No " + param.get("dateNum") + " 报名分部财务编码 " + param.get("num"), wigth, high);
        graphics.setFont(new Font("华文楷体", Font.PLAIN, 20));

        high += 100;
        wigth = 100;
        graphics.setFont(new Font("华文楷体", Font.BOLD, 30));
        graphics.drawString("今收到", wigth, high);
        graphics.drawString(param.get("studentName"), wigth + 200, high);
        graphics.setFont(new Font("华文楷体", Font.BOLD, 20));

        graphics.drawLine(180, high + 5, 1000, high + 5);

        wigth = 820;
        graphics.setFont(new Font("华文楷体", Font.BOLD, 30));
        graphics.drawString("学  员  1  名", wigth, high);
        graphics.setFont(new Font("华文楷体", Font.BOLD, 20));

        high += 100;
        wigth = 50;
        graphics.setFont(new Font("华文楷体", Font.BOLD, 30));
        graphics.drawString("人民币    " + param.get("cashCapital"), wigth, high);
        graphics.setFont(new Font("华文楷体", Font.BOLD, 20));

        graphics.drawLine(150, high + 5, 1000, high + 5);

        wigth = 520;
        graphics.setFont(new Font("华文楷体", Font.BOLD, 30));
        graphics.drawString("元整  ¥    " + param.get("amount"), wigth, high);
        graphics.setFont(new Font("华文楷体", Font.BOLD, 20));

        wigth = 970;
        graphics.setFont(new Font("华文楷体", Font.BOLD, 30));
        graphics.drawString("元", wigth, high);
        graphics.setFont(new Font("华文楷体", Font.BOLD, 20));

        high += 100;
        wigth = 50;
        graphics.setFont(new Font("华文楷体", Font.BOLD, 30));
        graphics.drawString("收款明细   " + param.get("paymentDetails"), wigth, high);
        graphics.setFont(new Font("华文楷体", Font.BOLD, 20));

        graphics.drawLine(180, high + 5, 1000, high + 5);

        high += 100;
        wigth = 800;
        graphics.setFont(new Font("华文楷体", Font.BOLD, 30));
        graphics.drawString("收款人： " + param.get("receiver"), wigth, high);
        graphics.setFont(new Font("华文楷体", Font.BOLD, 20));
    }

    /**
     * 绘制印章
     *
     * @param g
     */
    public static void generateStamp(Graphics2D g) {
        g.setColor(Color.RED);
        //设置锯齿圆滑
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //绘制圆
        int radius = 130;//周半径
        int CENTERX = WIDTH - 350;//画图所处位置
        int CENTERY = HEIGHT - 200;//画图所处位置

        Ellipse2D circle = new Ellipse2D.Double();
        circle.setFrameFromCenter(CENTERX, CENTERY, CENTERX + radius + 20, CENTERY + radius + 20);
        g.setStroke(new BasicStroke(5));
        g.draw(circle);

        //绘制中间的五角星
        g.setFont(new Font("宋体", Font.BOLD, 160));
        g.drawString("★", CENTERX - (120 / 2) + 10, CENTERY + (120 / 3) + 10);

        //添加姓名
        g.setFont(new Font("宋体", Font.LAYOUT_LEFT_TO_RIGHT, 38));// 写入签名
        g.drawString(CENTERNAME, CENTERX - (75), CENTERY + (30 + 50) + 10);

        //根据输入字符串得到字符数组
        String[] messages2 = COMPONYNAME.split("", 0);
        String[] messages = new String[messages2.length];
        System.arraycopy(messages2, 0, messages, 0, messages2.length);

        //输入的字数
        int ilength = messages.length;

        //设置字体属性
        int fontsize = 50;
        Font f = new Font("Serif", Font.BOLD, fontsize);

        FontRenderContext context = g.getFontRenderContext();
        Rectangle2D bounds = f.getStringBounds(COMPONYNAME, context);

        //字符宽度＝字符串长度/字符数
        double char_interval = (bounds.getWidth() / ilength);
        //上坡度
        double ascent = -bounds.getY();

        int first = 0, second = 0;
        boolean odd = false;
        if (ilength % 2 == 1) {
            first = (ilength - 1) / 2;
            odd = true;
        } else {
            first = (ilength) / 2 - 1;
            second = (ilength) / 2;
            odd = false;
        }

        double radius2 = radius - ascent;
        double x0 = CENTERX;
        double y0 = CENTERY - radius + ascent;
        //旋转角度
        double a = 2 * Math.asin(char_interval / (2 * radius2));

        if (odd) {
            g.setFont(f);
            g.drawString(messages[first], (float) (x0 - char_interval / 2), (float) y0);

            //中心点的右边
            for (int i = first + 1; i < ilength; i++) {
                double aa = (i - first) * a;
                double ax = radius2 * Math.sin(aa);
                double ay = radius2 - radius2 * Math.cos(aa);
                AffineTransform transform = AffineTransform.getRotateInstance(aa);//,x0 + ax, y0 + ay);
                Font f2 = f.deriveFont(transform);
                g.setFont(f2);
                g.drawString(messages[i], (float) (x0 + ax - char_interval / 2 * Math.cos(aa)), (float) (y0 + ay - char_interval / 2 * Math.sin(aa)));
            }
            //中心点的左边
            for (int i = first - 1; i > -1; i--) {
                double aa = (first - i) * a;
                double ax = radius2 * Math.sin(aa);
                double ay = radius2 - radius2 * Math.cos(aa);
                AffineTransform transform = AffineTransform.getRotateInstance(-aa);//,x0 + ax, y0 + ay);
                Font f2 = f.deriveFont(transform);
                g.setFont(f2);
                g.drawString(messages[i], (float) (x0 - ax - char_interval / 2 * Math.cos(aa)), (float) (y0 + ay + char_interval / 2 * Math.sin(aa)));
            }

        } else {
            //中心点的右边
            for (int i = second; i < ilength; i++) {
                double aa = (i - second + 0.5) * a;
                double ax = radius2 * Math.sin(aa);
                double ay = radius2 - radius2 * Math.cos(aa);
                AffineTransform transform = AffineTransform.getRotateInstance(aa);//,x0 + ax, y0 + ay);
                Font f2 = f.deriveFont(transform);
                g.setFont(f2);
                g.drawString(messages[i], (float) (x0 + ax - char_interval / 2 * Math.cos(aa)), (float) (y0 + ay - char_interval / 2 * Math.sin(aa)));
            }

            //中心点的左边
            for (int i = first; i > -1; i--) {
                double aa = (first - i + 0.5) * a;
                double ax = radius2 * Math.sin(aa);
                double ay = radius2 - radius2 * Math.cos(aa);
                AffineTransform transform = AffineTransform.getRotateInstance(-aa);//,x0 + ax, y0 + ay);
                Font f2 = f.deriveFont(transform);
                g.setFont(f2);
                g.drawString(messages[i], (float) (x0 - ax - char_interval / 2 * Math.cos(aa)), (float) (y0 + ay + char_interval / 2 * Math.sin(aa)));
            }
        }
    }

    /**
     * 绘制收据
     *
     * @param param
     */
    public static void generetaReceipt(Map<String, String> param) {
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT,
                BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.getGraphics();
        graphics.setColor(Color.pink);
        graphics.fillRect(0, 0, WIDTH, HEIGHT);
        graphics.setColor(Color.red);
        GenerateReceipt.genereteContent(graphics, param);
        Graphics2D graphics2D = image.createGraphics();
        GenerateReceipt.generateStamp(graphics2D);
        createImage("receipt.jpg", image);
    }

    public static void main(String[] args) {

        Map<String, String> param = new HashMap<>();
        param.put("dateNum", "202007220001");
        param.put("num", "0001");
        param.put("studentName", "张三");
        param.put("amount", "1000");
        param.put("cashCapital", "壹仟");
        param.put("paymentDetails", "现金：500  支付宝：500");
        param.put("receiver", "赵四");

        generetaReceipt(param);
    }
}
