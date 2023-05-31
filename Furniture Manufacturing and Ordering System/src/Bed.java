
public class Bed implements IProduct {

	private FactoryLine<Object> MarketingAnalyst;
	private Warehouses<Object> StorageChief;
	private SoldProducts<Object> Customer;

	
	
	public Bed(FactoryLine<Object> marketingAnalyst, Warehouses<Object> storageChief, SoldProducts<Object> customer) {
		MarketingAnalyst = marketingAnalyst;
		StorageChief = storageChief;
		Customer = customer;
	}
	@Override
	public boolean isManufactured(Object product) {
		return MarketingAnalyst.contains(product);
	}
	@Override
	public boolean isStored(Object product) {
		return StorageChief.contains(StorageChief.getBed_warehouse(),StorageChief.getTop_bed_warehouse(),product);
	}
	@Override
	public boolean isSold(Object product) {
		return Customer.contains(product);
	}

	
}
