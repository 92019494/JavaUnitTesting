# JavaTesting
This was a project done while studying. 

Specific Instructions for the resulting Test Suite
- Fix any errors which are preventing the code from running. 
- Run the existing test suite, which contains tests for the Coordinates, Address, Depot, Product and Customer classes.
- Fix any bugs detected by these tests.
- Create more tests, for the Manifest, Box and Packer classes. When creating these tests, refer to the scenario,
  which describes several program requirements.
- Add all tests to the TestSuite.


*** INSTRUCTIONS ***

Scenario
A company operates several depots, which pack products into boxes and dispatches them to customers using trucks. The depots
use a program to assist with packing and labelling the boxes. The program reads incoming orders from text files, works out
how the products can be boxed, and generates labels for the boxes. Each depot runs its own instance of the program. You have
been provided with code for the back end of the program. There is not yet any GUI, and no system for receiving input data 
from files or a database. Once the backend has been tested, these parts will be developed. The Example.java file shows example
usage of the system.

Business Rules
How the program works is largely defined by the business rules of the company, in particular:

Boxes: 
- The warehouse uses standard boxes, which have a capacity of 20kg.
- Boxes shouldn’t be filled over their capacity.In future, the capacity of a standard box may change.
- The program is expected to be reasonably efficient at filling boxes to capacity.

Warnings:
- Any box containing a fragile item must have “FRAGILE” in the label
- Any box containing a hazardous item must have “HAZARD” in the label
- Any box weighing more than 15kg must have “HEAVY” in the label
- Boxes which do not meet the criteria for the above warnings, must not be incorrectly labelled with a warning.

Addressing:
- Customer addresses have GPS coordinates associate with them. The Depot also has coordinates. For the purposes of this
  assignment these coordinates are measured in kilometres, and are located on a flat plane.
- The box label should contain the customers address.
- Some customers have multiple addresses. 
  In this case the box should be dispatched to the closest address, based on the GPS
  coordinates. The company uses a proprietary distance metric, described as follows: 
  “Take the average of the Euclidean Distance to the customer and the Manhattan Distance to the customer. Add 1km to the result.” 
