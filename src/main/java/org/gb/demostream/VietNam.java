package org.gb.demostream;

public class VietNam implements Greeting{
    @Override
    public void greet(String name) {
        System.out.println("Xin chào " + name);
    }
}
