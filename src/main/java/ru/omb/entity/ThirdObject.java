package ru.omb.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ThirdObject {
    private List<Integer> mark01;
    private List<Integer> mark17;
    private List<Integer> mark23;
    private List<Integer> mark35;
    private List<Integer> markFV;
    private List<Integer> markFX;
    private List<Integer> markFT;

    public List<Integer> getMark01() {
        return mark01;
    }

    public void setMark01(List<Integer> mark01) {
        this.mark01 = mark01;
    }

    public List<Integer> getMark17() {
        return mark17;
    }

    public void setMark17(List<Integer> mark17) {
        this.mark17 = mark17;
    }

    public List<Integer> getMark23() {
        return mark23;
    }

    public void setMark23(List<Integer> mark23) {
        this.mark23 = mark23;
    }

    public List<Integer> getMark35() {
        return mark35;
    }

    public void setMark35(List<Integer> mark35) {
        this.mark35 = mark35;
    }

    public List<Integer> getMarkFV() {
        return markFV;
    }

    public void setMarkFV(List<Integer> markFV) {
        this.markFV = markFV;
    }

    public List<Integer> getMarkFX() {
        return markFX;
    }

    public void setMarkFX(List<Integer> markFX) {
        this.markFX = markFX;
    }

    public List<Integer> getMarkFT() {
        return markFT;
    }

    public void setMarkFT(List<Integer> markFT) {
        this.markFT = markFT;
    }
}
