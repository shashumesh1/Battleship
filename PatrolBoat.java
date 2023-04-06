public class PatrolBoat extends Ship
{
    /**
     * Construct a PatrolBoat with a length
     * of 2 and the specified Locations.
     *
     * @param locations Using the array type locations it constructs the PatrolBoat
     */
    public PatrolBoat(Location... locations)
    {
        super(2);
        super.addLocation(locations);
    }
}
