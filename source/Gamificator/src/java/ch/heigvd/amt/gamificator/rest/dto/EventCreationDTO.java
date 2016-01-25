/*
 *
 * @author Bastien Rouiller
 */

package ch.heigvd.amt.gamificator.rest.dto;

public class EventCreationDTO 
{
    private String name;
    private String description;
    private long score;

    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    public String getDescription()
    {
        return description;
    }
    
    public void setDescription(String description)
    {
        this.description = description;
    }

    public long getScore()
    {
        return score;
    }

    public void setScore(long score)
    {
        this.score = score;
    }
        
}