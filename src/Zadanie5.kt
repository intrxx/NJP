class TaskManager()
{
    companion object
    {
        fun addTask(taskName: String, taskDesc: String, taskDeadline: String): Task
        {
            return Task(taskName, taskDesc, taskDeadline);
        }
        
        fun cloneTask(taskToClone: Task): Task
        {
            return taskToClone.clone();
        }

        fun modifyTask(taskToModify: Task, newTaskValue: Any?, propertyToModify: String): Task
        {
            when (propertyToModify)
            {
                "0" -> taskToModify.taskName = newTaskValue.toString();
                "1" -> taskToModify.taskDesc = newTaskValue.toString();
                "2" -> taskToModify.taskDeadline = newTaskValue.toString();
                else -> null;
            }
            return taskToModify;
        }
    }
}

class Task(var taskName: String, var taskDesc: String, var taskDeadline: String): Cloneable 
{
    var Name = taskName;
    var Desc = taskDesc;
    var Deadline = taskDeadline;
    
    public override fun clone(): Task 
    {
        return super.clone() as Task;
    }
}

fun addTask() : Task
{
    var taskName: String = "";
    var taskDesc: String = "";
    var taskDeadline: String = "";
    
    println("Specify Task Name, Description and Deadline");
    taskName = readln();
    taskDesc = readln();
    taskDeadline = readln();
    return TaskManager.addTask(taskName, taskDesc, taskDeadline);
}

fun tryToClone(taskToClone: Task?) : Task?
{
    if(taskToClone == null)
    {
        println("Task can't be null");
        return null;
    }
    
    return TaskManager.cloneTask(taskToClone);
}

fun modifyTask(taskToModify: Task?): Task
{
    var propertyToModify: String = "-1";
    var newTaskValue: Any? = null;
    
    println("Specify what task property to modify ([0] - Task Name, [1] - Task Desc [2] - Task Deadline) and the new value");
    
    propertyToModify = readln();
    newTaskValue = readln();

    if (taskToModify != null) {
        return TaskManager.modifyTask(taskToModify, newTaskValue, propertyToModify)
    };
    
    return Task("", "", "");
}

fun printTask(taskToPrint: Task?)
{
    println("Task Name: " + taskToPrint?.taskName + " Description: " + taskToPrint?.taskDesc + " Deadline: " + taskToPrint?.taskDeadline);
}

fun zadanie5()
{
    println("\n Zadanie 5");
    
    var option: String? = "";
    var currentTask: Task? = null;
    
    while(option != "0") 
    {
        println("0 - Quit")
        println("1 - Add task")
        println("2 - Clone task");
        println("3 - Modify task");
        println("4 - Print task");
        
        option = readlnOrNull();
        when(option)
        {
            "1" -> currentTask = addTask();
            "2" -> tryToClone(currentTask);
            "3" -> currentTask = modifyTask(currentTask);
            "4" -> printTask(currentTask);
            else -> null;
        }
    } 
}