package org.example.module16._5;

import org.example.IModule;

public class Module16_5 implements IModule {
    @Override
    public Object[][] dataProvider() {
        return new Object[][] {
                new Object[] {}
        };
    }

    @Override
    public void execute(Object[][] data) {
        AppSettings appSettings = AppSettings.getInstance();
        System.out.println(appSettings);
        appSettings.setLang("ru");
        System.out.println(AppSettings.getInstance());
    }
}
