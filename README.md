# Graphic constructor
Java GUI application for creating graphical structures using simple geometric elements such as: 
line, circle, oval, rectangle, text and pictures.
With the ability to manipulate and change their properties.

## Interface 
![interface](readme.images/20211228_211107.gif)

# Main functionality
> #### Creating
> + All you need to add a new element to the scene is to select the tool in the left panel 
and start dragging the left mouse button from the top left point to the bottom right.

> #### Modifying
> + To modify the created element, double-click on its center, after which the main points 
of manipulation will be highlighted with white squares.

> #### Removing
> + To remove an element, double-click on its center with the right mouse button.

> #### Coping
> + To copy the selected element, click once with the central mouse button on its center.

> #### Output
> + To save the created image, highlight the area of the scene you are interested 
in using the tool with the camera icon.

# Implementation specifics
> ### Configuration
> All configuration constants, except those specific to some modules, can be found in the java/core/Config class.

> ### Architecture
> There are 4 main modules:
> ##### Session
> A session is created once and is a nodal point through which any part of 
> the system gets access to all characteristics and basic models of the session.
> ##### Service 
> The service contains interfaces and their implementations that 
> are responsible for all dynamic events in the scene.
> #### Controller
> Controllers contain implementations of functional interfaces that are called when 
> event listeners recognises needed event. 
> #### GUI:
> The Gui package contains the inheritors of objects of the standard Java libraries SWING and AWP.
> And methods for filling the window with elements.

# Used technologies
+ Java 11 
+ AWT/SWING standard graphic libraries
+ Logging library Log4j2
+ Unit testing library junit 4
+ Maven

# Set up instruction
- To start this application, you just need to download the repository to your local machine and run App.java class.