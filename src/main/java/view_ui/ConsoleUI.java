package view_ui;

import presenter.Presenter;

import java.util.Scanner;

public class ConsoleUI implements View {
    private Scanner scanner;
    private Presenter presenter;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
    }

    @Override
    public void start() {
        while (true){
            String city = scan();
            presenter.getInfo(city);
        }

    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }
    private String scan(){
        System.out.println("Введите город: ");
        return scanner.nextLine();
    }
}
