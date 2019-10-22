import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dolphin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dolphin extends Actor
{
    private final int GRAVITY = 1;
    private int velocity;
    /**
     * Act - do whatever the Dolphin wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Dolphin()
    {
        velocity = 4;
    }
    public void act() 
    {
        fall();
        if(Greenfoot.isKeyDown("space") && getY() > getWorld().getHeight() -70)
        {
            jump();
        }
        move();
    }    
    
    public void fall()
    {
        setLocation(getX(), getY() + velocity);
        if (isOnSolidGround()) 
        {
            velocity =0;
            while(isOnSolidGround())
            {
                setLocation(getX(),getY() -1);
            }
            setLocation(getX(), getY() + 1);
        }
        else if(velocity < 0 && didBumpHead())
        {
            velocity = 0;
        }
        else velocity += GRAVITY;
    }
    
    public void jump()
    {
        velocity = -20;
    }
    
    public void move()
    {
        int x = super.getX();
        int y = super.getY();
        if(Greenfoot.isKeyDown("left"))
        {
            x--;
        }
        else if(Greenfoot.isKeyDown("right"))
        {
            x++;
        }
        this.setLocation(x, y);
    }
    
    public boolean isOnSolidGround()
    {
        boolean isOnGround = false;
        if(getY() > getWorld().getHeight()-70)
        {
            isOnGround = true;
        }
        int imageWidth = getImage().getWidth();
        int imageHeight = getImage().getHeight();
        if(getOneObjectAtOffset(imageWidth / -2, imageHeight / 2, Brick.class)!= null 
        || getOneObjectAtOffset(imageWidth / 2, imageHeight / 2, Brick.class) != null)
        {
            isOnGround = true;
        }
        return isOnGround;
    }
    
    public boolean didBumpHead()
    {
        boolean bumpedHead = false;
        int imageWidth = getImage().getWidth();
        int imageHeight = getImage().getHeight();
        if(getOneObjectAtOffset(imageWidth / -2, imageHeight / -2, Brick.class)!= null 
        || getOneObjectAtOffset(imageWidth / 2, imageHeight / -2, Brick.class) != null)
        {
            bumpedHead= true;
        }
        return bumpedHead;
    }
}