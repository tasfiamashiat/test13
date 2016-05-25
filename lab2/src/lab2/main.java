package lab2;


public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		     Store Mystore=new Store("Flora");
		     Item earings=new Item(false,false,7000);
		     Item watch=new Item(false,true,1500);
		     Item dresses=new Item(true,false,7550);
		     MembershipCardType special_member=new MembershipCardType("specialMiles");
		     MembershipCard special_card=new MembershipCard(12233, special_member) ;
		     SpecialPrice special_price = new SpecialPrice(770, watch, special_member);
		     GroupPrice PriceOfdresses = new GroupPrice(300, 2, dresses);
		     Purchase purchase_of_earings=new Purchase("7", earings);
		     
		     
		     System.out.println("First item: "+earings);
		     System.out.println("Second item: "+watch);
		     System.out.println("Third item: "+dresses);
		     System.out.println("Special price: "+special_price);
		     System.out.println("GroupPrice: " + PriceOfdresses);
		     System.out.println("MembershipCardNumber: " + special_card);
		     System.out.println("Purchase: " + purchase_of_earings);

			}

		

	}


