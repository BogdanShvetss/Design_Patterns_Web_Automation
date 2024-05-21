package com.udemy.selenium.srp.result;

import com.udemy.selenium.srp.common.SearchSuggestion;
import com.udemy.selenium.srp.common.SearchWidget;

public class GoogleResultsPage {
    private SearchSuggestion searchSuggestion = new SearchSuggestion();
    private SearchWidget searchWidget = new SearchWidget();
    private NavigationBar navigationBar = new NavigationBar();
    private ResultStats resultStats = new ResultStats();

    public SearchSuggestion getSearchSuggestion() {
        return searchSuggestion;
    }

    public SearchWidget getSearchWidget() {
        return searchWidget;
    }

    public NavigationBar getNavigationBar() {
        return navigationBar;
    }

    public ResultStats getResultStats() {
        return resultStats;
    }
}