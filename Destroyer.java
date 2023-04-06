public class Destroyer extends Ship
{
    /**
     * Construct a Destroyer with a length
     * of 4 and the specified Locations.
     *
     * @param locations Using the array type locations it constructs the Destroyer
     */
    public Destroyer(Location... locations)
    {
        super(4);
        super.addLocation(locations);
    }
}