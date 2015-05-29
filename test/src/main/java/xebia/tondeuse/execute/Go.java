package xebia.tondeuse.execute;

import xebia.tondeuse.task.TondeuseFactory;
import xebia.tondeuse.task.TondeuseFactoryImpl;

public class Go {

	public static void main(String[] args) {

		TondeuseFactory fact = new TondeuseFactoryImpl();
		fact.startMachines();

	}

}
