package org.example.module16._4;

import org.example.IModule;

public class Module16_4 implements IModule {
    @Override
    public Object[][] dataProvider() {
        return new Object[][] {
                new Object[] {}
        };
    }

    @Override
    public void execute(Object[][] data) {
        Icon icon = new Icon("test");
        System.out.println(icon);
        IconPrototype prototype = new IconPrototype(icon);
        Icon iconCopy = prototype.getCopy();
        icon.setName("test2");
        System.out.println(icon);
        System.out.println(iconCopy);
    }
}
