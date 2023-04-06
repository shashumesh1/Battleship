public class HumanPlayer extends Player
{
    public HumanPlayer(String name)
    {
        super(name);
    }

    /**
     * Attack the specified Location loc.  Marks
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
     * @param enemy Represents the enemy player
     * @param loc Represents the location being attacked
     * @return true if the attack resulted in a ship sinking; false otherwise
     */
    @Override
    public boolean attack(Player enemy, Location loc)
    {
        int r = loc.getRow();
        int c = loc.getCol();
        if(enemy.hasShipAtLocation(loc))
        {
            getGuessBoard()[r][c] = 1;
            enemy.getShip(loc).takeHit(loc);

            if(enemy.getShip(loc).isSunk())
            {
                enemy.removeShip(enemy.getShip(loc));
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
            acarrier[j] = new Location(3, 4 + j);
        }
        AircraftCarrier acraftCarrier = new AircraftCarrier(acarrier);
        addShip(acraftCarrier);

        Location[] destroyer = new Location[4];
        for (int j = 0; j < destroyer.length; j++)
        {
            destroyer[j] = new Location(9, 2 + j);
        }
        Destroyer dstryer = new Destroyer(destroyer);
        addShip(dstryer);

        Location[] cruiser = new Location[3];
        for (int j = 0; j < cruiser.length; j++)
        {
            cruiser[j] = new Location(j, 1);
        }
        Cruiser crser = new Cruiser(cruiser);
        addShip(crser);

        Location[] subm = new Location[3];
        for (int j = 0; j < subm.length; j++)
        {
            subm[j] = new Location(6 + j, 7);
        }
        Submarine submarine = new Submarine(subm);
        addShip(submarine);

        Location[] pBoat = new Location[2];
        for (int j = 0; j < pBoat.length; j++)
        {
            pBoat[j] = new Location(5, 1 + j);
        }
        PatrolBoat patrolBoat = new PatrolBoat(pBoat);
        addShip(patrolBoat);
    }
}
