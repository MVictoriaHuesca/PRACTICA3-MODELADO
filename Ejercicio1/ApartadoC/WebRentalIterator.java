import java.util.List;
import java.util.NoSuchElementException;

public class WebRentalIterator implements Iterator<WebRental> {
    
    private List<WebRental> webRentals;
    private int position;

    public WebRentalIterator(List<WebRental> webRentals) {
        assert(webRentals != null);
        this.webRentals = webRentals;
        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < webRentals.size();
    }

    @Override
    public WebRental next() {
        if (!hasNext()) throw new NoSuchElementException();
        return webRentals.get(position++);
    }
}