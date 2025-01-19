package org.example.module16._4;

public class IconPrototype {
    private Icon prototype;

    public IconPrototype(Icon prototype) {
        this.prototype = prototype;
    }

    public void setPrototype(Icon prototype) {
        this.prototype = prototype;
    }

    public Icon getCopy() {
        return (Icon) prototype.copy();
    }
}
