public class Location
{
    private int row;
    private int col;

    public Location(int row, int col)
    {
        this.row = row;
        this.col = col;
    }

    public int getRow()
    {
        return row;
    }

    public int getCol()
    {
        return col;
    }

    @Override
    public boolean equals(Object obj)
    {
        Location loctn = (Location) obj;
        return (col == loctn.getCol()) && (row == loctn.getRow());
    }
}