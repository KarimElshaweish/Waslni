package com.example.root.waslni;
public class faculty {
    private  int id;
    private  String key,val;
    public  faculty(){

    }
    public faculty(String key){
        this.key=key;
    }
    public  faculty(String key,String val){
        this.key=key;
        this.val=val;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }
}
