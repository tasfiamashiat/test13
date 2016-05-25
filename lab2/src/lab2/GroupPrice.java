/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.24.0-ec89fde modeling language!*/
package lab2;


/**
 * Price for bulk purchases
 */
// line 53 "model.ump"
// line 88 "model.ump"
public class GroupPrice
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //GroupPrice Attributes
  private int priceInCents;

  //GroupPrice Associations
  private Item item;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public GroupPrice(int aPriceInCents, int i, Item aItem)
  {
    priceInCents = aPriceInCents;
    boolean didAddItem = setItem(aItem);
    if (!didAddItem)
    {
      throw new RuntimeException("Unable to create groupPrice due to item");
    }
    System.out.println("A group price "+aPriceInCents + "  for item with price "+aItem.getDefaultPriceInCents()+ "  has been created.");
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setPriceInCents(int aPriceInCents)
  {
    boolean wasSet = false;
    priceInCents = aPriceInCents;
    wasSet = true;
    return wasSet;
  }

  public int getPriceInCents()
  {
    return priceInCents;
  }

  public Item getItem()
  {
    return item;
  }

  public boolean setItem(Item aItem)
  {
    boolean wasSet = false;
    if (aItem == null)
    {
      return wasSet;
    }

    Item existingItem = item;
    item = aItem;
    if (existingItem != null && !existingItem.equals(aItem))
    {
      existingItem.removeGroupPrice(this);
    }
    item.addGroupPrice(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Item placeholderItem = item;
    this.item = null;
    placeholderItem.removeGroupPrice(this);
  }


  public String toString()
  {
    String outputString = "";
    return super.toString() + "["+
            "priceInCents" + ":" + getPriceInCents()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "item = "+(getItem()!=null?Integer.toHexString(System.identityHashCode(getItem())):"null")
     + outputString;
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 55 model.ump
  Integer numberToBuyToGetPrice;
  
}