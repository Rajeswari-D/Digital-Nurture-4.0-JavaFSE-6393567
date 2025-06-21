import java.time.LocalDateTime;
import java.util.UUID;

public class Computer {
    private final String id;
    private final String cpu;
    private final int ram;
    private final int hdd;
    private final boolean gpu;
    private final String os;
    private final LocalDateTime time;

    private Computer(Builder b) {
        this.id = UUID.randomUUID().toString();
        this.cpu = b.cpu;
        this.ram = b.ram;
        this.hdd = b.hdd;
        this.gpu = b.gpu;
        this.os = b.os;
        this.time = LocalDateTime.now();
    }

    public static class Builder {
        private final String cpu;
        private final int ram;

        private int hdd = 256;
        private boolean gpu = false;
        private String os = "FreeDOS";

        public Builder(String cpu, int ram) {
            this.cpu = cpu;
            this.ram = ram;
        }

        public Builder setHdd(int hdd) {
            this.hdd = hdd;
            return this;
        }

        public Builder setGpu(boolean gpu) {
            this.gpu = gpu;
            return this;
        }

        public Builder setOs(String os) {
            this.os = os;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }

    public void show() {
        System.out.println("=============================");
        System.out.println("ID   : " + id);
        System.out.println("Time : " + time);
        System.out.println("-----------------------------");
        System.out.println("CPU  : " + cpu);
        System.out.println("RAM  : " + ram + "GB");
        System.out.println("HDD  : " + hdd + "GB");
        System.out.println("GPU  : " + (gpu ? "Yes" : "No"));
        System.out.println("OS   : " + os);
        System.out.println("=============================\n");
    }
}
