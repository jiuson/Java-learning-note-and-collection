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
import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: java-base
 * @Author chali
 * @Description
 * @Date 2020/7/21 6:00 下午
 */
public class ReceiptUtil {

    private static int WIDTH = 1200;// 图片的宽度
    private static int HEIGHT = 600;// 图片的高度
    private static String COMPONYNAME = "华 图 教 育 财 务";
    private static String CENTERNAME = "专  用  章";

    public static class ReceiptParam {
        private String no;
        private String studentName;
        private String amount;
        private String cashCapital;
        private List<String> paymentDetails;
        private String receiver;
        private String filePath;

        public String getNo() {
            return no;
        }

        public void setNo(String no) {
            this.no = no;
        }

        public String getStudentName() {
            return studentName;
        }

        public void setStudentName(String studentName) {
            this.studentName = studentName;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getCashCapital() {
            return cashCapital;
        }

        public void setCashCapital(String cashCapital) {
            this.cashCapital = cashCapital;
        }

        public List<String> getPaymentDetails() {
            return paymentDetails;
        }

        public void setPaymentDetails(List<String> paymentDetails) {
            this.paymentDetails = paymentDetails;
        }

        public String getReceiver() {
            return receiver;
        }

        public void setReceiver(String receiver) {
            this.receiver = receiver;
        }

        public String getFilePath() {
            return filePath;
        }

        public void setFilePath(String filePath) {
            this.filePath = filePath;
        }
    }

    /**
     * 保存图片
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
            throw new RuntimeException("图片生成失败");
        }
    }

    /**
     * 绘制收据内容
     * @param graphics
     * @param param
     */
    public static void generateContent(Graphics graphics, ReceiptParam param) {

        int high = 100;
        int wigth = 0;
        graphics.setFont(new Font("华文楷体", Font.BOLD, 50));
        graphics.drawString("收      据", 500, high);
        graphics.setFont(new Font("华文楷体", Font.BOLD, 20));
        high += 10;
        graphics.drawLine(490, high, 710, high);

        graphics.setColor(Color.black);

        high += 50;
        wigth = 850;
        graphics.setFont(new Font("华文楷体", Font.BOLD, 20));
        graphics.drawString("No " + param.getNo(), wigth, high);
        graphics.setFont(new Font("华文楷体", Font.BOLD, 20));

        high += 80;
        wigth = 100;
        graphics.setFont(new Font("华文楷体", Font.BOLD, 30));
        graphics.drawString("今收到", wigth + 50, high);
        graphics.drawString(param.getStudentName(), wigth + 300, high);
        graphics.setFont(new Font("华文楷体", Font.BOLD, 20));

        graphics.drawLine(245, high + 5, 1120, high + 5);

        high += 80;
        wigth = 80;
        graphics.setFont(new Font("华文楷体", Font.BOLD, 30));
        graphics.drawString("人民币    " + param.getCashCapital(), wigth, high);
        graphics.setFont(new Font("华文楷体", Font.BOLD, 20));

        wigth = 750;
        graphics.setFont(new Font("华文楷体", Font.BOLD, 30));
        graphics.drawString("¥    " + param.getAmount() , wigth, high);
        graphics.setFont(new Font("华文楷体", Font.BOLD, 20));

        graphics.drawLine(168, high + 5, 1105, high + 5);

        wigth = 1105;
        graphics.setFont(new Font("华文楷体", Font.BOLD, 30));
        graphics.drawString("元", wigth, high);
        graphics.setFont(new Font("华文楷体", Font.BOLD, 20));

        high += 80;
        wigth = 80;
        graphics.setFont(new Font("华文楷体", Font.BOLD, 30));
        graphics.drawString("收款明细  ", wigth, high);
        graphics.setFont(new Font("华文楷体", Font.BOLD, 20));
        graphics.drawLine(200, high + 5, 1120, high + 5);
        if (param.getPaymentDetails().size() <= 3) {
            for (String paymentDetail : param.getPaymentDetails()) {
                graphics.setFont(new Font("华文楷体", Font.BOLD, 30));
                graphics.drawString(paymentDetail + "    ", wigth += 200, high);
            }
        }else {
            for (int i = 0; i < 3; i++) {
                graphics.setFont(new Font("华文楷体", Font.BOLD, 30));
                graphics.drawString(param.getPaymentDetails().get(i) + "    ", wigth += 200, high);
            }
            wigth = 80;
            high += 100;
            for (int i = 3; i < param.getPaymentDetails().size(); i++) {
                graphics.setFont(new Font("华文楷体", Font.BOLD, 30));
                graphics.drawString(param.getPaymentDetails().get(i) + "    ", wigth += 200, high);
            }
            graphics.setFont(new Font("华文楷体", Font.BOLD, 20));
            graphics.drawLine(80, high + 5, 1120, high + 5);
        }


        high += 45;
        wigth = 900;
        graphics.setFont(new Font("华文楷体", Font.BOLD, 30));
        graphics.drawString("收款人： " + param.getReceiver(), wigth, high);
        graphics.setFont(new Font("华文楷体", Font.BOLD, 20));
    }

