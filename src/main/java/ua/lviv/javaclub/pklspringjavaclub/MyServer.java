package ua.lviv.javaclub.pklspringjavaclub;

import org.springframework.stereotype.Service;

@Service
public class MyServer {

    public MyServer(AppConfig.Server config) {
        System.out.println("config = " + config);
    }

}
