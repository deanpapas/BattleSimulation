
Decision Making Processes
-------------------------
When forming the Hero class i chose to structure it after the Ogre class. I first established the key variables that i would be using and formed the class constructor.
I then formed the super class Item and the 3 subclasses Sword,Armour and Potion.

I structured these classes similairy to the relationship between Entity and Ogre/Hero. Each subclass holding the method that would implement the corresponding boost.
I then went back to the hero class and implemented the Item class. Meaning that everytime a Hero was created a Sword,Armour and Potion would be created and placed into
an item array within Hero to refernced later on.I placed the reference to items in the hero class as that is where the attack AI and therefore where the Boosts are implemented.

I did however attach the armour boost to the string out of Hero in order to account for whenever a hero is attacked rather then when they themselves attack.


Issues & Bugs
-------------
-Possible issues may arise if the user wants to run a simulation without any items. There currently isnt any option to add/remove items from the heroes.
-Similiar to the items, heroes cannot be removed through the interface after being added.


