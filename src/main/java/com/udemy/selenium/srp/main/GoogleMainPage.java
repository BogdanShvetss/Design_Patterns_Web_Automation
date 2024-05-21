package com.udemy.selenium.srp.main;

import com.codeborne.selenide.Selenide;
import com.udemy.selenium.srp.common.SearchSuggestion;
import com.udemy.selenium.srp.common.SearchWidget;

public class GoogleMainPage {
    private SearchWidget searchWidget = new SearchWidget();
    private SearchSuggestion searchSuggestion = new SearchSuggestion();

    public void goTo() {
        Selenide.open("https://google.com");
    }

    public SearchWidget getSearchWidget() {
        return searchWidget;
    }

    public SearchSuggestion getSearchSuggestion() {
        return searchSuggestion;
    }
}