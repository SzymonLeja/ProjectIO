package main.App;

import main.Post.PostInterface;
import main.Post.PostList;

import java.util.Scanner;


public class App {
    private static PostInterface postList = new PostList();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the system!");
        System.out.println("Please enter your role:");
        String user = scanner.nextLine();
        if (user.equals("moderator")) {
            System.out.println(postList);
            moderatorMenu(scanner);
            System.out.println(postList);
        }

    }

    public static void moderatorMenu(Scanner scanner){
        System.out.println("Please choose an option:");
        System.out.println("1. Add a post");
        System.out.println("2. Edit a post");
        System.out.println("3. Show all posts");
        System.out.println("4. Exit");
        String option = scanner.nextLine();
        switch (option) {
            case "1":
                addPostMenu(scanner);
                moderatorMenu(scanner);
                break;
            case "2":
                editPostMenu(scanner);
                moderatorMenu(scanner);
                break;
            case "3":
                System.out.println(postList.toString());
                moderatorMenu(scanner);
                break;
            case "4":
                System.out.println("Thank you for using the system!");
                break;
            default:
                System.out.println("Invalid option!");
                break;
        }
    }
    public static void addPostMenu(Scanner scanner){
        System.out.println("Please give title of the post you want to insert");
        String postTitle = scanner.nextLine();
        System.out.println("Please give description of the post you want to insert");
        String postDescription = scanner.nextLine();
        System.out.println("Please give contact of the post you want to insert");
        String postContact = scanner.nextLine();
        System.out.println("Please give category of the post you want to insert");
        String postCategory = scanner.nextLine();
        postList.addPost(postTitle, postDescription, postContact, postCategory);
        System.out.println("Do you want to add another post? (y/n)");
        String answer = scanner.nextLine();
        if(answer.equals("y")){
            addPostMenu(scanner);
        }
    }
    public static void editPostMenu(Scanner scanner){
        System.out.println("Please choose an option:");
        System.out.println("1. Edit post");
        System.out.println("2. Delete post");
        System.out.println("0. Exit");
        String answer = scanner.nextLine();
        if(answer.equals("1")){
            System.out.println("Please give the id of the post you want to edit");
            Integer postId = scanner.nextInt();
            if(postList.findPost(postId) != null){
                System.out.println("Please give the new title of the post");
                String postTitle = scanner.nextLine();
                System.out.println("Please give the new description of the post");
                String postDescription = scanner.nextLine();
                System.out.println("Please give the new contact of the post");
                String postContact = scanner.nextLine();
                System.out.println("Please give the new category of the post");
                String postCategory = scanner.nextLine();
                postList.editPost(postId, postTitle, postDescription, postContact, postCategory);
            } else {
                System.out.println("There is no post with this id!");
            }
            return;
        }
        if(answer.equals("2")){
            System.out.println("Please give the id of the post you want to delete");
            Integer postId = scanner.nextInt();
           postList.deletePost(postId);
            editPostMenu(scanner);
        }
        if(answer.equals("0")){
            moderatorMenu(scanner);
        }
    }
    public void userMenu(){
        System.out.println("Please choose an option:");
        System.out.println("1. View all posts");
        System.out.println("2. View a post");
        System.out.println("3. Exit");
    }
}
