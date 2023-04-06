import java.util.Random;

public class ComputerPlayer extends Player
{
    public ComputerPlayer(String name)
    {
        super(name);
    }

    /**
     * Randomly chooses a Location that has not been
     *   attacked (Location loc is ignored).  Marks
     *   the attacked Location on the guess board
     *   with a positive number if the enemy Player
     *   controls a ship at the Location attacked;
     *   otherwise, if the enemy Player does not
     *   control a ship at the attacked Location,
     *   guess board is marked with a negative number.
     *
     * If the enemy Player controls a ship at the attacked
     *   Location, the ship must add the Location to its
     *   hits taken.  Then, if the ship has been sunk, it
     *   is removed from the enemy Player's list of ships.
     *
     * Return true if the attack resulted in a ship sinking;
     *   false otherwise.
     *
     * @param enemy The Player to attack.
     * @param loc The Location to attack.
     * @return Returns a boolean value if the ship sunk due to attack
     */
    @Override
    public boolean attack(Player enemy, Location loc)
    {
        int r = (int) (Math.random() * 10);
        int c = (int) (Math.random() * 10);
        while(getGuessBoard()[r][c] != 0)
        {
            r = (int) (Math.random() * 10);
            c = (int) (Math.random() * 10);
        }
        Location loctn = new Location(r, c);

        if(enemy.hasShipAtLocation(loctn))
        {
            getGuessBoard()[r][c] = 1;
            enemy.getShip(loctn).takeHit(loctn);

            if(enemy.getShip(loctn).isSunk())
            {
                enemy.removeShip(enemy.getShip(loctn));
                return true;
            }
        }
        else
        {
            getGuessBoard()[r][c] = -1;
        }
        return false;
    }

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
    @Override
    public void populateShips()
    {
        Location[] acarrier = new Location[5];
        for (int j = 0; j < acarrier.length; j++)
        {
            acarrier[j] = new Location(5, 1 + j);
        }
        AircraftCarrier acraftCarrier = new AircraftCarrier(acarrier);
        addShip(acraftCarrier);

        Location[] destroyer = new Location[4];
        for (int j = 0; j < destroyer.length; j++)
        {
            destroyer[j] = new Location(1, 5 + j);
        }
        Destroyer dstryer = new Destroyer(destroyer);
        addShip(dstryer);

        Location[] cruiser = new Location[3];
        for (int j = 0; j < cruiser.length; j++)
        {
            cruiser[j] = new Location(4, 7 + j);
        }
        Cruiser crser = new Cruiser(cruiser);
        addShip(crser);

        Location[] subm = new Location[3];
        for (int j = 0; j < subm.length; j++)
        {
            subm[j] = new Location(1 + j, 1);
        }
        Submarine submarine = new Submarine(subm);
        addShip(submarine);

        Location[] pBoat = new Location[2];
        for (int j = 0; j < pBoat.length; j++)
        {
            pBoat[j] = new Location(8, 7 + j);
        }
        PatrolBoat patrolBoat = new PatrolBoat(pBoat);
        addShip(patrolBoat);
    }
}
