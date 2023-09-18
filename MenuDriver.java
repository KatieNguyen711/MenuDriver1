import java.util.Scanner;
import java.lang.StringBuilder;
import java.util.ArrayList;

/**
 * This will allow user to input any String and move, remove, or add Strings to a list.
 *
 * @author Katie Nguyen
 * @version 1.6
 */
public class MenuDriver
{
    public static void main(String[] args){
        //answer will be the String that holds user's inputs
        String answer = "";
        //I originally used output to display any outputs, but I never needed it
        //String output = "";
        //copyHolder will hold a copy of a String that needs to be moved to a different index
        String copyHolder = "";
        //position will keep track of the current position (used for printing text)
        int position = 0;
        //this position will be used for methods
        int actPosition=0;
        //text will ask user for prompt. prompt will be filled into answer
        Scanner text = new Scanner(System.in);
        //list will hold the strings
        ArrayList<String> list = new ArrayList<String>();
        
        /*
         * I didnt seem to need these anymore
         * AllOptions options = new AllOptions();
         * StringBuilder stringChanger = new StringBuilder();
         */
        
        //Welcome message and list of options printed first
        System.out.println("909469912");
        System.out.println("Welcome to the Menu Driver for a bare bones list!");
        System.out.println("");
        System.out.println("Command options: ");
        System.out.println("I string_to_insert  (insert a string at the current position)");
        System.out.println("A string_to_append  (append a string at the end)");
        System.out.println("R  (remove the string at the current position)");
        System.out.println("S  (move the current position to the start)");
        System.out.println("E  (move the current position to the end)");
        System.out.println("P  (move the current position backward)");
        System.out.println("F  (move the current position forward)");
        System.out.println("L  (display the length of the list)");
        System.out.println("C  (display the current position number)");
        System.out.println("M number  (move the current position to specific position)");
        System.out.println("D  (display the string at the current position)");
        //System.out.println("K  (displays the entire list)");
        System.out.println("O  (display these options)");
        System.out.println("Q  (quit)");
        System.out.println("");
        //While the answer is not Q, the loop will continue
        while(!(answer.equals("Q"))){
            if (actPosition>list.size()-1){
                actPosition = list.size()-1;
            }else if (actPosition<0){
                actPosition = 0;
            }else if (actPosition == list.size()){
                actPosition = list.size();
            }
            
            System.out.println("Please enter a command (or 'O' for all of the options): ");
            //ask user for input
            answer = text.nextLine();
            //If user's answer does not involve any additional text (like I, A, and M), this if statement will check if the input is valid
            if (answer.length()==1){
                //if input is R, code will remove the String in the list
                //if the current position is greater than the size of the list, the last index will be removed
                if (answer.equals("R")){
                    System.out.println("Removing the string at the current position ...");
                    /*
                    if(position<=list.size()-1){
                        list.remove(position);
                    }else{
                        list.remove(list.size()-1);
                    }*/
                    
                    //makes sure that there is something in the list
                    if(list.size()!=0){
                        list.remove(list.remove(actPosition));
                    }
                }//if input is S, the String in the current position will be copied, removed, then added to the start of the list
                //if position is greater than size, the last index will be used
                else if(answer.equals("S")){
                    System.out.println("Moving the current position to the start ...");
                    /*if(position<=list.size()-1){
                        copyHolder = list.get(position);
                        list.remove(position);
                        list.add(0, copyHolder);
                    }else{
                        copyHolder = list.get(list.size()-1);
                        list.remove(list.size()-1);
                        list.add(0, copyHolder);
                    }*/
                    
                    //makes sure that there is something in the list
                    if(list.size()!=0){
                       copyHolder = list.get(actPosition);
                        list.remove(actPosition);
                        list.add(0, copyHolder); 
                    }
                }// if input is E, the String in the current position will be copied, removed, then added to the end of the list
                //if position is greater than size, the last index will be used
                else if (answer.equals("E")){
                    System.out.println("Moving the current position to the end ...");
                    /*if(position<=list.size()-1){
                        copyHolder = list.get(position);
                        list.remove(position);
                        list.add(copyHolder);
                    }else{
                        copyHolder = list.get(list.size()-1);
                        list.remove(list.size()-1);
                        list.add(copyHolder);
                    }*/
                    //makes sure that there is something in the list
                    if(list.size()!=0){
                        copyHolder = list.get(actPosition);
                        list.remove(actPosition);
                        list.add(copyHolder);
                    }
                }//if P, String will be copied, removed, and then added to the position before it
                //if position is greater than size, the last index will be used
                else if (answer.equals("P")){
                    System.out.println("Moving the current position backward ...");
                    //we have to make sure that the current position can even move
                    if(list.size()>=2){
                        /*
                        if(position<=list.size()-1){
                            copyHolder = list.get(position);
                            list.remove(position);
                            list.add(position-1, copyHolder);
                        }else{
                            copyHolder = list.get(list.size()-1);
                            list.remove(list.size()-1);
                            if (list.size()==1){
                                list.add(list.size()-1, copyHolder);
                            }else{
                                list.add((list.size()-1)-1, copyHolder);
                            }*/
                        copyHolder = list.get(actPosition);
                        list.remove(actPosition);
                        list.add(actPosition-1, copyHolder);
                    }
                    
                }//if F, String will be copied, removed, and then added to the position after it
                else if (answer.equals("F")){
                    System.out.println("Moving the current position forward ...");
                    //we have to make sure that the current position can even move
                    if (list.size()>=2){
                        /*
                        if(position<=list.size()-1){
                            copyHolder = list.get(position);
                            list.remove(position);
                            list.add(position+1, copyHolder);
                        }else{
                            copyHolder = list.get(list.size()-1);
                            list.remove(list.size()-1);
                            list.add((list.size()-1)+1, copyHolder);
                        }*/
                        copyHolder = list.get(actPosition);
                        list.remove(actPosition);
                        list.add(actPosition+1, copyHolder);
                    }
                }//if L, the size of the list will print
                else if (answer.equals("L")){
                    //L works!
                    System.out.println("Displaying the length of the list ...");
                    System.out.println(list.size());
                }//if C, the int in the variable position will print
                else if (answer.equals("C")){
                    //C works!
                    System.out.println("Displaying the current position number ...");
                    System.out.println(position);
                }//if D, the string at the current position will print
                else if (answer.equals("D")){
                    //D works!
                    System.out.println("Displaying the string at the current position  ...");
                    /*
                     * Using arrays were better than only using strings 
                     *System.out.println(stringChanger.toString());
                     */
                    //makes sure that there is something in the list
                    if(list.size()!=0){
                        System.out.println(list.get(actPosition));
                    }else{
                        System.out.println("");
                    }
                }//prints all options
                else if (answer.equals("O")){
                    //O works!
                    System.out.println("Command options: ");
                    System.out.println("I string_to_insert  (insert a string at the current position)");
                    System.out.println("A string_to_append  (append a string at the end)");
                    System.out.println("R  (remove the string at the current position)");
                    System.out.println("S  (move the current position to the start)");
                    System.out.println("E  (move the current position to the end)");
                    System.out.println("P  (move the current position backward)");
                    System.out.println("F  (move the current position forward)");
                    System.out.println("L  (display the length of the list)");
                    System.out.println("C  (display the current position number)");
                    System.out.println("M number  (move the current position to specific position)");
                    System.out.println("D  (display the string at the current position)");
                    System.out.println("K  (displays the entire list)");
                    System.out.println("O  (display these options)");
                    System.out.println("Q  (quit)");
                    System.out.println("");
                }//if answer is Q, an empty String will print and loop will end
                else if (answer.equals("Q")){
                    //Q works!
                    System.out.println("");
                }/*
                //K is for personal tests; this will display the entire list
                else if (answer.equals("K")){
                    System.out.println("Displaying list...");
                    System.out.println(list);
                }*/// if input's length is 1 but it does not match any of the options, this will print
                else{
                    System.out.println(answer + " is not a valid command!");
                }
            }//if the input includes an additional part, this will occur
            else{
                // if A, the input will be added to the end of the list
                if (answer.indexOf("A")==0){
                    //A works! 
                    
                    System.out.println("Appending '" + answer.substring(2) + "' ...");
                    /*
                     * originally used if I only used strings, but using arraylist seems simpler
                     * stringChanger.append(answer.substring(2));
                     */
                    
                    //must do substring(2) because "A substring" will be added to list
                    list.add(answer.substring(2));
                }// if I, the input will be added to whatever the current position is
                else if (answer.indexOf("I")==0){
                    //I works!
                    System.out.println("Inserting '" + answer.substring(2)+ "' ...");
                    /*
                     * Using different classes also seemed more complicated
                     * output= options.methodI(output,answer, position);
                     */
                    //if size ==0, then an error occurs
                    if(list.size()==0){
                        list.add(answer.substring(2));
                    }else{
                        list.add(actPosition, answer.substring(2));
                    }
                }// if M, it will convert the input to an int and then change position to the new int
                else if (answer.indexOf("M")==0){
                    //M works!
                    actPosition = Integer.parseInt(answer.substring(2));
                    position = actPosition;
                    System.out.println("Moving current position to " + position +" ...");
                    if (position>list.size()-1){
                        actPosition = list.size()-1;
                    }else if (position<0){
                        actPosition = 0;
                    }
                }// if input is invalid, this will execute
                else {
                    System.out.println(answer + " is not a valid command!");
                }
            }
            System.out.println("");
        }
        //once Q is entered, the goodbye message will appear
        System.out.println("Good-bye");
    }
}
