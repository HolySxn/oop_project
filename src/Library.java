import java.util.ArrayList;
import java.util.List;

class Library {
    private List<Item> items;

    public Library() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(int id) {
        items.removeIf(item -> item.id == id);
    }

    public void borrowItem(String title) {
        for (Item item : items) {
            if (item instanceof Book && item.name.equals(title) && ((Book) item).isAvailable()) {
                ((Book) item).setAvailable(false);
                System.out.println("Book '" + title + "' borrowed successfully.");
                return;
            }
        }
        System.out.println("Book '" + title + "' not available for borrowing.");
    }

    public void returnItem(String title) {
        for (Item item : items) {
            if (item instanceof Book && item.name.equals(title) && !((Book) item).isAvailable()) {
                ((Book) item).setAvailable(true);
                System.out.println("Book '" + title + "' returned successfully.");
                return;
            }
        }
        System.out.println("Book '" + title + "' not found or already returned.");
    }

    public void displayAvailableItems() {
        System.out.println("Available Items:");
        for (Item item : items) {
            if (item instanceof Book && ((Book) item).isAvailable()) {
                item.displayDetails();
            }
        }
    }

    public List<Item> getItems() {
        return items;
    }
}
