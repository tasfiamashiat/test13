/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.24.0-ec89fde modeling language!*/
package lab2;


/**
 * Purchase of a certain number of a particular item
 */
// line 46 "model.ump"
// line 83 "model.ump"
public class Purchase
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Purchase Attributes
  private String numberOfItems;

  //Purchase Associations
  private Item item;
  private MembershipCard membershipCard;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Purchase(String aNumberOfItems, Item aItem)
  {
    numberOfItems = aNumberOfItems;
    boolean didAddItem = setItem(aItem);
    if (!didAddItem)
    {
      throw new RuntimeException("Unable to create purchase due to item");
    }
    System.out.println("A purchase has been done for "+aNumberOfItems+" For the item with price " +aItem.getDefaultPriceInCents());
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setNumberOfItems(String aNumberOfItems)
  {
    boolean wasSet = false;
    numberOfItems = aNumberOfItems;
    wasSet = true;
    return wasSet;
  }

  public String getNumberOfItems()
  {
    return numberOfItems;
  }

  public Item getItem()
  {
    return item;
  }

  public MembershipCard getMembershipCard()
  {
    return membershipCard;
  }

  public boolean hasMembershipCard()
  {
    boolean has = membershipCard != null;
    return has;
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
      existingItem.removePurchase(this);
    }
    item.addPurchase(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setMembershipCard(MembershipCard aMembershipCard)
  {
    boolean wasSet = false;
    MembershipCard existingMembershipCard = membershipCard;
    membershipCard = aMembershipCard;
    if (existingMembershipCard != null && !existingMembershipCard.equals(aMembershipCard))
    {
      existingMembershipCard.removePurchase(this);
    }
    if (aMembershipCard != null)
    {
      aMembershipCard.addPurchase(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Item placeholderItem = item;
    this.item = null;
    placeholderItem.removePurchase(this);
    if (membershipCard != null)
    {
      MembershipCard placeholderMembershipCard = membershipCard;
      this.membershipCard = null;
      placeholderMembershipCard.removePurchase(this);
    }
  }


  public String toString()
  {
    String outputString = "";
    return super.toString() + "["+
            "numberOfItems" + ":" + getNumberOfItems()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "item = "+(getItem()!=null?Integer.toHexString(System.identityHashCode(getItem())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "membershipCard = "+(getMembershipCard()!=null?Integer.toHexString(System.identityHashCode(getMembershipCard())):"null")
     + outputString;
  }
}