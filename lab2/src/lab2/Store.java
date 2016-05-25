/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.24.0-ec89fde modeling language!*/
package lab2;

import java.util.*;

/**
 * Model of the grocery store problem as found in the textbook on E90 b (p185)
 * and in the course notes, chapter 5, p39
 */
// line 5 "model.ump"
// line 58 "model.ump"
public class Store
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Store Attributes
  private String id;

  //Store Associations
  private List<Item> items;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Store(String aId)
  { System.out.println("A store has been created with an ID "+ aId);
    id = aId;
    items = new ArrayList<Item>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setId(String aId)
  {
    boolean wasSet = false;
    id = aId;
    wasSet = true;
    return wasSet;
  }

  public String getId()
  {
    return id;
  }

  public Item getItem(int index)
  {
    Item aItem = items.get(index);
    return aItem;
  }

  public List<Item> getItems()
  {
    List<Item> newItems = Collections.unmodifiableList(items);
    return newItems;
  }

  public int numberOfItems()
  {
    int number = items.size();
    return number;
  }

  public boolean hasItems()
  {
    boolean has = items.size() > 0;
    return has;
  }

  public int indexOfItem(Item aItem)
  {
    int index = items.indexOf(aItem);
    return index;
  }

  public static int minimumNumberOfItems()
  {
    return 0;
  }

  public boolean addItem(Item aItem)
  {
    boolean wasAdded = false;
    if (items.contains(aItem)) { return false; }
    Store existingStockedIn = aItem.getStockedIn();
    if (existingStockedIn == null)
    {
      aItem.setStockedIn(this);
    }
    else if (!this.equals(existingStockedIn))
    {
      existingStockedIn.removeItem(aItem);
      addItem(aItem);
    }
    else
    {
      items.add(aItem);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeItem(Item aItem)
  {
    boolean wasRemoved = false;
    if (items.contains(aItem))
    {
      items.remove(aItem);
      aItem.setStockedIn(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addItemAt(Item aItem, int index)
  {  
    boolean wasAdded = false;
    if(addItem(aItem))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfItems()) { index = numberOfItems() - 1; }
      items.remove(aItem);
      items.add(index, aItem);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveItemAt(Item aItem, int index)
  {
    boolean wasAdded = false;
    if(items.contains(aItem))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfItems()) { index = numberOfItems() - 1; }
      items.remove(aItem);
      items.add(index, aItem);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addItemAt(aItem, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    while( !items.isEmpty() )
    {
      items.get(0).setStockedIn(null);
    }
  }


  public String toString()
  {
    String outputString = "";
    return super.toString() + "["+
            "id" + ":" + getId()+ "]"
     + outputString;
  }
}