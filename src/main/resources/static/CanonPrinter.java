package com.example.hahowspringboot;

import com.example.hahowspringboot.model.Printer;
import org.springframework.stereotype.Component;

//抖紅字 option + enter
@Component
public class CanonPrinter implements Printer {
    private int count;


    @Override
    public void print(String message) {
        System.out.println("Canon印表機："+message);

    }
}
