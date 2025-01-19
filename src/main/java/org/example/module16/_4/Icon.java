package org.example.module16._4;

import java.util.Random;

public class Icon implements GUIObject {
    private String name;
    private int height;
    private int width;

    public Icon(String name) {
        this.name = name;
        // допустим что сюда приходит не просто имя, а файл. И высота с шириной берется по итогу считывания файла, для простоты заменено рандомом
        this.height = new Random().nextInt(1600);
        this.width = new Random().nextInt(1600);
    }

    public Icon(Icon icon) {
        this.name = icon.name;
        this.height = icon.height;
        this.width = icon.width;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Object copy() {
        return new Icon(this);
    }

    @Override
    public String toString() {
        return "Icon{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", width=" + width +
                '}';
    }
}
