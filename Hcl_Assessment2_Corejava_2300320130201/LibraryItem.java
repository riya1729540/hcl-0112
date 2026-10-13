package Hcl_Assessment2_Corejava_2300320130201;
import java.time.Year;
import java.util.*;

public abstract class LibraryItem implements Borrowable
{
            private static int nextId = 1001;
            private int id;
            private String title;
            private int year;
            private boolean available;
            public LibraryItem(String title, int year) {

                if (title == null || title.trim().isEmpty()) {
                    throw new IllegalArgumentException("Title cannot be blank");
                }

                int currentYear = Year.now().getValue();

                if (year < 1000 || year > currentYear) {
                    throw new IllegalArgumentException(
                            "Year must be between 1000 and " + currentYear
                    );
                }

                this.id = nextId;
                nextId++;
                this.title = title;
                this.year = year;
                this.available = true;
            }

            public int getId()
            {
                return id;
            }

            public String getTitle()
            {
                return title;
            }

            public int getYear()
            {
                return year;
            }

            public boolean isAvailable() {
                return available;
            }

            public void setAvailable(boolean available) {
                this.available = available;
            }

            public abstract double lateFee(int daysLate);

            public abstract String getItemType();

            @Override
            public boolean equals(Object obj) {

                if (this == obj) {
                    return true;
                }

                if (!(obj instanceof LibraryItem)) {
                    return false;
                }

                LibraryItem other = (LibraryItem) obj;

                return this.id == other.id;
            }

            @Override
            public int hashCode() {
                return Objects.hash(id);
            }

            @Override
            public String toString() {

                return "ID: " + id +
                        ", Title: " + title +
                        ", Year: " + year +
                        ", Type: " + getItemType() +
                        ", Available: " + available;
            }

}
