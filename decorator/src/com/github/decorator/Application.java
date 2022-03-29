package com.github.decorator;

public class Application {

    private final static String FILE_NAME = "out/OutputDemo.txt";

    public static void main(String[] args) {
        String salaryRecords = "Name,Salary\nJohn Smith,100000\nSteven Jobs,912000";
        DataSourceDecorator encoded = new CompressionDecorator(
                new EncryptionDecorator(
                        new FileDataSource(FILE_NAME)));

        encoded.writeData(salaryRecords);

        DataSource plain = new FileDataSource(FILE_NAME);

        System.out.println("- Input -----------------");
        System.out.println(salaryRecords);
        System.out.println("- Encoded ---------------");
        System.out.println(plain.readData());
        System.out.println("- Decoded ---------------");
        System.out.printf(encoded.readData());
    }
}
