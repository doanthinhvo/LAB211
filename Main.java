
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author doant
 */
public class Main {
          public static void main(String[] args) {
                    TaskManager manage = new TaskManager();
                    ArrayList<Task> taskLists = new ArrayList<>();
                    Validation validation = new Validation();
                    int id = 1;
                    int choice;

                    do {
                    // Display menu
                    manage.displayMenu();
                    // get user choice
                    choice = validation.getValidInt();

                    switch(choice) {
                              // 1. add Task 
                              case 1:
                                        manage.addTask(taskLists, id);
                                        break;
                              // 2. delete Task
                              case 2:
                                        manage.deleteTask();
                                        break;
                              case 3:
                              // 3. show task 
                                        manage.showTask();
                                        break;
                              case 4:
                              // 4. exit the program 
                                        System.exit(0);
                                        break;
                    }
                    } while (true);
          }
}
