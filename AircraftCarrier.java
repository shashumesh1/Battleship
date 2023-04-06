public class AircraftCarrier extends Ship
{
    /**
     * Construct an AircraftCarrier with a length
     * of 5 and the specified Locations.
     *
     * @param locations Using the array type locations it constructs the aircraftCarrier
     */
    public AircraftCarrier(Location... locations)
    {
        super(5);
        super.addLocation(locations);
    }
}
