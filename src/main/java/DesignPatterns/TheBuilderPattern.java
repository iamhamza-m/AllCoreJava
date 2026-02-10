package DesignPatterns;

class StoreItems{
	private final String name;
	private final Long price;
	private final String shortDescription;
	private final String longDescription;
	private final Integer stockAvailable;
	private final String packagingType;
	
	public StoreItems(String name, Long price, String shortDescription, String longDescription, Integer stockAvailable, String packagingType) {
		this.name = name;
		this.price = price;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
		this.stockAvailable = stockAvailable;
		this.packagingType = packagingType;
		
		if(name == null || price == null){
			throw new IllegalArgumentException("The product name and price cannot be empty");
		}
	}
	
	@Override
	public String toString() {
		return "StoreItems{" +
					   "name='" + name + '\'' +
					   ", price=" + price +
					   ", shortDescription='" + shortDescription + '\'' +
					   ", longDescription='" + longDescription + '\'' +
					   ", stockAvailable=" + stockAvailable +
					   ", packagingType='" + packagingType + '\'' +
					   '}';
	}
	
	static class StoreItemBuilder {
		
		private final String name;
		private final Long price;
		private String shortDescription;
		private String longDescription;
		private Integer stockAvailable;
		private String packagingType;
		
		public StoreItemBuilder(String name, Long price){
			this.name = name;
			this.price = price;
		}
		
		public StoreItemBuilder shortDescription(String shortDescription){
			this.shortDescription = shortDescription;
			return this;
		}
		
		public StoreItemBuilder longDescription(String longDescription){
			this.longDescription = longDescription;
			return this;
		}
		
		public StoreItemBuilder stockAvailable(Integer stockAvailable){
			this.stockAvailable = stockAvailable;
			return this;
		}
		
		public StoreItemBuilder packagingType(String packagingType){
			this.packagingType = packagingType;
			return this;
		}
		
		public StoreItems build(){
			return new StoreItems(name, price, shortDescription, longDescription, stockAvailable, packagingType);
		}
	}
	
	
}

public class TheBuilderPattern {
	
	static void main(String[] args) {
		
		StoreItems s1 = new StoreItems.StoreItemBuilder("Adidas Shoes", 12000L).build();
		System.out.println("The first instance created " + s1);
		StoreItems s2 = new StoreItems.StoreItemBuilder("Shirt", 13000L)
								.shortDescription("These are boys wear")
								.longDescription("These are boys essential wear and very popular among Gen-Z")
								.build();
		
		System.out.println("The second instance created " + s2 );
	
	}
	
}
