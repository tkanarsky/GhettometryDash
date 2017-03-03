GhettometryDash - a ghetto clone of Geometry Dash for my AP Computer Science platform game project.
RobTop, plz no sue

Unlike the original Geometry Dash, our version uses a fixed object grid for simplicity and easy level creation.

To make a level:

Make a .png file in GIMP (or similar) 10 pixels high and however long you want.

Use the single pixel pencil to create the level:

 - Pitch black (RGB 0, 0, 0) creates a simple block at that location in the level.
 - Gray (RGB 127, 127, 127) creates a half-height block at that location, filling lower half of the grid cell.
 - Red (RGB 255, 0, 0) creates a spike. Orientation does not matter, the game will draw it appropriately depending on its location      relative to blocks.
 - Green (RGB 0, 255, 0) creates a gravity portal at that location. Gravity portals are two blocks high, they take up the drawn          block and the block above it as well. Keep this in mind.
 - Yellow (RGB 255, 255, 0) creates a yellow jump pad at that location in the level. The yellow jump pad provides an automatic jump      the same height as a regular cube jump.
 - Magenta (RGB 255, 0, 255) creates a pink jump pad at that location in the level. They snap to either top or bottom depending on      proximity to blocks. The pink jump pad is weaker than the similar yellow jump pad.
 - Cyan (RGB 0, 255, 255) creates a blue jump pad. This pad flips the gravity and boosts the player in that direction. 
 - Dark yellow (RGB 127, 127, 0) creates a yellow jump ring. Provides a sort of 'double-jump' effect when clicked on in flight.
 - Dark magenta (RGB 127, 0, 127) creates a pink jump ring. Provides a weaker double jump effect than the yellow portal.
 - Dark cyan (RGB 0, 127, 127) creates a blue jump ring at that location on the map. 

