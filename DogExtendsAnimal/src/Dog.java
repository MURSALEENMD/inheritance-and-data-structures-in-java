/**
 * Represents a Dog.
 * @author MURSALEEN
 *
 */
public class Dog extends Animal {

	@Override
	public void greeting() {
		System.out.println("I am a dog.");
		super.greeting(); //call greeting method in superclass Animal
	}
}