    /**
     * 绘制印章
     * @param g
     */
    public static void generateStamp(Graphics2D g) {
        g.setColor(Color.RED);
        //设置锯齿圆滑
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //绘制圆
        int radius = 130;//周半径
        int CENTERX = WIDTH - 280;//画图所处位置
        int CENTERY = HEIGHT - 230;//画图所处位置

        Ellipse2D circle = new Ellipse2D.Double();
        circle.setFrameFromCenter(CENTERX, CENTERY, CENTERX + radius + 20, CENTERY + radius + 20);
        g.setStroke(new BasicStroke(5));
        g.draw(circle);

        //绘制中间的五角星
        g.setFont(new Font("宋体", Font.BOLD, 160));
        g.drawString("★", CENTERX-(120/2) + 10, CENTERY+(120/3) + 10);

        //添加姓名
        g.setFont(new Font("宋体", Font.LAYOUT_LEFT_TO_RIGHT, 38));// 写入签名
        g.drawString(CENTERNAME, CENTERX -(75), CENTERY +(90));

        //根据输入字符串得到字符数组
        String[] messages2 = COMPONYNAME.split("",0);
        String[] messages = new String[messages2.length];
        System.arraycopy(messages2,0,messages,0,messages2.length);

        //输入的字数
        int ilength = messages.length;

        //设置字体属性
        int fontsize = 45;
        Font f = new Font("Serif", Font.BOLD, fontsize);

        FontRenderContext context = g.getFontRenderContext();
        Rectangle2D bounds = f.getStringBounds(COMPONYNAME, context);

        //字符宽度＝字符串长度/字符数
        double char_interval = (bounds.getWidth() / ilength);
        //上坡度
        double ascent = -bounds.getY();

        int first = 0,second = 0;
        boolean odd = false;
        if (ilength%2 == 1)
        {
            first = (ilength-1)/2;
            odd = true;
        }
        else
        {
            first = (ilength)/2-1;
            second = (ilength)/2;
            odd = false;
        }

        double radius2 = radius - ascent;
        double x0 = CENTERX;
        double y0 = CENTERY - radius + ascent;
        //旋转角度
        double a = 2*Math.asin(char_interval/(2*radius2));

        if (odd)
        {
            g.setFont(f);
            g.drawString(messages[first], (float)(x0 - char_interval/2), (float)y0);

            //中心点的右边
            for (int i=first+1;i<ilength;i++)
            {
                double aa = (i - first) * a;
                double ax = radius2 * Math.sin(aa);
                double ay = radius2 - radius2 * Math.cos(aa);
                AffineTransform transform = AffineTransform.getRotateInstance(aa);//,x0 + ax, y0 + ay);
                Font f2 = f.deriveFont(transform);
                g.setFont(f2);
                g.drawString(messages[i], (float)(x0 + ax - char_interval/2* Math.cos(aa)), (float)(y0 + ay - char_interval/2* Math.sin(aa)));
            }
            //中心点的左边
            for (int i=first-1;i>-1;i--)
            {
                double aa = (first - i) * a;
                double ax = radius2 * Math.sin(aa);
                double ay = radius2 - radius2 * Math.cos(aa);
                AffineTransform transform = AffineTransform.getRotateInstance(-aa);//,x0 + ax, y0 + ay);
                Font f2 = f.deriveFont(transform);
                g.setFont(f2);
                g.drawString(messages[i], (float)(x0 - ax - char_interval/2* Math.cos(aa)), (float)(y0 + ay + char_interval/2* Math.sin(aa)));
            }

        }
        else
        {
            //中心点的右边
            for (int i=second;i<ilength;i++)
            {
                double aa = (i - second + 0.5) * a;
                double ax = radius2 * Math.sin(aa);
                double ay = radius2 - radius2 * Math.cos(aa);
                AffineTransform transform = AffineTransform.getRotateInstance(aa);//,x0 + ax, y0 + ay);
                Font f2 = f.deriveFont(transform);
                g.setFont(f2);
                g.drawString(messages[i], (float)(x0 + ax - char_interval/2* Math.cos(aa)), (float)(y0 + ay - char_interval/2* Math.sin(aa)));
            }

            //中心点的左边
            for (int i=first;i>-1;i--)
            {
                double aa = (first - i + 0.5) * a;
                double ax = radius2 * Math.sin(aa);
                double ay = radius2 - radius2 * Math.cos(aa);
                AffineTransform transform = AffineTransform.getRotateInstance(-aa);//,x0 + ax, y0 + ay);
                Font f2 = f.deriveFont(transform);
                g.setFont(f2);
                g.drawString(messages[i], (float)(x0 - ax - char_interval/2* Math.cos(aa)), (float)(y0 + ay + char_interval/2* Math.sin(aa)));
            }
        }
    }

    /**
     * 绘制收据
     * @param param
     */
    public static void generateReceipt(ReceiptParam param) {
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT,
                BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.getGraphics();
        graphics.setColor(Color.PINK);
        graphics.fillRect(0, 0, WIDTH, HEIGHT);
        graphics.setColor(Color.red);
        ReceiptUtil.generateContent(graphics, param);
        Graphics2D graphics2D = image.createGraphics();
        ReceiptUtil.generateStamp(graphics2D);
        createImage(param.getFilePath(), image);
    }

    public static void main(String[] args){

        long amount = 100001100;
        ReceiptParam param = new ReceiptParam();
        param.setNo("20200722" + "22233" + "0002");
        param.setStudentName("张三");
        param.setAmount("1000");
        param.setCashCapital("壹仟");
        List<String> paymentDetails = new ArrayList<>();
        paymentDetails.add("现金：500");
        paymentDetails.add("支付宝：500");
        paymentDetails.add("微信：500");
//        paymentDetails.add("易联宝：500");
        param.setPaymentDetails(paymentDetails);
        param.setReceiver("赵四");
        param.setFilePath(param.getNo() + ".jpg");
        generateReceipt(param);

//        Set<Long> a = Sets.newHashSet();
//        a.add(99L);
//        a.add(19L);
//        String s = JsonUtil.toJsonString(a);
//        System.out.println(s);
//
//        Set<Long> b = JsonUtil.fromJson(s, Set.class);
//        System.out.println(b);

//        Map<String, Long> payMap = Maps.newHashMap();
//        Long l = payMap.get("微信");
//        System.out.println(l);
    }
}

