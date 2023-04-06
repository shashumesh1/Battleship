import java.util.ArrayList;
import java.util.List;

public abstract class Player
{
    private String name;
    private List<Ship> ships;
    private int[][] guessBoard;

    public Player(String name)
    {
        this.name = name;
        ships = new ArrayList<Ship>();
        guessBoard = new int[10][10];
        populateShips();
    }

    public String getName()
    {
        return name;
    }

    /**
     * Returns how many ships are currently in this
     *   Player's ships List.
     *
     * @return  Returns integer type that denotes how many ships the current player has
     */
    public int getNumberOfShips()
    {
        return ships.size();
    }

    /**
     * Returns the ship that occupies the specified
     *   Location loc.  Returns null if this Player
     *   does not control a ship at Location loc.
     *
     * @param loc Takes in the specified loc of Location class of the ship
     * @return Returns the ship that occupies the specified location.
     */
    public Ship getShip(Location loc)
    {
        for (Ship ship : ships)
        {
            for (Location loctn : ship.getLocations())
            {
                if (loctn.getCol() == (loc.getCol()) && loctn.getRow() == loc.getRow())
                {
                    return ship;
                }
            }
        }
        return null;
    }

    public void addShip(Ship ship)
    {
        ships.add(ship);
    }

    public void removeShip(Ship ship)
    {
        ships.remove(ship);
    }

    /**
     * Returns true if this Player controls a ship
     *   at the specified Location loc; false
     *   otherwise.
     *
     * @param loc Inputs the loc of Location class to check if the player controls the ship at this location.
     * @return Returns boolean type of data if the specified player controls a ship at this location
     */
    public boolean hasShipAtLocation(Location loc)
    {
        for(Ship shp : ships)
        {
            for(Location loctn : shp.getLocations())
            {
                if(loctn.equals(loc))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public int[][] getGuessBoard()
    {
        return guessBoard;
    }

    /**
     * Returns true if obj is an instanceof Player and
     *   instance variables are equivalent.
     *
     * @param obj Inputs obj of the Object data type to check if its an instance of Player and if the
     *            instance variables are equal.
     * @return Returns boolean data type if obj is an instanceof Player instance variables are equal.
     */
    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof Player)
        {
            Player plyr = (Player) obj;
            if(plyr.name == name && plyr.ships == ships && plyr.guessBoard == guessBoard)
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Attack the specified Player at the specified Location.
     *
     * Return true if the attack resulted in a ship sinking;
     *   false otherwise.
     *
     * @param enemy
     * @param loc
     * @return
     */
    public abstract boolean attack(Player enemy, Location loc);

    /**
     * Construct an instance of
     *
     *   AircraftCarrier,
     *   Destroyer,
     *   Submarine,
     *   Cruiser, and
     *   PatrolBoat
     *
     * and add them to this Player's list of ships.
     */
    public abstract void populateShips();
}
