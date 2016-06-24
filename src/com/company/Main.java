package com.company;

public class Main {

    public static void main(String[] args) {
	    Computer computer = new Computer();
        computer.copy();
    }
}

// Facade
class Computer{
    private Power power = new Power();
    private DVDRom dvd = new DVDRom();
    private HDD hdd = new HDD();

    public void copy(){
        power.on();
        dvd.load();
        hdd.copyFromDVD(dvd);
    }
}

class Power{
    public void on(){
        System.out.println("Power ON");
    }
    public void off(){
        System.out.println("Power OFF");
    }
}

class DVDRom{
    private boolean data = false;
    public boolean hasData(){
        return data;
    }
    public void load(){
        data = true;
    }
    public void unload(){
        data = false;
    }
}

class HDD{
    public void copyFromDVD(DVDRom dvd){
        if (dvd.hasData()){
            System.out.println("Copying . . . ");
        }else{
            System.out.println("Enter disk with data");
        }
    }
}
