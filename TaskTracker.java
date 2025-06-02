import java.util.*;


class Task {
    private int id;
    private String description;
    private String status;


    public Task(int id, String description){
        this.id = id;
        this.description = description;
        this.status = "todo";
    }


    //Getters
    public int getId(){return id;}
    public String getDescription() {return description;}
    public String getStatus() {return status;}

    //Setters
    public void setDescription(String description){this.description = description;}
    public void setStatus(String status){this.status = status;}


    //For easy printing
    @Override
    public String toString(){
        return "ID: " + id + " | " + status.toUpperCase() + " | " + description;
    }
}





public class TaskTracker {

    private static List<Task> tasks = new ArrayList<Task>();
    private static int nextId = 1;
    public static void main(String args[]){

        if(args.length==0){
            printUsage();
            return;
        }
        

        String command = args[0].toLowerCase();

        switch(command){
            case "add":
                if (args.length<2){
                    System.err.println("Error: Task description is required for 'add' command");
                }else{
                    System.out.println("Adding task: "+ args[1]);
                    addTask(args[1]);
                }
                break;

            case "list":
                listTasks();
                break;

            default:
                System.err.println(command);
                printUsage();
        }

    }

    public static void printUsage(){
        System.out.println("Task Tracker CLI Usage");
        System.out.println(" java TaskTracker add \"<description>\"       - Add a new task");
        System.out.println(" java TaskTracker list                        - List all tasks");
        System.out.println(" java Tracker update <id>\"<desc>\"           - Update a task");
        System.out.println(" java TaskTracker delete <id>                 - Delete a task");
    }

    public static void addTask(String description){
        Task newTask = new Task(nextId, description);
        tasks.add(newTask);
        System.out.println("Tasks added successfully (ID: " + nextId + ")");
        nextId++;
    }

    private static void listTasks(){
        if(tasks.isEmpty()){
            System.out.println("No tasks found");
            return;
        }

        System.out.println("Your tasks: ");
        for(Task task:tasks){
            System.out.println(task);
        }
    }



}