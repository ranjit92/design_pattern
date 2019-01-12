package designpattern.observer;

import java.util.Scanner;

public class ObserverTest {

	public static void main(String[] args) {
		Subject subject = new Subject();
		new HexObserver(subject);
		new OctObserver(subject);
		new BinObserver(subject);
		
		Scanner scanner = new Scanner(System.in);
		for(int i = 0; i < 5 ; i++){
			System.out.println("\nEnter next number: ");
			subject.setState(scanner.nextInt());
		}
	}

}
