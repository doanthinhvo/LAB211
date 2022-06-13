/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author doant
 */
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 */
public class Validation {

          static Scanner sc = new Scanner(System.in);

          static int getValidInt(String message, String outRangeMsg, int min, int max) {
                    String input;
                    int result;
                    do {
                              System.out.print(message);
                              input = sc.nextLine().trim();
                              if (input.isEmpty()) {
                                        System.out.println("Input could not be empty!!!");
                              } else {
                                        try {
                                                  result = Integer.parseInt(input);
                                                  //check choice in range min and max
                                                  if (result >= min && result <= max) {
                                                            break;
                                                  } else {
                                                            System.out.println(outRangeMsg);
                                                            continue;
                                                  }
                                        } catch (NumberFormatException ex) {
                                                  System.out.println("Input must be integer");
                                        }
                              }
                    } while (true);
                    return result;
          }

          static String getString(String msg, String formatMsg, String regex) {
                    String input;
                    do {
                              System.out.print(msg);
                              input = sc.nextLine().trim();
                              if (input.isEmpty()) {
                                        System.out.println("Input could not be empty!!!");
                                        continue;
                              } else {
                                        if (regex.isEmpty()) {
                                                  break;
                                                  //compare input with regex
                                        } else if (input.matches(regex)) {
                                                  break;
                                        } else {
                                                  System.out.println(formatMsg);
                                                  continue;
                                        }
                              }
                    } while (true);
                    return input;
          }

          String getDate(String message){
                    String input;
                    Date date;
                    String resultDate;
                    
                    do {
                              // out message
                              System.out.println(message);
                              
                              // set simple date format 
                              SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                              dateFormat.setLenient(false);
                              // input string 
                              input = sc.nextLine().trim();
                              // if input is empty
                              if (input.isEmpty()){
                                        System.out.println("input could not be empty.");
                                        continue;
                              }
                              // check input is right format
                              else if (!input.matches("\\d{1,2}[-]\\d{1,2}[-]\\d{4}")){
                                        System.out.println("Input is in wrong fomat");
                                        continue;
                              }
                              // try to parse input to date
                              try{
                                        date = dateFormat.parse(input);
                                        Date now = new Date();
                                        // check date before now 
                                        if (date.before(now)){
                                                  System.out.println("Date could not be in the past. Please enter again: ");
                                                  continue;
                                        }
                                        break;
                              }
                              catch (ParseException e){
                                        System.out.println("Date doesn't exist");
                              }
                              // catch parseformat exception
                    } while(true);
                    // set result Date
                    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                    resultDate = dateFormat.format(date);
                    
                    // return 
                    return resultDate;
          }

          static String GetTaskType(String msg) {
                    int tasktypeID = getValidInt(msg, "Task Type must be in range[1-4]", 1, 4);
                    String result = "";
                    switch (tasktypeID) {
                              case 1:
                                        result = "Code";
                                        break;
                              case 2:
                                        result = "Test";
                                        break;
                              case 3:
                                        result = "Design";
                                        break;
                              case 4:
                                        result = "Review";
                                        break;
                    }
                    return result;
          }

          static double getDouble(String msg, String outRangeMsg, double min, double max) {
                    double result;
                    String input;
                    do {
                              //\d: accept input be a digit from 0-9
                              //\.: after digit is a dot
                              //([5]|[0])): after a dot just accpet digit 5 or 0
                              input = getString(msg, "Input just accept x.0 or x.5 number", "^(\\d+\\.([5]|[0]))$");
                              if (input.isEmpty()) {
                                        System.out.println("Input could not be empty!");
                              } else {
                                        try {
                                                  result = Double.parseDouble(input);
                                                  //check choice in range min and max
                                                  if (result >= min && result <= max) {
                                                            break;
                                                  } else {
                                                            System.out.println(outRangeMsg);
                                                            continue;
                                                  }
                                        } catch (NumberFormatException ex) {
                                                  System.out.println("Input could be a real number!");
                                        }
                              }
                    } while (true);
                    return result;
          }
}
