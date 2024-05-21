package com.udemy.selenium.executearound;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.util.function.Consumer;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    private SelenideElement frameAElement = $("#a");
    private SelenideElement frameBElement = $("#b");
    private SelenideElement frameCElement = $("#c");

    private FrameA frameA;
    private FrameB frameB;
    private FrameC frameC;

    public MainPage() {
        this.frameA = new FrameA();
        this.frameB = new FrameB();
        this.frameC = new FrameC();
    }

    public void goTo() {
        open("https://vins-udemy.s3.amazonaws.com/ds/main.html");
    }

    public void onFrameA(Consumer<FrameA> consumer) {
        Selenide.switchTo().frame(frameAElement);
        consumer.accept(frameA);
        Selenide.switchTo().defaultContent();
    }

    public void onFrameB(Consumer<FrameB> consumer) {
        Selenide.switchTo().frame(frameBElement);
        consumer.accept(frameB);
        Selenide.switchTo().defaultContent();
    }

    public void onFrameC(Consumer<FrameC> consumer) {
        Selenide.switchTo().frame(frameCElement);
        consumer.accept(frameC);
        Selenide.switchTo().defaultContent();
    }
}