package ru.omb.entity;

public class JsonItog
{
    FirstObject firstObject;
    SecondObject secondObject;
    ThirdObject thirdObject;

    public JsonItog(FirstObject firstObject, SecondObject secondObject, ThirdObject thirdObject) {
        this.firstObject = firstObject;
        this.secondObject = secondObject;
        this.thirdObject = thirdObject;
    }

    public JsonItog() {
    }

    public FirstObject getFirstObject() {
        return firstObject;
    }

    public void setFirstObject(FirstObject firstObject) {
        this.firstObject = firstObject;
    }

    public SecondObject getSecondObject() {
        return secondObject;
    }

    public void setSecondObject(SecondObject secondObject) {
        this.secondObject = secondObject;
    }

    public ThirdObject getThirdObject() {
        return thirdObject;
    }

    public void setThirdObject(ThirdObject thirdObject) {
        this.thirdObject = thirdObject;
    }
}
