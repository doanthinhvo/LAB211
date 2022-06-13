/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
/**
 *
 * @author doant
 */
public class TaskManager {
          
          Validation validate = new Validation();
          
          public void displayMenu(){
                    System.out.println("=====Task Program=====");
                    System.out.println("Add Task.");
                    System.out.println("Delete Task.");
                    System.out.println("Display Task.");
                    System.out.println("exit.");
          } 
          
          public int addTask(ArrayList<Task>  listTalks, int id){
                    System.out.println("--------Add Task--------");
                    String requirementName = Validation.getString("Requirement Name: ", "", "");
                    String taskType = Validation.GetTaskType("Task Type: ");
                    String date = Validation.getDate("Date: ");
                    double planFrom = Validation.getDouble("From: ", "Plan From must be within 8h-17h", 8.0, 17.0);
                    double planTo = Validation.getDouble("To: ", "Plan To must be within From to 17h30", planFrom + 0.5, 17.5);
                    String Assignee = Validation.getString("Assignee: ", "", "");
                    String reviewer = Validation.getString("Reviewer: ", "", "");
                    boolean isExist = checkDuplicate(taskType, date, Assignee, planFrom, planTo, listTalks, reviewer);
                    
//                    if (isExist)
                    if (isExist) System.out.println("Duplicate.");
                    else {
                              listTalks.add(new Task(id, taskType, requirementName, date, planFrom, planTo, Assignee, reviewer));
                              id++;
                              System.out.println("Add Successfull.");
                    }
          }
          
          // check duplicate tasks
          boolean checkDuplicate(String taskType, String date, String assignee, double planFrom, double planTo, ArrayList<Task> TaskList, String reviewer){
                    for (Task task : TaskList){
                              if (taskType.equals(task.getTaskTypeID()) && date.equals(task.getDate()) && assignee.equals(task.getAssignee()) && planFrom == task.getPlanFrom() && planTo == task.getPlanTo() && reviewer.equals(task.getReviewer())){
                                        return true;
                              }
                    }
                    return false;
          }
          
          //
          public int addTask (String RequirementName, String Assignee, String Reviewer, String TaskTypeID, String date, double planFrom, double planTo) throws Exception{
                    
          }
          
          // delete task
          public void deleteTask(ArrayList<Task> listOfTasks){
                    // if empty
                    if (listOfTasks.isEmpty()){
                              System.out.println("There is no tasks in list.");
                              return;
                    }
                    int indexInListOfTasks = -1;
                    // get ID of task want to delete
                    int TaskID = validate.getValidInt("ID of tasks you want to delete: ", "Task ID is out of range.", 1, Integer.MAX_VALUE);
                    
                    // get coresponding ID in listOfTasks
                    for (int i = 0; i < listOfTasks.size();i++){
                              if (TaskID == listOfTasks.get(i).getTaskID()){
                                        indexInListOfTasks = listOfTasks.get(i).getTaskID();
                              }
                    }
                    // check whether indexInlistofTalks is found
                    if (indexInListOfTasks == -1){
                              System.out.println("ID is not exist.");
                    } else {
                              listOfTasks.remove(indexInListOfTasks);
                              System.out.println("Delete Successful.");
                    }
          }
          
          // show task like a table 
          public void getDataTasks(ArrayList<Task> listOfTasks){
                    if (listOfTasks.isEmpty()){
                              System.out.println("list is empty");
                              return;
                    }
                    System.out.println("----------------------------------Task-----------------------------");
                    System.out.format("%-7s%-20s%-12s%-15s%-7s%-15s%-15s\n", "Id", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
                    for (Task task : listOfTasks){
                              System.out.println(task);
                    }
          }
}
