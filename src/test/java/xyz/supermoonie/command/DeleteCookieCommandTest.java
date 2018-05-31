package xyz.supermoonie.command;

import org.junit.Test;
import xyz.supermoonie.controller.WebViewDriver;
import xyz.supermoonie.expection.ExpectedConditions;
import xyz.supermoonie.parser.GetCookieParser;
import xyz.supermoonie.wait.Wait;

import java.io.IOException;
import java.net.HttpCookie;
import java.net.InetSocketAddress;
import java.net.URL;
import java.util.List;

public class DeleteCookieCommandTest {

    @Test
    public void deleteCookie() {
        WebViewDriver driver = null;
        try {
            driver = new WebViewDriver(new InetSocketAddress("127.0.0.1", 7100));
            Wait wait = new Wait(driver);
            wait.until(new LoadCommand(new URL("https://persons.shgjj.com")), ExpectedConditions.loadFinished());

            DeleteCookieCommand deleteCookieCommand = new DeleteCookieCommand();
            driver.sendCommand(deleteCookieCommand);

            GetCookieCommand getCookieCommand = new GetCookieCommand();
            List<HttpCookie> cookieList = driver.sendCommand(getCookieCommand, new GetCookieParser());

            System.out.println(cookieList);

            Thread.sleep(1500);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (driver != null) {
                    driver.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}