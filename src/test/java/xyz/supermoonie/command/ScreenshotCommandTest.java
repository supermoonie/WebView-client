package xyz.supermoonie.command;

import org.junit.Test;
import xyz.supermoonie.controller.WebViewController;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Random;

/**
 *
 * Created by wangchao on 2018/4/19.
 */
public class ScreenshotCommandTest {

    @Test
    public void captcha() {
        for (int i = 0; i < 1; i ++) {
            WebViewController controller = null;
            try {
                controller = new WebViewController(new InetSocketAddress("127.0.0.1", 7100));

                LoadCommand loadCommand = new LoadCommand("https://juejin.im/entry/5ae2c177f265da0b722ad90b");
                String loadData = controller.sendCommand(loadCommand);
                System.out.println(loadData);

                ScreenshotCommand screenshotCommand = new ScreenshotCommand("body");
                String captchaData = controller.sendCommand(screenshotCommand);
                System.out.println(captchaData);

                Thread.sleep(1000);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (controller != null) {
                        controller.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void test() throws InterruptedException {
        ScreenshotCommandTest test = new ScreenshotCommandTest();
        new Thread(test::captcha).start();
        new Thread(test::captcha).start();
        new Thread(test::captcha).start();
        new Thread(test::captcha).start();
        Thread.sleep(Integer.MAX_VALUE);
    }

    @Test
    public void random() {
        Random random = new Random();
        random.ints(50, 0, 1000).forEach(System.out::println);

    }

}