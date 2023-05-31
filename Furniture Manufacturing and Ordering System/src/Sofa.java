
public class Sofa implements IProduct {
	

	private FactoryLine<Object> MarketingAnalyst;
	private Warehouses<Object> StorageChief;
	private SoldProducts<Object> Customer;
	

	public Sofa(FactoryLine<Object> marketingAnalyst, Warehouses<Object> storageChief, SoldProducts<Object> customer) {
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
		return StorageChief.contains(StorageChief.getSofa_warehouse(),StorageChief.getTop_sofa_warehouse(),product);
	}

	@Override
	public boolean isSold(Object product) {
		return Customer.contains(product);
	}
	
	

}
