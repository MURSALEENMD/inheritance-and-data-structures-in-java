package animal;

import java.util.ArrayList;

/**
 * A class for managing animals.
 * @author lbrandon
 *
 */
public class AnimalsManager {

	//instance variables
	
	/**
	 * List of all animals.
	 */
	ArrayList<Animal> animals;
	
	//constructor
	
	/**
	 * Creates AnimalsManager and initializes list of all animals.
	 */
	public AnimalsManager() {
		//initializes animals ArrayList
		this.animals = new ArrayList<Animal>();
	}
	
	//methods
	
	/**
	 * Prints the list of animals.
	 */
	public void printAnimals() {
		//iterate over list of animals and print each one
		for (Animal a : this.animals) {
			//this will call the toString method in the respective animal class
			//toString in Animal class or overridden toString in subclass of Animal
			System.out.println(a);  
		}
	}
	
	/**
	 * Tells all animals to speak.
	 */
	public void animalsSpeak() {
		for (Animal a : this.animals) {
			//this will call the speak method in the respective animal class
			//speak in Animal class or overridden speak in subclass of Animal
			a.speak();
		}
	}
	
	
	
	
	public static void main(String[] args) {
		
		//create generic animal
		Animal animal = new Animal(2);
		
		//calls setName defined in Animal class
		animal.setName("Bob the animal");
		
		//print the animal
		//this calls toString defined in Animal class
		System.out.println(animal);
		
		//create a dog
		Dog dog1 = new Dog(4, "Pug");
		
		//calls setName defined in Animal class
		dog1.setName("Puggles");
		
		//create another dog
		Dog dog2 = new Dog(9, "Pug");
		
		//calls setName defined in Animal class
		dog2.setName("Puggles");
		
		//create a cat
		Cat cat1 = new Cat(8);
		cat1.setName("Teddy"); //calls setName defined in Animal class
		cat1.setType("outside"); //calls setType defined in Cat class
		
		//calls toString defined in Cat class
		System.out.println(cat1);
		
		//create instance of AnimalsManager
		AnimalsManager animalsManager = new AnimalsManager();
		
		//add each animal to arraylist animals
		animalsManager.animals.add(animal);
		animalsManager.animals.add(dog1);
		animalsManager.animals.add(dog2);
		animalsManager.animals.add(cat1);
		
		//print all animals in animals manager
		System.out.println(""); //blank line
		animalsManager.printAnimals(); //calls toString in each class
		
		animalsManager.animalsSpeak(); //calls speak in each class
		
		//compare dog1 to dog2
		//are they equal?
		System.out.println(""); //blank line
		//calls equals method defined in dog class
		System.out.println("dog1.equals(dog2): " + dog1.equals(dog2));
		
		//calls setBreed defined in Dog class
		dog2.setBreed("Golden retriever");
		System.out.println("dog1.equals(dog2): " + dog1.equals(dog2));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
