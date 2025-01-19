package org.example.module16._5;

public class AppSettings {
    private static AppSettings instance;

    private String lang;
    private String theme;

    private AppSettings() {
        lang = "en";
        theme = "light";
    }

    public static AppSettings getInstance() {
        if (null == instance) {
            instance = new AppSettings();
        }
        return instance;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    @Override
    public String toString() {
        return "AppSettings{" +
                "lang='" + lang + '\'' +
                ", theme='" + theme + '\'' +
                '}';
    }
}
