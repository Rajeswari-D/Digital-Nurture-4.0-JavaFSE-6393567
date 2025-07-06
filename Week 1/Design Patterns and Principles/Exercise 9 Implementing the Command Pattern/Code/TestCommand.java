public class TestCommand {
    public static void main(String[] args) {
        Light livingRoomLight = new Light();

        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);

        RemoteControl remote = new RemoteControl();

        System.out.println(">>> Turning ON the light");
        remote.setCommand(lightOn);
        remote.pressButton();

        System.out.println(">>> Turning OFF the light");
        remote.setCommand(lightOff);
        remote.pressButton();
    }
}