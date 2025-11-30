package designPatterns.builder.computer;

public class Main {
    public static void main(String[] args) {

        Computer officeComputer = new Computer.ComputerBuilder(
                "Ryzen 9",
                new RAMSpecs(RAMType.DDR4, RAMSize.GB8),
                "SSD M2 1Tb")
                .build();

        System.out.println(officeComputer.toString());

        Computer gamerComputer = officeComputer.toBuild()
                .withRam(new RAMSpecs(RAMType.DDR5, RAMSize.GB64))
                .withCoolingSystem("Corsair Water Cooler")
                .withBluetooth(true)
                .build();

        System.out.println(gamerComputer.toString());
    }
}
