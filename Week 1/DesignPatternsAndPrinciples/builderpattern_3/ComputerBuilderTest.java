package builderpattern_3;

public class ComputerBuilderTest {
    public static void main(String[] args) {

        Computer basicComputer = new Computer.Builder()
                .setCpu("Intel i3")
                .setRam("8GB")
                .setStorage("256GB SSD")
                .build();

        System.out.println("Basic Computer:");
        basicComputer.showConfig();

        Computer gamingComputer = new Computer.Builder()
                .setCpu("Intel i9")
                .setRam("32GB")
                .setStorage("1TB SSD")
                .setGpu("NVIDIA RTX 4090")
                .build();

        System.out.println("Gaming Computer:");
        gamingComputer.showConfig();
    }
}
