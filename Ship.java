import java.util.ArrayList;
import java.util.List;

public abstract class Ship
{
    private int length;
    private List<Location> locations;
    private List<Location> hitsTaken;

    public Ship(int length)
    {
        this.length = length;
        locations = new ArrayList<Location>();
        hitsTaken = new ArrayList<Location>();
    }

    public void addLocation(Location... loc)
    {
        for (int len = 0; len < loc.length; len++)
        {
            locations.add(loc[len]);
        }
    }

    public List<Location> getLocations()
    {
        return locations;
    }

    /**
     * Add Location loc to hitsTaken.
     *
     * @param loc Inputs loc of Location class to check if the ship has taken hit.
     */
    public void takeHit(Location loc)
    {
        hitsTaken.add(loc);
    }

    /**
     * Returns true if the number of hits taken is
     *   equal to the length of this ship.
     *
     * @return Returns the boolean value after checking if the ship is sunk.
     */
    public boolean isSunk()
    {
        if (hitsTaken.size() == length)
            return true;
        else
            return false;
    }
}
