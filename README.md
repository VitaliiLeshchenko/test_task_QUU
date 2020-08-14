# test_task_QUU
An analytical tool to evaluate the reply waiting time from customer support.
This is the solution to test task which I got from QUU

Patterns used:
- SOLID
- Singleton
- Builder
- Inversion of control
- Dependency injection
- Command
- Strategy

Technologies used:
- java 8
- junit

I tried to write flexibility code.
To implement Inversion of Control principle, I made simple IoC Container.
Every class in this project do only one job, and can be easy changed.  

**For example:** now program work with terminal, but if you want to read data from file, 
you need to change program only in one place in IoCContainer constructor.  
*__inputReaderService__ = new InputReaderServiceTerminal();*  
->  
*__inputReaderService__ = new InputReaderServiceFile("src/main/resources/testInput.txt");*  

If company will provide new Services/Variations/Question/Category/Sub-category,  
it will be easy to implement, by rewriting only one regex - which validate input data.  
That regex you can find at utils.Constant.class

One of weak places in this program - it's a storage.  
Because all records stored in List<TimeLine>.  
100 000 records not too much, but if input data will be bigger, we will have bad performance.  
Another is a CommandValidationException.  
If you will write wrong command, you will have an exception and program will crash.

### To run the application:
1. Download the project
2. Run Main.main();
