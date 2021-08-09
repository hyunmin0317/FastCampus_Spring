package com.company.design;

import com.company.design.adapter.*;
import com.company.design.aop.AopBrowser;
import com.company.design.proxy.Browser;
import com.company.design.proxy.BrowserProxy;
import com.company.design.proxy.IBrowser;
import com.company.design.singleton.Aclazz;
import com.company.design.singleton.Bclazz;
import com.company.design.singleton.SocketClient;

import java.util.concurrent.atomic.AtomicLong;

public class Main {

    public static void main(String[] args) {

//        01. 싱글톤 패턴
//        Aclazz aClazz = new Aclazz();
//        Bclazz bClazz = new Bclazz();
//        SocketClient aClient = aClazz.getSocketClient();
//        SocketClient bClient = bClazz.getSocketClient();
//        System.out.println("두개의 객체가 동일한가?");
//        System.out.println(aClient.equals(bClient));

//        02. 어댑터 패턴
//        HairDryer hairDryer = new HairDryer();
//        connect(hairDryer);
//        Cleaner cleaner = new Cleaner();
//        Electronic110V adapter = new SocketAdapter(cleaner);
//        connect(adapter);
//        AirConditioner airConditioner = new AirConditioner();
//        Electronic110V airAdapter = new SocketAdapter(airConditioner);
//        connect(airAdapter);
        
//        03. 프록시 패턴
//        03-1. proxy
//        IBrowser browser = new BrowserProxy("www.naver.com");
//        browser.show();
//        browser.show();
//        browser.show();

//        03-2. aop
//        AtomicLong start = new AtomicLong();
//        AtomicLong end = new AtomicLong();
//        IBrowser aopBrowser = new AopBrowser("www.naver.com",
//                    ()->{
//                        System.out.println("before");
//                        start.set(System.currentTimeMillis());
//                    },
//                    ()->{
//                        long now = System.currentTimeMillis();
//                        end.set(now - start.get());
//                    }
//                );
//        aopBrowser.show();
//        System.out.println("loading time : "+end.get());
//        aopBrowser.show();
//        System.out.println("loading time : "+end.get());

//        04. 데코레이터 패턴
//        05. 옵저버 패턴
//        06. 파사드 패턴
//        07. 전략 패턴

    }

    // 콘센트
    public static void connect(Electronic110V electronic110V){
        electronic110V.powerOn();
    }
}
