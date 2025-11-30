package designPatterns.builder.computer;

public interface GenericComputerBuilder {
    GenericComputerBuilder withCpu(String cpu);
    GenericComputerBuilder withRam(RAMSpecs ram);
    GenericComputerBuilder withDisk(String disk);
    GenericComputerBuilder withVideoCard(String videoCard);
    GenericComputerBuilder withBluetooth(boolean bluetooth);
    GenericComputerBuilder withCoolingSystem(String coolingSystem);

    Computer build();
}
