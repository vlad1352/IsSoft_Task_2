package by.IsSoftTasks.domain;

public class OrderItem {

    private String name;
    private Long countOfItems;
    private Long cost;

    public OrderItem(String name, Long countOfItems, Long cost) {
        this.name = name;
        this.countOfItems = countOfItems;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCountOfItems() {
        return countOfItems;
    }

    public void setCountOfItems(Long countOfItems) {
        this.countOfItems = countOfItems;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }
}

