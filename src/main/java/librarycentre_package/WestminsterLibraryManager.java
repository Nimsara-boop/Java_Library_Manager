/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarycentre_package;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;


public class WestminsterLibraryManager implements LibraryManager {
    
    // ArrayLists
    public ArrayList<Item> itemList;
    public int item_limit;
    
    public WestminsterLibraryManager(int maxItemNumber){
        itemList = new ArrayList<Item>();
        item_limit = maxItemNumber;
    }

    @Override
    public boolean runMenu() {
         boolean exit = false; // Exit flag
        
        // Run console menu
        System.out.println("\n-- WESTMINSTER LIBRARY MANAGER CONSOLE MENU--");
        
        System.out.println("To save and exit, press 0");
        
        System.out.println("To Add a new item, press 1");
        
        System.out.println("To Display the list of item press 2");

        System.out.println("To change the title of an item press 3");

        System.out.println("To sort items by publication year, press 4");

        System.out.println("To Open GUI, press 5");
        
        

        
        // Switch based on selected option
        Scanner s = new Scanner(System.in);
        int choice;
        choice = s.nextInt();

        
        switch(choice){
            
             // Exit
            case 0:
                exit = true;
                break;
            
            // Add staff member
            case 1:
                this.addItem();
                break;
            // Print staff members
            case 2:
                this.displayItems();
                break;

            //edit title of an item
            case 3:
                this.editTitleItem();
                break;

            case 4:
                this.publicationYearOrder();
                break;

            // GUI
            case 5:
                this.runGUI();
                break;
           
        }
        
        return exit;
    }

    @Override
    public void addItem() {
        Scanner s = new Scanner (System.in);
        
        if(itemList.size() < item_limit){
            System.out.println("Press 1 if you want to add a Book");
            System.out.println("Press 2 if you want to add a DVD");
            
            int choiceItem = s.nextInt();
            s.nextLine();
            
            //common questions
            System.out.println("Enter the Title");
            String title = s.nextLine();
            
            System.out.println("Enter the ISBN");
            String isbn = s.nextLine();
            
            System.out.println("Enter the publication year ");
            int year = s.nextInt();
            s.nextLine();
            
            // check if the item is a book or a dvd
            switch(choiceItem){
                case 1:
                    // it is a book
                    System.out.println("Enter the author's name");
                    String author = s.nextLine();
                    
                    // create a new book and add to the list
                    Book book = new Book(title, isbn);
                    book.setAuthor(author);
                    book.setPublicationYear(year);
                   
                    this.addItemToList(book);
                    
                    break;
                    
                case 2:
                    //it is a dvd
                    System.out.println("Enter the genre");
                    String genre = s.nextLine();

                    System.out.println("Enter the director's name");
                    String director = s.nextLine();
                    
                    // create a new receptionist and add to the list
                    DVD dvd = new DVD(title, isbn);
                    dvd.setGenre(genre);
                    dvd.setDirector(director);
                    dvd.setPublicationYear(year);
                    
                    this.addItemToList(dvd);
                    break;
            }
            
        }
        else {
            System.out.println("No more space in the system");
        }
    }
    
    public void addItemToList(Item item){
        
        //check if there are space avilable
        if(this.itemList.size() < item_limit) {
            itemList.add(item);
        }
        else{
            System.out.println("No more space in the list");
        }
    }

    @Override
    public void displayItems() {

        if (!itemList.isEmpty()){
            for(Item item : itemList) {
                // print the type of item and the description
                if(item instanceof Book)
                    System.out.print("BOOK - ");
                else if (item instanceof DVD)
                    System.out.print("DVD - ");
                //add here teh code if you added teh class Megazine
                
                System.out.println(item.toString());
            }
        }
        else{
            System.out.println("There are no items in the system.");
        }
    }

    @Override
    public void runGUI() {
        ItemTableGUI table = new ItemTableGUI(itemList);
        table.setVisible(true);
    }
    @Override
    public void editTitleItem(){
        Scanner input = new Scanner(System.in);
        if (!itemList.isEmpty()) {
            System.out.println("What is the ISBN of the item to be edited");
            String isbn = input.next();
            boolean foundItem = false;
            for (Item item : itemList) {
                    if (isbn.equals(item.getISBN())) {
                        System.out.println("The ISBN number " + isbn + " is of " + item.getTitle() + " and the publication year is " + item.getPublicationYear());
                        System.out.println("The type of item is " + item.getClass().getSimpleName());
                        System.out.println("What is the new title? ");
                        input.nextLine(); //this is important to consume leftover new line.
                        String newTitle = input.nextLine();
                        item.setTitle(newTitle);
                        System.out.println("The new name of ISBN number "+isbn+" is "+item.getTitle());
                        foundItem = true;
                    }
                }
            if (foundItem ==false){
                System.out.println("no such item here");
                return;

            }            }
        else{
            System.out.println("No items added yet to change titles.");
            return;
        }


        }

        public void publicationYearOrder(){
        Collections.sort(itemList);
        System.out.println(itemList.toString());
        }


    }
    

