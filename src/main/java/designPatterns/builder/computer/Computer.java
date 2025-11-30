package designPatterns.builder.computer;

public class Computer {

    private final String cpu;
    private final RAMSpecs ram;
    private final String disk;
    private final String videoCard;
    private final boolean bluetooth;
    private final String coolingSystem;

    private Computer(ComputerBuilder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.disk = builder.disk;
        this.videoCard = builder.videoCard;
        this.bluetooth = builder.bluetooth;
        this.coolingSystem = builder.coolingSystem;
    }

    public String getCpu() {
        return cpu;
    }

    public RAMSpecs getRam() {
        return ram;
    }

    public String getDisk() {
        return disk;
    }

    public String getVideoCard() {
        return videoCard;
    }

    public boolean isBluetooth() {
        return bluetooth;
    }

    public String getCoolingSystem() {
        return coolingSystem;
    }

    public ComputerBuilder toBuild() {
        return new ComputerBuilder(this);
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", ram='" + ram + '\'' +
                ", disk='" + disk + '\'' +
                ", videoCard='" + videoCard + '\'' +
                ", bluetooth=" + bluetooth +
                ", coolingSystem='" + coolingSystem + '\'' +
                '}';
    }

    public static class ComputerBuilder implements GenericComputerBuilder {
        private String cpu;
        private RAMSpecs ram;
        private String disk;

        /*This settings could be left unsettle*/
        private String videoCard = "onBoard";
        private boolean bluetooth = false;
        private String coolingSystem = "Default Cooler Box";

        public ComputerBuilder(String cpu, RAMSpecs ram, String disk) {
            this.cpu = cpu;
            this.ram = ram;
            this.disk = disk;
        }

        /**
         * Use this to create a copy from an existent computer to make modifications
         * @param computer main classe object copy.
         */
        public ComputerBuilder(Computer computer) {
            this.cpu = computer.cpu;
            this.ram = computer.ram;
            this.disk = computer.disk;
            this.videoCard = computer.videoCard;
            this.bluetooth = computer.bluetooth;
            this.coolingSystem = computer.coolingSystem;
        }

        @Override
        public ComputerBuilder withCpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        @Override
        public ComputerBuilder withRam(RAMSpecs ram) {
            this.ram = ram;
            return this;
        }

        @Override
        public ComputerBuilder withDisk(String disk) {
            this.disk = disk;
            return this;
        }

        @Override
        public ComputerBuilder withVideoCard(String videoCard) {
            this.videoCard = videoCard;
            return this;
        }

        @Override
        public ComputerBuilder withBluetooth(boolean bluetooth) {
            this.bluetooth = bluetooth;
            return this;
        }

        @Override
        public ComputerBuilder withCoolingSystem(String coolingSystem) {
            this.coolingSystem = coolingSystem;
            return this;
        }

        @Override
        public Computer build() {
            return new Computer(this);
        }
    }
}
