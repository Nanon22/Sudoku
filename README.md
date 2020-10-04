# Sudoku
Android Sudoku application

This application is a simple sudoku game made with pure java.

Currently the play logic is to :

  **-choose a difficulty level in the home view.**
  
  **-then try to solve the generated sudoku problem.**
  
  **-in case of win you will have a screen telling you congratulation, otherwise you still not have the correct sudoku grid and must continue trying to solve the problem.**
  
  **-if a problem is too hard and you do not happen to find the solution, you can give up and start a new game by clicking on the "new grid" button.**
  
Current game limits are:

  **-the game does not warn you in the event of an error. So you have to solve the problem in one shot or find your mistake(s) by yourself if you have completed
  the grid but don't see the "you win" screen.**
  
  **-a statistics module to show data like numbers of wins, of mistakes per game, of give up and so on should be included but is not for the moment.**
  
  
FOR THOSE INTERESTED BY THE CODE :

--IMPORTANTS RESOURCES

  -Sudoku/app/src/main/res/drawable/ : contains all the images and background .xml file use to style the app

  -Sudoku/app/src/main/res/raw/ : contains the differents game sounds
  
  -Sudoku/app/src/main/res/layout/: contains the differents screens of the app, the fragments and the customs ui design
  
  -Sudoku/app/src/main/res/values/ : contains defaults values such as colors, strings...
  
--IMPORTANTS JAVA CODE :

  -Sudoku/app/src/main/java/fr/nanon/universjavamobile/sudoku/ :
  
    MainActivity : main layout activity
    GameActivity : game layout activity

  -Sudoku/app/src/main/java/fr/nanon/universjavamobile/sudoku/customui/ : contains the customs ui class
  
    Box : Java class used to identify a box of the sudoku grid
    Region : Java class used to identify a row of the suduku grid
    
   -Sudoku/app/src/main/java/fr/nanon/universjavamobile/sudoku/sudoku/ : contains the sudoku game class
   
    Sudoku : Java class creating an instance of a sudoku game and his solution
    
   -Sudoku/app/src/main/java/fr/nanon/universjavamobile/sudoku/ui/main/ : contains ui behavior and fragments logic
   
    PlaceholderFragment : Java class for the home fragment
    
   -Sudoku/app/src/main/java/fr/nanon/universjavamobile/sudoku/views/ : contains code for views adapter
   
    SudokuRecyclerViewAdapter : Java adapter class to generate the soduku grid view
  
