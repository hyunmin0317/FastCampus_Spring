package com.company.design;

import com.company.design.adapter.*;
import com.company.design.aop.AopBrowser;
import com.company.design.decorator.*;
import com.company.design.facade.SftpClient;
import com.company.design.observer.Button;
import com.company.design.observer.IButtonListener;
import com.company.design.proxy.BrowserProxy;
import com.company.design.proxy.IBrowser;
import com.company.design.singleton.Aclazz;
import com.company.design.singleton.Bclazz;
import com.company.design.singleton.SocketClient;
import com.company.design.strategy.*;

import java.util.concurrent.atomic.AtomicLong;

public class Main {

    public static void main(String[] args) {

//        01. 싱글톤 패턴
        Aclazz aClazz = new Aclazz();
        Bclazz bClazz = new Bclazz();
        SocketClient aClient = aClazz.getSocketClient();
        SocketClient bClient = bClazz.getSocketClient();
        System.out.println("두개의 객체가 동일한가?");
        System.out.println(aClient.equals(bClient));

//        02. 어댑터 패턴
        HairDryer hairDryer = new HairDryer();
        connect(hairDryer);
        Cleaner cleaner = new Cleaner();
        Electronic110V adapter = new SocketAdapter(cleaner);
        connect(adapter);
        AirConditioner airConditioner = new AirConditioner();
        Electronic110V airAdapter = new SocketAdapter(airConditioner);
        connect(airAdapter);
        
//        03. 프록시 패턴
//        03-1. proxy
        IBrowser browser = new BrowserProxy("www.naver.com");
        browser.show();
        browser.show();
        browser.show();

//        03-2. aop
        AtomicLong start = new AtomicLong();
        AtomicLong end = new AtomicLong();
        IBrowser aopBrowser = new AopBrowser("www.naver.com",
                    ()->{
                        System.out.println("before");
                        start.set(System.currentTimeMillis());
                    },
                    ()->{
                        long now = System.currentTimeMillis();
                        end.set(now - start.get());
                    }
                );
        aopBrowser.show();
        System.out.println("loading time : "+end.get());
        aopBrowser.show();
        System.out.println("loading time : "+end.get());

//        04. 데코레이터 패턴
        ICar audi = new Audi(1000);
        audi.showPrice();
        // a3
        ICar audi3 = new A3(audi, "A3");
        audi3.showPrice();
        // a4
        ICar audi4 = new A4(audi, "A4");
        audi4.showPrice();
        // a5
        ICar audi5 = new A5(audi, "A5");
        audi5.showPrice();

//        05. 옵저버 패턴
        Button button = new Button("버튼");
        button.addListener(new IButtonListener() {
            @Override
            public void clickEvent(String event) {
                System.out.println(event);
            }
        });
        button.click("메시지 전달 : click 1");
        button.click("메시지 전달 : click 2");
        button.click("메시지 전달 : click 3");

//        06. 파사드 패턴
        SftpClient sftpClient = new SftpClient("www.foo.co.kr", 22, "/home/etc", "text.tmp");
        sftpClient.connect();
        sftpClient.write();
        sftpClient.read();
        sftpClient.disConnect();

//        07. 전략 패턴

        Encoder encoder = new Encoder();

        // base64
        EncodingStrategy base64 = new Base64Strategy();

        // normal
        EncodingStrategy normal = new NormalStrategy();

        String message = "hello java";
        encoder.setEncodingStrategy(base64);
        String base64Result = encoder.getMessage(message);
        System.out.println(base64Result);

        encoder.setEncodingStrategy(normal);
        String normalResult = encoder.getMessage(message);
        System.out.println(normalResult);

        encoder.setEncodingStrategy(new AppendStrategy());
        String appendResult = encoder.getMessage(message);
        System.out.println(appendResult);

    }

    // 콘센트
    public static void connect(Electronic110V electronic110V){
        electronic110V.powerOn();
    }
}
