package src;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc)
	{
		if(qtyOrdered >= 20) 
		{
			System.out.println("The cart is already full !");
			return;
		}
		itemsOrdered[qtyOrdered++] = disc;
		System.out.println("The DVD has been added");
		if(qtyOrdered >= 15)
		{
			System.out.println("The cart is almost full!");
		}
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc)
	{
		if(qtyOrdered == 0) 
		{
			System.out.println("The cart is already empty!");
			 return;
		}
		for(int i = 0; i < qtyOrdered; i++)
		{
			if(itemsOrdered[i] == disc)
			{
				for(int j = i; j < qtyOrdered - 1; j++)
				{
					itemsOrdered[j] = itemsOrdered[j+1];
				}
				itemsOrdered[qtyOrdered - 1] = null;
				qtyOrdered--;
				System.out.println("The DVD has been removed");
				return;
			}
		}
		System.out.println("The DVD was not found in the cart");
	}
	
	public float totalCost()
	{
		float sum = 0;
		for(int i = 0; i < qtyOrdered; i++)
		{
			sum += itemsOrdered[i].getCost();
		}
		return sum;
	}
	
	public void printCart()
	{
		System.out.println("\n--------------------------------");
		if(qtyOrdered == 0)
		{
			System.out.println("The cart is empty!");
			System.out.println("--------------------------------");
			return;
		}
		for(int i = 0; i < qtyOrdered; i++)
		{
			System.out.printf("%d. %-20s %.2f\n",
	                (i + 1),
	                itemsOrdered[i].getTitle(),
	                itemsOrdered[i].getCost());
		}
		
		System.out.println("Total Cost: " + totalCost());
		System.out.println("--------------------------------\n");
	}
}
