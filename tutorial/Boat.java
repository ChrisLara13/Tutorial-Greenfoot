import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Boat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boat extends Actor
{
    /**
     * Act - do whatever the Boat wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        move();
    }
    
    public void move()
    {
        int x = super.getX();
        int y = super.getY();
        if(Greenfoot.isKeyDown("w"))
        {
            y--;
        }
        else if(Greenfoot.isKeyDown("s"))
        {
            y++;
        }
        else if(Greenfoot.isKeyDown("a"))
        {
            x--;
        }
        else if(Greenfoot.isKeyDown("d"))
        {
            x++;
        }
        this.setLocation(x, y);
    }
}
