package challenges.algorithms.datastructure.arrays;

import java.util.*;
import java.util.stream.Collectors;

public class FilterClient {
    public static void main(String[] args) {
        Client client1 = new Client("david", 25);
        Client client2 = new Client("mateo", 18);
        Client client3 = new Client("dover", 31);
        Client client4 = new Client("ruben", 40);
        List<Client> allClients = Arrays.asList(client2, client3, client4,client1);
        System.out.println(filterClients(allClients));
    }

    public static List<Client> filterClients(List<Client> allClients) {
        return allClients.stream()
                .filter(i -> i.getAge() > 21)
                .map(client -> {
                    client.setName(client.getName().toUpperCase());
                    return client;
                })
                .sorted(Comparator.comparing(Client::getName))
                .collect(Collectors.toList());
    }
}
