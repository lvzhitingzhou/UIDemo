package com.saku.uidemo.data;

/**
 * MenuChart的数据
 */
public class Pie {
    /*触摸时展示*/
    private String name;
    private String label;
    private int labelColor;
    private int drawableId;
    private int angle;
    private double max_bmp_size; // 内切bitmap最大宽高
    private float weight;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getLabelColor() {
        return labelColor;
    }

    public void setLabelColor(int labelColor) {
        this.labelColor = labelColor;
    }

    public int getDrawableId() {
        return drawableId;
    }

    public void setDrawableId(int drawableId) {
        this.drawableId = drawableId;
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }

    public double getMax_bmp_size() {
        return max_bmp_size;
    }

    public void setMax_bmp_size(double max_bmp_size) {
        this.max_bmp_size = max_bmp_size;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}
