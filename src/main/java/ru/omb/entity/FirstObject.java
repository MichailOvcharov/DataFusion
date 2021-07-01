package ru.omb.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FirstObject {
    private Integer mark01;
    private Integer mark17;
    private Integer mark23;
    private Integer mark35;
    private Integer markFV;
    private Integer markFX;
    private Integer markFT;

    public Integer getMark01() {
        return mark01;
    }

    public void setMark01(Integer mark01) {
        this.mark01 = mark01;
    }

    public Integer getMark17() {
        return mark17;
    }

    public void setMark17(Integer mark17) {
        this.mark17 = mark17;
    }

    public Integer getMark23() {
        return mark23;
    }

    public void setMark23(Integer mark23) {
        this.mark23 = mark23;
    }

    public Integer getMark35() {
        return mark35;
    }

    public void setMark35(Integer mark35) {
        this.mark35 = mark35;
    }

    public Integer getMarkFV() {
        return markFV;
    }

    public void setMarkFV(Integer markFV) {
        this.markFV = markFV;
    }

    public Integer getMarkFX() {
        return markFX;
    }

    public void setMarkFX(Integer markFX) {
        this.markFX = markFX;
    }

    public Integer getMarkFT() {
        return markFT;
    }

    public void setMarkFT(Integer markFT) {
        this.markFT = markFT;
    }
}
