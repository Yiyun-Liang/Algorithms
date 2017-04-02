## Object-Oriented Design

#### Java modifiers recap:
- Visible to the package, the default. No modifiers are needed.
- Visible to the class only (private).
- Visible to the world (public).
- Visible to the package and all subclasses(in other packages) (protected).

- public > protected > no modifier > private

- fields in an interface by default: public static final
- methods in an interface by default: public abstract

#### How to approach
1) Handle Ambiguity

- questions are intentionally made vague, clarify!
	- *who* is going to use it
	- *how* they are going to use it
	- maybe all 6 Ws, *what, where, when, why*

	- eg. design a coffee maker
		- used in a massive restaurant servicing hundreds of customers per hour
		- provides ten different types of coffee products
		- or just used by a elderly

2) Define the Core Objects

- eg. design a restaurant
	- core objects: Table, Guest, Party, Order, Employee, Server, Host, etc

3) Analyze Relationships

- do they inherit from others
- are they members of which other objects
- are relationships one-to-many or many-to-many
- be CAREFUL with assumptions

- eg. Server and Host inherit from Employee
- eg. one host for one resturant

4) Investigate Actions

- eg. a Guest requests a Table, etc
- eg. when Party leaves, Tables are freed

#### Design Patterns

1) Singleton Class

- ensures that a class has only one instance, ensures access to that instance
- eg. one restaurant
- can interfere with unit testing

```
public class Restaurant{
	private static Restaurant instance = null;
	protected Restaurant() {...}
	public static Restaurant getInstance(){
		if(instance == null){
			instance = new Restaurant();
		}
		return instance;
	}
}
```

2) Factory Method

- offers an interface for creating an instance of a class, with its subclasses deciding which class to instantiate
- You might want to implement this with the creator class being abstract and not providing an implementation for the Factory method. 
- Or, you could have the Creator class be a concrete class that provides an implementation for the Factory method.

```
public class CardGame {	public static CardGame createCardGame(GameType type) {
		if(type == GameType.Poker){ 
			return new PokerGame();		}else if(type == GameType.BlackJack){
			return new BlackJackGame();
		}
		return null;
	}
}
```


### Practice
[OO Design](https://github.com/Yiyun-Liang/Algorithms/tree/master/src/com/isa/Interviews/OODesign)

- make general types that will be inherited abstract (eg. card, employee)