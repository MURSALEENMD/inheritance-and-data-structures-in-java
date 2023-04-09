package animal;

/**
 * Represents a cat and extends the Animal class.
 * @author lbrandon
 *
 */
public class Cat extends Animal {
	
	//static variables
	
	/**
	 * Default type for cat.
	 */
	static String DEFAULT_TYPE = "domestic";
	
	//instance variables
	
	/**
	 * Type of cat.
	 */
	private String type;
	
	//Also inherits variables defined in the Animal superclass.
	
	//constructor
	
	/**
	 * Create a cat with given age.
	 * @param age of cat
	 */
	public Cat(int age) {
		//calls constructor in superclass Animal
		super(age);
		
		//set type of cat to default value
		this.type = Cat.DEFAULT_TYPE;
	}

	//getters/setters
	
	/**
	 * Gets the type of cat.
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the type of cat.
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	//other methods
	
	/**
	 * Overrides speak method in superclass Animal.
	 * Cat speaks.
	 */
	@Override
	public void speak() {
		System.out.println(this.name + " says: Meow!");
	}
	
	/**
	 * Returns the name and type of this cat for printing.
	 */
	@Override
	public String toString() {
		return this.name + " is a " + this.type;
	}
	
}