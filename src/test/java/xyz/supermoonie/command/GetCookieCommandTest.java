package xyz.supermoonie.command;

import org.junit.Test;
import xyz.supermoonie.controller.WebViewController;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 *
 * Created by wangchao on 2018/4/19.
 */
public class GetCookieCommandTest {

    @Test
    public void getCookie() {
        WebViewController controller = null;
        try {
            controller = new WebViewController(new InetSocketAddress("127.0.0.1", 7100));

            LoadCommand loadCommand = new LoadCommand("https://persons.shgjj.com");
            String loadData = controller.sendCommand(loadCommand);
            System.out.println(loadData);

            GetCookieCommand getCookieCommand = new GetCookieCommand();
            String cookieData = controller.sendCommand(getCookieCommand);
            System.out.println(cookieData);

            Thread.sleep(10000);
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