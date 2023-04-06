public class Cruiser extends Ship
{
    /**
     * Construct a Cruiser with a length
     * of 3 and the specified Locations.
     *
     * @param locations Using the array type locations it constructs the Cruiser
     */
    public Cruiser(Location... locations)
    {
        super(3);
        super.addLocation(locations);
    }
}
