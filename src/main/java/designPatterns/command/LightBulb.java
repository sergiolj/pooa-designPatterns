package designPatterns.command;

public class LightBulb {
    private String roomName;
    private boolean isOn;

    public LightBulb(String roomName) {
        this.roomName = roomName;
        this.isOn = false;
    }

    public void turnLightOn() {
        if(!isOn) {
            System.out.println("Light bulb at the " + roomName+ " is ON");
            isOn = true;
        }else {
            System.out.println("Light bulb at the " + roomName+ " are already on");
        }
    }

    public void turnLightOff() {
        if(isOn) {
            System.out.println("Light bulb at the " + roomName+ " is OFF");
            isOn = false;
        }else{
            System.out.println("Light bulb at the " + roomName+ " are already off");
        }
    }

}
