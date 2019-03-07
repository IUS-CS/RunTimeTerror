## Jumpman Plumber – Design Patterns
	
### Current Design Pattern

Jumpman Plumber currently uses one of the twenty-three most common design patterns in the “Gang of Four” book. This pattern is called the Observer pattern and is a software design pattern in which an object, called the subject, maintains a lists of dependents, called observers, and notifies them automatically of any state changes, usually by calling one of their methods. This is a beneficial pattern to use in our project because the subject maintains a list of observers and notifies them when a state changes by calling their update() operation. 

When designing a game, it is important to use a pattern such as this one so that a piece of code can announce that something has happened without actually caring who receives the notification. In essence, with the Observer pattern, you are able to add observers and remove them independently at run-time without the subject ever knowing. To conclude, it is important to note that the Observer pattern makes sure that the subject and observer are loosely coupled and have no explicit knowledge of each other.

### Suitable Patterns for our Design

A couple other suitable design patterns that we could use in our project are the Factory and Mediator patterns. The Factory pattern is used to build patterns behind the scenes without delivering any of the implementation to the user. An example of this would be the user clicking the left/right arrow keys on the keyboard without knowing that this triggers the section of code that involves the left/right sprites for the player to move. 

In addition, the Mediator pattern would be useful to our project because it defines an object that encapsulates how a set of objects interact. It also promotes loose coupling by keeping objects from referring to each other explicitly, and it lets you vary their interaction independently. This would be a good pattern to use in our project as the player interacts with obstacles.

### Plans for Future Design

The main goal of our current module development is to have a workable release in the next few weeks.  We want to have the bulk of our game presentable and add optimizations after every working update.  The modules we have will be split into the implementation of the controller, the user interface, and the game development. To add, our modules will build upon each other by having an increase in complexity. They will also continue to use design patterns that are beneficial to the project and its final creation.
