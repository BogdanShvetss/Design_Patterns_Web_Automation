package com.udemy.selenium.srp.common;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$$;

public class SearchSuggestion extends AbstractComponent {

    private ElementsCollection suggestions = $$("ul[role='listbox'] > li.sbct");

    public void clickSuggestionByIndex(int index) {
        this.suggestions.get(index - 1).click();
    }

    @Override
    public boolean isDisplayed() {
        return Selenide.Wait().until((d) -> this.suggestions.size() > 5);
    }
}