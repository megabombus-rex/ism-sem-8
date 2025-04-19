package jczech.pwr.ism.ism_lab02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy(proxyTargetClass=true)
@SpringBootApplication
public class IsmLab02Application {

    public static void main(String[] args) {
        SpringApplication.run(IsmLab02Application.class, args);
    }

}
