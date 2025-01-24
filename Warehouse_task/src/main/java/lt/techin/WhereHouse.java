package lt.techin;

import lt.itakademija.exam.*;
import lt.itakademija.exam.Package;

import java.util.ArrayList;
import java.util.List;


public class WhereHouse extends Warehouse {

    private final List<Client> clients = new ArrayList<>();
    private List<Package> packages = new ArrayList<>();


    public WhereHouse(IdGenerator clientIdGenerator, IdGenerator packageIdGenerator, int totalSpace) {
        super(clientIdGenerator, packageIdGenerator, totalSpace);

        if(totalSpace <= 0) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public int getTotalSpace() {
        return super.totalSpace;
    }

    @Override
    public int getAvailableSpace() {
        return getTotalSpace() - getReservedSpace();
    }

    @Override
    public int getTotalAvailableSpace() {
        int sum = clients.stream().flatMap(a -> a.getPackages().stream()).mapToInt(Package::getSpace).sum();
        return getTotalSpace() - sum;
    }

    @Override
    public int getReservedSpace() {
        return clients.stream().mapToInt(Client::getReservedSpace).sum();
    }

    @Override
    public Client registerClient(String name, int reservingSpace) {
        if(getAvailableSpace() < reservingSpace) {
            throw new InsufficientSpaceException("Not enough space");
        }

        if(reservingSpace <= 0) {
            throw new IllegalArgumentException();
        }

        Client clientToAdd = new Client(clientIdGenerator.generateId(), name, reservingSpace);
        clients.add(clientToAdd);
        return clientToAdd;
    }

    @Override
    public Package createPackage(String name, int space) {
        if(space <= 0) {
            throw new IllegalArgumentException();
        }
        Package packageToAdd =  new Package(packageIdGenerator.generateId(), name, space);
//        packages.add(packageToAdd);
        return packageToAdd;
    }

    @Override
    public void storePackage(Client client, Package aPackage) {
        if(client.getAvailableSpace() < aPackage.getSpace()) {
            throw new InsufficientSpaceException("Not enough space");
        }
        client.addPackage(aPackage);
    }

    @Override
    public Client getClientById(int i) {
        return clients.stream().filter(a -> a.getId() == i).findFirst().orElse(null);
    }

    @Override
    public boolean hasClientById(int i) {
        return clients.stream().anyMatch(a -> a.getId() == i);
    }

    @Override
    public List<Client> findClientsBy(ClientPredicate clientPredicate) {
        return clients.stream().filter(a -> clientPredicate.test(a)).toList();
    }
}
