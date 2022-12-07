package design.mediator;

/**
 * @author shuaishuai.wang
 * @date 2022-09-23
 **/
public class MediatorStructure implements Mediator {

    private HouseOwner houseOwner;

    private Tenant tenant;

    public HouseOwner getHouseOwner() {
        return houseOwner;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setHouseOwner(HouseOwner houseOwner) {
        this.houseOwner = houseOwner;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    @Override
    public void contact(String message, Person person) {
        if (person == houseOwner) {
            tenant.getMessage(message);
        } else {
            houseOwner.getMessage(message);
        }
    }


    public static void main(String[] args) {
        MediatorStructure mediator = new MediatorStructure();
        HouseOwner houseOwner = new HouseOwner("qq", mediator);
        Tenant tenant = new Tenant("jj", mediator);
        mediator.setHouseOwner(houseOwner);
        mediator.setTenant(tenant);

        tenant.contact("i wanna a house");
        houseOwner.contact("i have");
    }
}
