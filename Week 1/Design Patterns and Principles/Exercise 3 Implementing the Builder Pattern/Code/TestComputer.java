public class TestComputer {
    public static void main(String[] args) {
        System.out.println("Building configurations...\n");

        Computer basic = new Computer.Builder("i3", 8).build();

        Computer gamer = new Computer.Builder("Ryzen 9", 32)
                .setHdd(2048)
                .setGpu(true)
                .setOs("Windows 11")
                .build();

        Computer dev = new Computer.Builder("i7", 16)
                .setHdd(1024)
                .setOs("Ubuntu")
                .build();

        basic.show();
        gamer.show();
        dev.show();
    }
}
