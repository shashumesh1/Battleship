public class Submarine extends Ship
{
    /**
     * Construct a Submarine with a length
     * of 3 and the specified Locations.
     *
     * @param locations Using the array type locations it constructs the Submarine
     */
    public Submarine(Location... locations)
    {
        super(3);
        super.addLocation(locations);
    }
}
